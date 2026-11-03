package com.recommendation.controller;

import com.recommendation.model.Recommendation;
import com.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RecommendationController {
    @Autowired
    private RecommendationService service;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> home() {
        Map<String, Object> res = new HashMap<>();
        res.put("project", "98-recommendation-engine");
        res.put("status", "Live - Recommendation Engine - Tier 10 Scale");
        res.put("tier", "10 - System Design Level - Caching + Security + Testing + Design Patterns");
        res.put("caching", "Caffeine Cache - recommendations cache - 1000 max, 600s expire - Stats enabled - Redis ready");
        res.put("recommendation", "Recommendation Pattern - Collaborative Content Hybrid");
        res.put("security", "X-Content-Type-Options nosniff, X-Frame-Options DENY, XSS Protection");
        res.put("designPatterns", List.of("Builder Pattern - Recommendation.Builder", "Strategy Pattern - Collaborative vs Content vs Hybrid", "Repository Pattern", "Caching Pattern"));
        res.put("port", "8100");
        res.put("testing", "JUnit 5 + Mockito - 6 tests");
        res.put("live", "https://nine8-recommendation-engine.onrender.com");
        res.put("owner", "Raviteja");
        return ResponseEntity.ok(res);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> res = new HashMap<>();
        res.put("status", "UP");
        res.put("cache", "Active - Caffeine - recommendations, recommendation - Stats enabled");
        res.put("security", "Headers Active");
        res.put("recommendation", "Active - Recommendation Pattern - Collaborative Content Hybrid - Strategy Pattern");
        res.put("project", "98-recommendation-engine");
        res.put("githubGoal", "CONTRIBUTING.md + Issues + Release Tags + Badges + Live Link + Architecture Diagram - Tier 10 Goal");
        return ResponseEntity.ok(res);
    }

    @PostMapping("/api/recommend")
    public ResponseEntity<Map<String, Object>> recommend(@RequestParam String userId, @RequestParam String itemId, 
            @RequestParam String itemName, @RequestParam String category, @RequestParam Double score, @RequestParam String reason) {
        if (userId == null || userId.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "userId cannot be empty"));
        }
        Recommendation rec = service.recommend(userId, itemId, itemName, category, score, reason);
        Map<String, Object> res = new HashMap<>();
        res.put("id", rec.getId());
        res.put("userId", rec.getUserId());
        res.put("itemName", rec.getItemName());
        res.put("category", rec.getCategory());
        res.put("score", rec.getScore());
        res.put("reason", rec.getReason());
        res.put("recommendedAt", rec.getRecommendedAt());
        res.put("viewCount", rec.getViewCount());
        res.put("message", "Recommended - Cache Evicted - Builder Pattern - Recommendation Pattern");
        res.put("cache", "recommendations cache evicted");
        res.put("recommendUrl", "/api/recommendations/" + userId);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/api/recommendations")
    public ResponseEntity<List<Recommendation>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Cache", "Caffeine - recommendations");
        headers.add("Cache-Control", "public, max-age=3600");
        return ResponseEntity.ok().headers(headers).body(service.getAllRecommendations());
    }

    @GetMapping("/api/recommendations/{userId}")
    public ResponseEntity<Map<String, Object>> getByUser(@PathVariable String userId, @RequestParam(defaultValue = "hybrid") String strategy) {
        List<Recommendation> recs = service.getRecommendations(userId, strategy);
        Map<String, Object> res = new HashMap<>();
        res.put("userId", userId);
        res.put("strategy", strategy.equalsIgnoreCase("collaborative") ? "Collaborative-Strategy" : strategy.equalsIgnoreCase("content") ? "Content-Strategy" : "Hybrid-Strategy");
        res.put("count", recs.size());
        res.put("engine", "Recommendation-Pattern - collaborative filtering + content-based + hybrid");
        res.put("results", recs);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Recommendation-Strategy", (String) res.get("strategy"));
        headers.add("X-Cache", "Caffeine");
        return ResponseEntity.ok().headers(headers).body(res);
    }

    @GetMapping("/api/recommendations/search")
    public ResponseEntity<Map<String, Object>> searchByCategory(@RequestParam String category) {
        List<Recommendation> recs = service.searchByCategory(category);
        Map<String, Object> res = new HashMap<>();
        res.put("category", category);
        res.put("count", recs.size());
        res.put("results", recs);
        return ResponseEntity.ok(res);
    }
}