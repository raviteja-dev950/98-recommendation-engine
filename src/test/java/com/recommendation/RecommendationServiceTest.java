package com.recommendation;

import com.recommendation.model.Recommendation;
import com.recommendation.repository.RecommendationRepository;
import com.recommendation.service.RecommendationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecommendationServiceTest {
    @Mock
    private RecommendationRepository repository;

    @InjectMocks
    private RecommendationService service;

    @Test
    void testBuilderPattern() {
        Recommendation rec = new Recommendation.Builder()
                .userId("user1")
                .itemId("item1")
                .itemName("Laptop")
                .category("Electronics")
                .score(4.8)
                .reason("collaborative filtering - similar users liked")
                .recommendedAt(LocalDateTime.now())
                .build();
        assertNotNull(rec);
        assertEquals("user1", rec.getUserId());
        assertEquals("Laptop", rec.getItemName());
        System.out.println("Builder Pattern Test Passed: " + rec.getItemName());
    }

    @Test
    void testRecommendationEntity() {
        Recommendation rec = new Recommendation();
        rec.setUserId("user2");
        rec.setItemName("Phone");
        rec.setCategory("Electronics");
        rec.setScore(4.5);
        assertEquals("user2", rec.getUserId());
        System.out.println("Recommendation Entity Test Passed");
    }

    @Test
    void testFormatRecommendationInfo() {
        Recommendation rec = new Recommendation.Builder()
                .userId("user1")
                .itemName("Laptop")
                .score(4.8)
                .reason("content-based")
                .build();
        String info = service.formatRecommendationInfo(rec);
        assertTrue(info.contains("Laptop"));
        System.out.println("Format Recommendation Test Passed: " + info);
    }

    @Test
    void testGetRecommendationById_Mockito() {
        Recommendation rec = new Recommendation.Builder().userId("user1").itemName("Laptop").build();
        rec.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(rec));
        Recommendation result = service.getRecommendationById(1L);
        assertNotNull(result);
        assertEquals("Laptop", result.getItemName());
        verify(repository, times(1)).findById(1L);
        System.out.println("Mockito Test Passed: getRecommendationById - Mock Rec: " + result.getItemName());
    }

    @Test
    void testSearchByCategory_Mockito() {
        Recommendation rec = new Recommendation.Builder().category("Electronics").itemName("Laptop").build();
        when(repository.findByCategoryContainingIgnoreCase("Electronics")).thenReturn(Arrays.asList(rec));
        List<Recommendation> results = service.searchByCategory("Electronics");
        assertEquals(1, results.size());
        System.out.println("Search Test Passed: Found 1 rec for category Electronics - Strategy Pattern Collaborative");
    }

    @Test
    void testGetAllRecommendations_Mockito() {
        Recommendation r1 = new Recommendation.Builder().userId("user1").itemName("Laptop").build();
        Recommendation r2 = new Recommendation.Builder().userId("user2").itemName("Phone").build();
        when(repository.findAllByOrderByRecommendedAtDesc()).thenReturn(Arrays.asList(r1, r2));
        List<Recommendation> results = service.getAllRecommendations();
        assertEquals(2, results.size());
        verify(repository, times(1)).findAllByOrderByRecommendedAtDesc();
        System.out.println("Mockito Test Passed: getAllRecommendations - Mocked 2 recs - Caching: recommendations");
    }
}