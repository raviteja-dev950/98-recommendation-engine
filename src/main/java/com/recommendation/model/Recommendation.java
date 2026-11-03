package com.recommendation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "recommendation", indexes = {
    @Index(name = "idx_user", columnList = "userId"),
    @Index(name = "idx_category", columnList = "category")
})
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String userId;
    private String itemId;
    private String itemName;
    private String category;
    private Double score;
    private String reason;
    private LocalDateTime recommendedAt;
    private Integer viewCount = 0;

    public Recommendation() {}

    private Recommendation(Builder builder) {
        this.userId = builder.userId;
        this.itemId = builder.itemId;
        this.itemName = builder.itemName;
        this.category = builder.category;
        this.score = builder.score;
        this.reason = builder.reason;
        this.recommendedAt = builder.recommendedAt != null ? builder.recommendedAt : LocalDateTime.now();
        this.viewCount = 0;
    }

    public static class Builder {
        private String userId;
        private String itemId;
        private String itemName;
        private String category;
        private Double score;
        private String reason;
        private LocalDateTime recommendedAt;

        public Builder userId(String userId) { this.userId = userId; return this; }
        public Builder itemId(String itemId) { this.itemId = itemId; return this; }
        public Builder itemName(String itemName) { this.itemName = itemName; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder score(Double score) { this.score = score; return this; }
        public Builder reason(String reason) { this.reason = reason; return this; }
        public Builder recommendedAt(LocalDateTime recommendedAt) { this.recommendedAt = recommendedAt; return this; }
        public Recommendation build() { return new Recommendation(this); }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public LocalDateTime getRecommendedAt() { return recommendedAt; }
    public void setRecommendedAt(LocalDateTime recommendedAt) { this.recommendedAt = recommendedAt; }
    public Integer getViewCount() { return viewCount; }
    public void setViewCount(Integer viewCount) { this.viewCount = viewCount; }
}