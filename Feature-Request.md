---
name: Feature Request - 98 Recommendation Engine - Tier 10 SCALE
about: Suggest an idea for Recommendation Engine - Caching + Security + Builder + Strategy Collaborative Content Hybrid + JUnit Mockito + Redis Elasticsearch pattern
title: '[FEATURE] 98 Recommendation Engine - '
labels: enhancement, Tier 10, System Design, Recommendation
assignees: ''
---

**Is your feature request related to a problem? Please describe.**
A clear description - Example: I want Popular strategy, Trending strategy, viewCount increment on GET, collaborative matrix real, Elasticsearch real integration, Redis real, Pagination, Sorting by score, H2 to PostgreSQL, Add more categories, Add user similarity, Add item similarity

**Describe the solution you'd like**
- New strategy: Popular (most viewCount), Trending (recent recommendedAt), Top Rated (score > 4.5)
- viewCount increment: When GET /api/recommendations/{id} increment viewCount
- Collaborative matrix: Real user-item matrix + cosine similarity
- Elasticsearch real: Use ElasticsearchRepository + @Document + Elasticsearch client
- Redis real: Replace Caffeine with RedisCacheManager + RedisTemplate + Redis stats
- Pagination: Pageable + Page<Recommendation> + size + page params
- Sorting: Sort by score desc + recommendedAt desc + viewCount desc
- H2 to PostgreSQL: Production DB + Flyway migration + Docker compose PostgreSQL
- Categories: More categories + category hierarchy
- User similarity: Find similar users + recommend what similar users liked
- Item similarity: Find similar items by category + score

**Describe alternatives you've considered**
- Keep Caffeine but add Redis as secondary cache
- Keep in-memory recommendation but add Elasticsearch for search
- Keep simple Strategy Pattern but add Machine Learning

**Additional context**
Tier 10 SCALE 98/102 96% - Current features: Caching Caffeine 1000 max 600s Stats recordStats Redis ready + Security Headers nosniff DENY XSS + Builder Pattern Recommendation.Builder Fluent API + Strategy Pattern Collaborative vs Content vs Hybrid Netflix Amazon YouTube core + Repository Pattern + Caching Pattern + JUnit5 Mockito 6/6 Green Bar + viewCount + idx_user + idx_category + Recommendation Pattern Collaborative Content Hybrid sorted 4.8 4.5 + Docker Multi-Stage + Render Live 2m23s + CONTRIBUTING.md 12466 chars + Issues + Release Tags + 18 Badges + Live Link + Architecture Diagram + Flow Diagram - Roadmap 100% Compliant - Same as 97 - Add your feature to reach 100% for 99 Multi-tenant SaaS + 100 Audit Log + 101 SaaS Idea + 102 Capstone OSS = TIER 10 FINAL 10 PROJECTS - 96% DONE - Only 4 left to 100%

**Screenshots / Mockups**
If applicable, add screenshots or mockups - demo for new strategy Popular count 3 sorted by viewCount, Trending count 2 recent, Top Rated count 1 score > 4.5

**Tier 10 Compliance**
- Does it maintain Caching Caffeine 1000 max 600s Stats?
- Does it maintain Security Headers nosniff DENY XSS?
- Does it maintain Builder Pattern Recommendation.Builder?
- Does it maintain Strategy Pattern Collaborative vs Content vs Hybrid + new strategy?
- Does it maintain Repository Pattern JpaRepository + idx_user + idx_category?
- Does it maintain Caching Pattern Cache-aside + Stats enabled + Redis ready?
- Does it maintain JUnit5 Mockito 6/6 Green Bar + new test for new strategy?
- Does it maintain Redis pattern Caffeine 1000 max 600s Stats?
- Does it maintain Elasticsearch pattern Recommendation Pattern collaborative filtering + content-based + hybrid sorted by score + new strategy?
- Does it maintain Docker Multi-Stage + Render Live 2m23s?
- Does it maintain 18 Badges + Live Link + Architecture Diagram + CONTRIBUTING.md?
- Does it maintain 12 demos + new demo for new feature?

**Live URL:** https://nine8-recommendation-engine.onrender.com/
