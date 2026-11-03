package com.recommendation.repository;

import com.recommendation.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findAllByOrderByRecommendedAtDesc();
    List<Recommendation> findByUserIdOrderByScoreDesc(String userId);
    List<Recommendation> findByCategoryContainingIgnoreCase(String category);
    List<Recommendation> findByUserIdAndCategory(String userId, String category);
}