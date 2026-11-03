package com.recommendation.service;

import com.recommendation.model.Recommendation;
import com.recommendation.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {
    @Autowired
    private RecommendationRepository repository;

    @CacheEvict(value = "recommendations", allEntries = true)
    public Recommendation recommend(String userId, String itemId, String itemName, String category, Double score, String reason) {
        Recommendation rec = new Recommendation.Builder()
                .userId(userId)
                .itemId(itemId)
                .itemName(itemName)
                .category(category)
                .score(score)
                .reason(reason)
                .recommendedAt(LocalDateTime.now())
                .build();
        return repository.save(rec);
    }

    @Cacheable("recommendations")
    public List<Recommendation> getAllRecommendations() {
        return repository.findAllByOrderByRecommendedAtDesc();
    }

    @Cacheable("recommendation")
    public Recommendation getRecommendationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Strategy Pattern - Collaborative vs Content-based vs Hybrid
    public List<Recommendation> getRecommendations(String userId, String strategy) {
        List<Recommendation> all = repository.findByUserIdOrderByScoreDesc(userId);
        if (all.isEmpty()) {
            all = repository.findAllByOrderByRecommendedAtDesc();
        }
        if ("collaborative".equalsIgnoreCase(strategy)) {
            return all.stream().filter(r -> r.getReason() != null && r.getReason().contains("collaborative")).collect(Collectors.toList());
        } else if ("content".equalsIgnoreCase(strategy)) {
            return all.stream().filter(r -> r.getReason() != null && r.getReason().contains("content")).collect(Collectors.toList());
        } else if ("hybrid".equalsIgnoreCase(strategy)) {
            return all.stream().sorted((a,b) -> Double.compare(b.getScore(), a.getScore())).collect(Collectors.toList());
        }
        return all;
    }

    public List<Recommendation> searchByCategory(String category) {
        return repository.findByCategoryContainingIgnoreCase(category);
    }

    public String formatRecommendationInfo(Recommendation rec) {
        return String.format("Recommendation for %s: %s (%.2f) - %s", rec.getUserId(), rec.getItemName(), rec.getScore(), rec.getReason());
    }

    public boolean isRelevant(Recommendation rec, String interest) {
        if (interest == null || rec.getCategory() == null) return false;
        return rec.getCategory().toLowerCase().contains(interest.toLowerCase()) || 
               rec.getItemName().toLowerCase().contains(interest.toLowerCase());
    }
}