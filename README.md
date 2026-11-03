# 🚀 Project 98 – Recommendation Engine | System Design Level | Full Stack DevOps

[Java 17](https://img.shields.io/badge/Java-17-E76F00?logo=openjdk&logoColor=white)
[Spring Boot 3.2.5](https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=springboot&logoColor=white)
[Caching](https://img.shields.io/badge/Caching-Caffeine%201000%20max%20600s%20expire%20Stats-blue?logo=redis&logoColor=white)
[Cache Stats](https://img.shields.io/badge/Cache%20Stats-recordStats%20enabled-brightgreen)
[Security](https://img.shields.io/badge/Security-Headers%20nosniff%20DENY%20XSS-red?logo=springsecurity&logoColor=white)
[Builder Pattern](https://img.shields.io/badge/Builder%20Pattern-Recommendation.Builder%20Fluent%20API-success?logo=java&logoColor=white)
[Strategy Pattern](https://img.shields.io/badge/Strategy%20Pattern-Collaborative%20vs%20Content%20vs%20Hybrid-yellow?logo=elasticsearch&logoColor=white)
[Repository Pattern](https://img.shields.io/badge/Repository%20Pattern-JpaRepository-6DB33F)
[H2 Database](https://img.shields.io/badge/H2-Database%20recommenddb-003545?logo=h2&logoColor=white)
[viewCount](https://img.shields.io/badge/viewCount-Added%20%2B%20idx__user%20%2B%20idx__category-orange)
[JUnit 5](https://img.shields.io/badge/JUnit-5%206%2F6%20Green-25A162?logo=junit5&logoColor=white)
[Mockito](https://img.shields.io/badge/Mockito-Mocked%20Repo%20when%2Fverify-00BFFF)
[Recommendation Pattern](https://img.shields.io/badge/Recommendation-Pattern%20Collaborative%20Content%20Hybrid-blueviolet?logo=elasticsearch&logoColor=white)
[Docker](https://img.shields.io/badge/Docker-Multi--Stage-2496ED?logo=docker&logoColor=white)
[Render](https://img.shields.io/badge/Render-Live%202m23s-brightgreen?logo=render&logoColor=white)
[Tomcat](https://img.shields.io/badge/Apache%20Tomcat-10.1.20-D4AF00?logo=apachetomcat&logoColor=white)
[Port](https://img.shields.io/badge/Port-8100-00BFFF)
[Status](https://img.shields.io/badge/Status-Recommendation%20Engine%20Live%20Tier%2010-brightgreen)
[Tier 10](https://img.shields.io/badge/Tier%2010-System%20Design%20Level%20SCALE-blueviolet)

**Live URL:** https://nine8-recommendation-engine.onrender.com/

[[Live](https://img.shields.io/badge/Live-Render-brightgreen?style=for-the-badge&logo=render)](https://nine8-recommendation-engine.onrender.com)

Project 98 - Part of Java 102 Projects Challenge - System Design Level Tier 10 SCALE
---
**TIER 10 SCALE 98/102 - 96%**
---

# 📖 Project Overview

**Recommendation Engine** is Project 98 of **Tier 10 – System Design Level – SCALE PROJECT**, developed using **Java 17**, **Spring Boot 3.2.5**, **Spring Cache Caffeine (CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats() - Redis pattern ready)**, **Security Headers (SecurityHeadersConfig WebMvcConfigurer + HandlerInterceptor X-Content-Type-Options nosniff + X-Frame-Options DENY + X-XSS-Protection)**, **Design Patterns (Builder Pattern Recommendation.Builder Fluent API + Strategy Pattern Collaborative vs Content vs Hybrid + Repository Pattern JpaRepository + Caching Pattern Cache-aside)**, **Spring Data JPA**, **H2 Database recommenddb + view_count + idx_user + idx_category index**, **JUnit 5 + Mockito 6 tests Green Bar**, **Docker Multi-Stage (maven:3.9-eclipse-temurin-17 + eclipse-temurin:17-jdk-alpine + mkdir -p data)**, **Maven**, and **Apache Tomcat 10.1.20** in a **production System Design ready repo**.

Spring Boot REST API running on port 8100 locally (10000 on Render) with 7 endpoints + home `GET / returns live JSON {"project":"98-recommendation-engine","status":"Live - Recommendation Engine - Tier 10 Scale","tier":"10 - System Design Level - Caching + Security + Testing + Design Patterns","caching":"Caffeine Cache - recommendations cache - 1000 max, 600s expire - Stats enabled - Redis ready","recommendation":"Recommendation Pattern - Collaborative Content Hybrid"}`, `GET /health -> {"status":"UP","cache":"Active - Caffeine - recommendations, recommendation - Stats enabled","security":"Headers Active","recommendation":"Active - Recommendation Pattern - Collaborative Content Hybrid - Strategy Pattern"}`, `POST /api/recommend?userId=user1&itemId=item1&itemName=Laptop&category=Electronics&score=4.8&reason=collaborative filtering - similar users liked -> 200 OK {id, userId, itemName, category, score, reason, recommendedAt, viewCount, message: Recommended - Cache Evicted - Builder Pattern - Recommendation Pattern, cache: recommendations cache evicted, recommendUrl: /api/recommendations/user1}`, `GET /api/recommendations -> List Recommendation with viewCount + X-Cache: Caffeine`, `GET /api/recommendations/{userId}?strategy=collaborative -> Collaborative-Strategy count 1 + X-Recommendation-Strategy: Collaborative-Strategy`, `GET /api/recommendations/{userId}?strategy=content -> Content-Strategy count 1`, `GET /api/recommendations/{userId}?strategy=hybrid -> Hybrid-Strategy count 2 sorted by score 4.8 then 4.5 + X-Recommendation-Strategy: Hybrid-Strategy`, `GET /api/recommendations/search?category=Electronics -> count 2`. This repo contains **Recommendation.java Entity with Builder inner class**, **RecommendationRepository.java**, **RecommendationService.java**, **CacheConfig.java**, **SecurityHeadersConfig.java**, **RecommendationController.java**, **RecommendationServiceTest (JUnit 5 + Mockito 6 tests green)**. One `git push` gives full Recommendation Engine live.

This is Project 98 of Tier 10 - SCALE - After Search with Elastic (97), now real System Design base for Multi-tenant SaaS (99).

**Bug Fixed:** `Cannot load driver class: org.h2.Driver` - H2 scope runtime - Fixed by removing `<scope>runtime</scope>` + Maven Update Project + Force Update - Same pattern as Tier 9 H2 fix - 93-97 also.

**Bug Fixed:** `Unable to resolve name [org.hibernate.dialect.H2Dialect ] as strategy` - Extra newline space in application.properties - Fixed by removing `spring.jpa.database-platform` + `spring.datasource.driverClassName` lines - BUILD SUCCESS 13.796 sec.

**Bug Fixed:** `URL must start with 'jdbc'` - Typo `dbc:h2:mem:recommenddb` missing `j` - Fixed by correcting to `jdbc:h2:mem:recommenddb` - BUILD SUCCESS 13.796s Tier 10.

**Bug Fixed:** `RecommendationController.java red errors - cannot find symbol Cacheable, CaffeineCacheManager` - META-INF folder bug - Eclipse creates `src/main/resources/META-INF` breaking Maven + Maven dependencies not downloaded - Fixed by deleting META-INF + deleting target + Maven Update Project Force Update - Same as 93/94/95/96/97 META-INF bug.

**Bug Fixed:** `docker.io/library/openjdk:17-jdk-slim: not found` - OpenJDK image deleted from Docker Hub - Fixed by changing to `eclipse-temurin:17-jdk-alpine` - Render Deploy failed - Same as 94-97.

**Bug Fixed:** `COPY target/*.jar app.jar ERROR: lstat /target: no such file or directory` - Docker build doesn't run mvn package - Fixed by using Multi-Stage Dockerfile `FROM maven:3.9-eclipse-temurin-17 AS build + COPY pom.xml + COPY src + RUN mvn clean package -DskipTests + FROM eclipse-temurin:17-jdk-alpine + mkdir -p data + COPY --from=build /app/target/*.jar app.jar` - Deploy succeeded Live 2m23s - Same as 94-97.

**Bug Fixed:** `POST /api/recommend -> 400 Bad Request` - Query Params empty - Fixed by setting Params tab in Postman Key Value userId itemId itemName category score reason - Same as 97 index bug - Now 200 OK id 1 viewCount 0 - 257 ms 621 B.

**Bug Fixed:** `GET /api/recommendations/user1?strategy=content -> 405 Method Not Allowed` - Used POST but endpoint is GET - Fixed by changing Method to GET - Same as 96 bug - Now 200 OK count 1 Content-Strategy.

**Bug Fixed:** `Was 2/2 tests Tier 5 - Not Tier 10 compliant + UnnecessaryStubbingException` - Only Entity + Format tests - No Builder + No Mockito + No Caching + No Security + No CONTRIBUTING.md - Stubbing both `findAllByOrderByRecommendedAtDesc` and `findAll` in testGetAllRecommendations_Mockito - Fixed by removing `when(repository.findAll())` + rebuilding to Tier 10 SCALE - Caffeine 1000 max 600s Stats + Security Headers + Builder Pattern + Strategy Pattern Collaborative vs Content vs Hybrid + Repository + Caching + JUnit5 Mockito 6 tests Green Bar Runs: 6/6 Errors: 0 Failures: 0 + viewCount + idx_user + idx_category + CONTRIBUTING.md 12466 chars + Issues + 18 Badges + Architecture Diagram + Live Link + Docker Multi-Stage + Render Live 2m23s - Roadmap 100% Compliant.

---

# ✨ Features

- Scale Ready status API with JSON response - `{"project":"98-recommendation-engine","status":"Live - Recommendation Engine - Tier 10 Scale","tier":"10 - System Design Level - Caching + Security + Testing + Design Patterns","caching":"Caffeine Cache - recommendations cache - 1000 max, 600s expire - Stats enabled - Redis ready","recommendation":"Recommendation Pattern - Collaborative Content Hybrid"}`
- Fully production Recommendation Engine API service - 7 endpoints + home + health + recommend + list + collaborative + content + hybrid + search + Live on Render Docker - Deploy succeeded 2m23s - Same as 97 Live 2m35s
- Caching - System Design core - `CacheConfig.java @Configuration @EnableCaching` + `CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats()` + `@Cacheable("recommendations") + @Cacheable("recommendation") + @CacheEvict(allEntries=true)` + Headers `X-Cache: Caffeine - recommendations` + `Cache-Control: public max-age=3600` + Redis pattern ready + `recordStats` enabled
- Security Headers - `SecurityHeadersConfig.java @Configuration implements WebMvcConfigurer` + `X-Content-Type-Options: nosniff + X-Frame-Options: DENY + X-XSS-Protection: 1; mode=block` + Validation @NotBlank + userId empty check
- Builder Pattern - `Recommendation.java` - Inner Builder - `Recommendation.Builder userId() itemId() itemName() category() score() reason() recommendedAt() build()` Fluent API - No telescoping constructor - `recommend` uses Builder + CacheEvict
- Strategy Pattern - `RecommendationService.getRecommendations() + RecommendationController` - Collaborative vs Content vs Hybrid - `GET /api/recommendations/user1?strategy=collaborative -> Collaborative-Strategy count 1 + X-Recommendation-Strategy: Collaborative-Strategy`, `GET /api/recommendations/user1?strategy=content -> Content-Strategy count 1`, `GET /api/recommendations/user1?strategy=hybrid -> Hybrid-Strategy count 2 sorted by score 4.8 then 4.5 + X-Recommendation-Strategy: Hybrid-Strategy` - Core Recommendation System Design - Netflix / Amazon / YouTube
- Repository Pattern - `RecommendationRepository.java extends JpaRepository<Recommendation, Long>` + `findAllByOrderByRecommendedAtDesc() + findByUserIdOrderByScoreDesc() + findByCategoryContainingIgnoreCase() + findByUserIdAndCategory()` + `idx_user` + `idx_category` + `viewCount`
- Caching Pattern - `CacheConfig + @Cacheable + @CacheEvict` - Cache-aside - Stats enabled - Redis ready
- Recommendation Entity - `Recommendation id Long + userId + itemId + itemName + category + score + reason + recommendedAt + viewCount + Builder inner class` - H2 recommenddb
- Recommend Logic - `RecommendationService.recommend(userId, itemId, itemName, category, score, reason) -> Builder Pattern -> repository.save + CacheEvict + Return Recommendation` - Production recommend - `POST /api/recommend?userId=user1&itemId=item1&itemName=Laptop&category=Electronics&score=4.8&reason=collaborative filtering - similar users liked -> 200 OK {id:1, userId, itemName, message: Recommended - Cache Evicted - Builder Pattern - Recommendation Pattern, cache: recommendations cache evicted, recommendUrl: /api/recommendations/user1, recommendedAt: 2026-11-03T15:51:06.9475082, viewCount:0, category: Electronics}`
- Recommendation Logic - `getRecommendations(userId, strategy) -> viewCount not needed but recommendedAt desc -> If strategy collaborative -> filter reason contains collaborative -> If content -> filter reason contains content -> If hybrid -> sorted by score desc -> count 1 or 2 + X-Recommendation-Strategy` - Real recommendation - `user1` returns 2 docs hybrid sorted 4.8 then 4.5
- H2 Database - `jdbc:h2:mem:recommenddb FIXED from dbc typo + ddl-auto=update + recommendation table id category item_id item_name reason recommended_at score user_id view_count + index idx_user + idx_category + H2Console enabled` - In-memory
- Recommendation Pattern - `Collaborative filtering similar users liked + Content-based category match + Hybrid sorted by score` - `engine: Recommendation-Pattern - collaborative filtering + content-based + hybrid` - For Project 99 Multi-tenant + 100 Audit Log
- JUnit 5 + Mockito Tests - `RecommendationServiceTest` - 6 tests green - `testBuilderPattern() + testRecommendationEntity() + testFormatRecommendationInfo() + testGetRecommendationById_Mockito() + testSearchByCategory_Mockito() + testGetAllRecommendations_Mockito()` - Was 2/2 Tier 5 -> Now 6/6 Tier 10 - Fixed UnnecessaryStubbingException
- Docker Multi-Stage - `maven:3.9-eclipse-temurin-17 AS build + eclipse-temurin:17-jdk-alpine + mkdir -p data + COPY --from=build /app/target/*.jar app.jar` - Fix for Render COPY error + openjdk not found + data not found - Deploy succeeded Live 2m23s
- Render Live - `https://nine8-recommendation-engine.onrender.com` - Tomcat started on port 10000 - Started Application in 89.599s - Your service is live - Deploy succeeded 2m23s - Your service is live - Available at primary URL
- CONTRIBUTING.md - Added as per Tier 10 GitHub Goal - 12,466 chars
- Issues - `.github/ISSUE_TEMPLATE/bug_report.md + feature_request.md`
- Architecture Diagram - Caching + Security + Design Patterns + Recommendation Collaborative Content Hybrid + Docker + Render flow in README
- Tomcat initialized with port 8100 local, 10000 on Render - Tier 10 Port 8100
- Started Application in 13.796 seconds Local Eclipse Java 21.0.10 - Includes Caching + Security + Builder + Strategy + JPA - 89.599s on Render Docker
- Verified with Browser + Postman - `GET / -> Live JSON Tier 10 + GET /health -> UP cache Active recommendation Active + POST /api/recommend -> 200 OK Builder Pattern Cache Evicted + GET /api/recommendations -> 2 docs viewCount 0 + X-Cache + GET /api/recommendations/user1?strategy=collaborative -> Collaborative-Strategy count 1 + GET /api/recommendations/user1?strategy=content -> Content-Strategy count 1 + GET /api/recommendations/user1?strategy=hybrid -> Hybrid-Strategy count 2 sorted 4.8 4.5 + GET /api/recommendations/search?category=Electronics -> count 2 + X-Recommendation-Strategy + GET /health -> UP` - JUnit green bar 6/6 - Render Live
- Public Production Ready - Portfolio ready Recommendation Engine API project - Tier 10 SCALE 98/102 - 96% - Only 4 left to 100%

---

# 🛠 Technologies Used

- Java 17 (eclipse-temurin:17-jdk-alpine) - Local Java 21.0.10
- Spring Boot 3.2.5 (Banner v3.2.5)
- Spring Web - REST API `@RestController` + `@RequestMapping` + `@GetMapping` + `@PostMapping` + `@RequestParam` + `@PathVariable` + `ResponseEntity` + `HttpHeaders` + `HttpStatus`
- Spring Cache - `spring-boot-starter-cache` + `Caffeine Cache` + `com.github.ben-manes.caffeine:caffeine` + `@EnableCaching` + `CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats()` + `@Cacheable("recommendations")` + `@Cacheable("recommendation")` + `@CacheEvict(allEntries=true)` + X-Cache + Cache-Control + Redis pattern ready + recordStats enabled - `spring.cache.type=caffeine + spring.cache.caffeine.spec=maximumSize=1000,expireAfterAccess=600s,recordStats`
- Security Headers - `SecurityHeadersConfig.java @Configuration implements WebMvcConfigurer` + `HandlerInterceptor` + `X-Content-Type-Options: nosniff + X-Frame-Options: DENY + X-XSS-Protection: 1; mode=block` + Validation @NotBlank + userId empty check - Tier 10 Security
- Design Patterns - Builder Pattern `Recommendation.Builder` Fluent API + Strategy Pattern Collaborative vs Content vs Hybrid `Collaborative-Strategy collaborative filtering similar users liked vs Content-Strategy content-based category match vs Hybrid-Strategy sorted by score` Netflix/Amazon/YouTube core + Repository Pattern `JpaRepository` + Caching Pattern `CacheConfig + @Cacheable + @CacheEvict Cache-aside`
- Spring Data JPA - `@Entity @Table(name="recommendation")` + `JpaRepository<Recommendation, Long>` + `findAllByOrderByRecommendedAtDesc()` + `findByUserIdOrderByScoreDesc() + findByCategoryContainingIgnoreCase()` + `idx_user` + `idx_category` + `view_count`
- H2 Database - `jdbc:h2:mem:recommenddb FIXED from dbc typo` + `H2Console enabled /h2-console` + In-memory + `view_count` + `idx_user` + `idx_category`
- Recommendation Pattern - `Collaborative filtering similar users liked + Content-based category match + Hybrid sorted by score 4.8 then 4.5` - `engine: Recommendation-Pattern - collaborative filtering + content-based + hybrid` - For Project 99 Multi-tenant + 100 Audit Log
- JUnit 5 + Mockito - `spring-boot-starter-test` - `@ExtendWith(MockitoExtension.class)` + `@Mock RecommendationRepository` + `@InjectMocks RecommendationService` + `when().thenReturn()` + `verify() times()` + `ByteBuddy agent` - 6 tests green - Was 2/2 Tier 5 -> Now 6/6 Tier 10
- Docker Multi-Stage - `FROM maven:3.9-eclipse-temurin-17 AS build + RUN mvn clean package -DskipTests + FROM eclipse-temurin:17-jdk-alpine + mkdir -p data + COPY --from=build /app/target/*.jar app.jar` - Fix for Render COPY error + openjdk not found + data not found - Deploy succeeded Live 2m23s
- Render - Web Service Docker Free Tier - Auto-Deploy on push - Tomcat 10000 - Live https://nine8-recommendation-engine.onrender.com - Deploy succeeded Live - 2m23s - Your service is live - Available at primary URL
- Maven 3.9+
- Apache Tomcat 10.1.20 (Embedded) - TomcatWebServer port 8100 local, 10000 Render
- Postman - For `POST /api/recommend 200 OK Builder Pattern Cache Evicted + GET /api/recommendations + X-Cache + GET /api/recommendations/user1?strategy=collaborative -> Collaborative-Strategy count 1 + GET /api/recommendations/user1?strategy=content -> Content-Strategy count 1 + GET /api/recommendations/user1?strategy=hybrid -> Hybrid-Strategy count 2 sorted 4.8 4.5`
- Browser - Chrome - For home + health + list + recommendation test
- Windows 11 - Eclipse IDE + Browser + Postman
- GitHub - Issues + Release v1.0.0 + CONTRIBUTING.md 12466 chars + 18 Badges + Architecture Diagram + Live Link + Deployed Link - Tier 10 GitHub Goal

---

# 📂 Project Structure - Recommendation Engine Repo

```text
98-recommendation-engine
│
├── .github
│   └── ISSUE_TEMPLATE
│       ├── bug_report.md (Labels bug, Tier 10, System Design)
│       └── feature_request.md (Labels enhancement, Tier 10)
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── recommendation
│   │   │           ├── RecommendationEngineApplication.java (Main + Tomcat 8100 local 10000 Render + Started 13.796s local 89.599s Render)
│   │   │           ├── config
│   │   │           │   ├── CacheConfig.java (@Configuration @EnableCaching + CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats() + Redis pattern ready + recordStats enabled)
│   │   │           │   └── SecurityHeadersConfig.java (@Configuration implements WebMvcConfigurer + HandlerInterceptor + nosniff DENY XSS Protection - Tier 10 Security)
│   │   │           ├── controller
│   │   │           │   └── RecommendationController.java (7 endpoints + Home Live JSON Tier 10 + Health UP cache Active recommendation Active + Recommend POST + List GET @Cacheable X-Cache + Collaborative GET Collaborative-Strategy + Content GET Content-Strategy + Hybrid GET Hybrid-Strategy sorted 4.8 4.5 + Search Category GET count 2 + X-Recommendation-Strategy Collaborative vs Content vs Hybrid - Strategy Pattern core - Netflix Amazon YouTube)
│   │   │           ├── model
│   │   │           │   └── Recommendation.java (Entity @Table name=recommendation + id Long + userId + itemId + itemName + category + score + reason + recommendedAt + viewCount + Inner Builder class userId() itemId() itemName() category() score() reason() recommendedAt() build() Fluent API - Builder Pattern)
│   │   │           ├── repository
│   │   │           │   └── RecommendationRepository.java (JpaRepository<Recommendation, Long> + findAllByOrderByRecommendedAtDesc + findByUserIdOrderByScoreDesc + findByCategoryContainingIgnoreCase + findByUserIdAndCategory + idx_user + idx_category - Repository Pattern - Recommendation pattern ready)
│   │   │           └── service
│   │   │               └── RecommendationService.java (Builder Pattern recommend + CacheEvict recommendations cache evicted + viewCount + idx_user + idx_category + Cacheable recommendations + Cacheable recommendation + formatRecommendationInfo + isRelevant category contains)
│   │   │
│   │   └── resources
│   │       └── application.properties (server.port=${PORT:8100} + datasource jdbc:h2:mem:recommenddb FIXED from dbc typo + jpa ddl-auto update show-sql true + h2 console enabled + cache type caffeine + caffeine spec maximumSize=1000,expireAfterAccess=600s,recordStats)
│   │
│   └── test
│       └── java
│           └── com
│               └── recommendation
│                   └── RecommendationServiceTest.java (JUnit 5 + Mockito - 6 tests green - Runs 6/6 Errors 0 Failures 0 Green Bar 5.479s)
│
├── screenshots
│   ├── demo1.png (GET / - Home Live JSON - Recommendation Engine Tier 10 - owner Raviteja + security nosniff DENY XSS + designPatterns Builder Strategy Repository Caching + tier 10 + port 8100 + testing JUnit5 Mockito 6 tests + caching Caffeine 1000 max 600s Stats enabled + recommendation Collaborative Content Hybrid + live https://nine8-recommendation-engine.onrender.com)
│   ├── demo2.png (GET /health - UP - recommendation Active Recommendation Pattern Collaborative Content Hybrid Strategy Pattern + cache Active Caffeine Stats enabled + security Headers Active + githubGoal CONTRIBUTING.md)
│   ├── demo3.png (GET /api/recommendations - [] - Empty list before recommend - Browser localhost:8100/api/recommendations Pretty-print)
│   ├── demo4.png (POST /api/recommend?userId=user1&itemId=item1&itemName=Laptop&category=Electronics&score=4.8&reason=collaborative filtering - similar users liked - 200 OK Time 257 ms Size 621 B - Returns recommendedAt cache recommendations cache evicted recommendUrl id viewCount itemName message Recommended - Cache Evicted - Builder Pattern - Recommendation Pattern)
│   ├── demo5.png (POST /api/recommend?userId=user1&itemId=item2&itemName=Phone&category=Electronics&score=4.5&reason=content-based - category match - 200 OK Time 59 ms Size 603 B - Returns recommendedAt cache recommendations cache evicted id 2 viewCount 0 itemName Phone category Electronics score 4.5 reason content-based)
│   ├── demo6.png (GET /api/recommendations - [{"id":2,"userId":"user1","itemId":"item2","itemName":"Phone","category":"Electronics","score":4.5,"reason":"content-based - category match","recommendedAt":"2026-11-03T15:52:45.863101","viewCount":0},{"id":1,"userId":"user1","itemId":"item1","itemName":"Laptop","category":"Electronics","score":4.8,"reason":"collaborative filtering - similar users liked","recommendedAt":"2026-11-03T15:51:06.947508","viewCount":0}] - List with viewCount + X-Cache - Postman 200 OK 42 ms 746 B)
│   ├── demo7.png (GET /api/recommendations/user1?strategy=collaborative - Collaborative-Strategy - Status 200 OK Time 20 ms Size 702 B - Returns engine Recommendation-Pattern - collaborative filtering + content-based + hybrid + count 1 + strategy Collaborative-Strategy + userId user1 + results id 1 Laptop 4.8 collaborative filtering)
│   ├── demo8.png (GET /api/recommendations/user1?strategy=content - Content-Strategy - Status 200 OK Time 25 ms Size 672 B - Returns engine Recommendation-Pattern + count 1 + strategy Content-Strategy + userId user1 + results id 2 Phone 4.5 content-based - category match)
│   ├── demo9.png (GET /api/recommendations/user1?strategy=hybrid - Hybrid-Strategy - Status 200 OK Time 11 ms Size 888 B - Returns engine Recommendation-Pattern + count 2 + strategy Hybrid-Strategy + userId user1 + results id 1 Laptop 4.8 collaborative filtering + id 2 Phone 4.5 content-based - sorted by score 4.8 then 4.5 - Core Tier 10 Feature - Netflix Amazon)
│   ├── demo10.png (GET /api/recommendations/search?category=Electronics - Search - Status 200 OK Time 23 ms Size 719 B - Returns count 2 + category Electronics + results id 1 Laptop 4.8 + id 2 Phone 4.5)
│   ├── demo11.png (Eclipse Console - JUnit Console Logs - Builder Pattern Test Passed: Laptop + Format Recommendation Test Passed: Recommendation for user1: Laptop (4.80) - content-based + Mockito Test Passed: getRecommendationById - Mock Rec: Laptop + Mockito Test Passed: getAllRecommendations - Mocked 2 recs - Caching: recommendations + Recommendation Entity Test Passed + Search Test Passed: Found 1 rec for category Electronics - Strategy Pattern Collaborative)
│   ├── demo12.png (Eclipse JUnit - Finished after 6.594 seconds - Runs: 6/6 Errors: 0 Failures: 0 Green Bar - RecommendationServiceTest [Runner: JUnit 5] (5.479 s) - testBuilderPattern 5.479 s + testFormatRecommendationInfo 0.066 s + testRecommendationEntity 0.022 s + testGetRecommendationById_Mockito 0.196 s + testSearchByCategory_Mockito 0.023 s + testGetAllRecommendations_Mockito 0.014 s - Was 2/2 Tier 5 -> Now 6/6 Tier 10)
│   ├── demo13.png (Render Deploy Live - STATUS Deploy succeeded Live Green Tick - DURATION 2m23s - DEPLOYED - TRIGGER First Deploy - SOURCE - Tomcat started on port 10000 - Started RecommendationEngineApplication in Xs - Your service is live - Available at primary URL https://nine8-recommendation-engine.onrender.com - Proof of Live - Same as 97 Live 2m35s)
│   └── demo14.png (Live URL Test - https://nine8-recommendation-engine.onrender.com/ + /health - Live JSON - UP - Proof of Production)
│
├── .gitignore (target/ .mvn/ settings/ .classpath .project .factorypath META-INF/ data/ uploads/ *.log)
├── CONTRIBUTING.md (Tier 10 GitHub Goal - 12466 chars)
├── Dockerfile (Multi-Stage maven:3.9-eclipse-temurin-17 AS build + eclipse-temurin:17-jdk-alpine + mkdir -p data + COPY --from=build /app/target/*.jar app.jar)
├── mvnw
├── mvnw.cmd
├── pom.xml (No Lombok - H2 + JPA + Validation + Cache + Caffeine + spring-boot-starter-cache + spring-boot-starter-test + JUnit5 + Mockito + Recommendation Pattern)
└── README.md
```

---

# 📸 Screenshots - 12 Demos - Recommendation Engine Verified - Live on Render 2m23s

### Demo 1 – Browser - GET / - Home Live JSON - Recommendation Engine Tier 10 SCALE
[Demo1 Home](screenshots/demo1.png)

*GET http://localhost:8100/ - Browser - 200 OK - Returns {"owner":"Raviteja","security":"X-Content-Type-Options nosniff, X-Frame-Options DENY, XSS Protection","designPatterns":["Builder Pattern - Recommendation.Builder","Strategy Pattern - Collaborative vs Content vs Hybrid","Repository Pattern","Caching Pattern"],"tier":"10 - System Design Level - Caching + Security + Testing + Design Patterns","port":"8100","testing":"JUnit 5 + Mockito - 6 tests","project":"98-recommendation-engine","caching":"Caffeine Cache - recommendations cache - 1000 max, 600s expire - Stats enabled - Redis ready","recommendation":"Recommendation Pattern - Collaborative Content Hybrid","live":"https://nine8-recommendation-engine.onrender.com","status":"Live - Recommendation Engine - Tier 10 Scale"} - Proof of Home Live - Portfolio ready - Tier 10 SCALE 98/102 - 96%*

### Demo 2 – Browser - GET /health - UP - Caching + Security + Recommendation Active
[Demo2 Health](screenshots/demo2.png)

*GET http://localhost:8100/health - Browser - 200 OK - Returns {"recommendation":"Active - Recommendation Pattern - Collaborative Content Hybrid - Strategy Pattern","cache":"Active - Caffeine - recommendations, recommendation - Stats enabled","security":"Headers Active","project":"98-recommendation-engine","githubGoal":"CONTRIBUTING.md + Issues + Release Tags + Badges + Live Link + Architecture Diagram - Tier 10 Goal","status":"UP"} - Proof of Health Endpoint - Tier 10 Health Check*

### Demo 3 – Browser - GET /api/recommendations - Empty List - Before Recommend
[Demo3 Empty List](screenshots/demo3.png)

*GET http://localhost:8100/api/recommendations - Browser - 200 OK - Returns [] - Empty JSON array - Proof of List Endpoint Working - No recommendations yet - H2 in-memory empty - Caching recommendations cache ready*

### Demo 4 – Postman - POST /api/recommend - 200 OK - id 1 - Builder Pattern + Cache Evicted - Collaborative
[Demo4 Recommend Builder Collaborative](screenshots/demo4.png)

*POST http://localhost:8100/api/recommend?userId=user1&itemId=item1&itemName=Laptop&category=Electronics&score=4.8&reason=collaborative filtering - similar users liked - 200 OK Time 257 ms Size 621 B - Returns recommendedAt cache recommendations cache evicted recommendUrl id viewCount itemName message Recommended - Cache Evicted - Builder Pattern - Recommendation Pattern*

### Demo 5 – Postman - POST /api/recommend - 200 OK - id 2 - Content-based
[Demo5 Recommend Content](screenshots/demo5.png)

*POST http://localhost:8100/api/recommend?userId=user1&itemId=item2&itemName=Phone&category=Electronics&score=4.5&reason=content-based - category match - 200 OK Time 59 ms Size 603 B - Returns recommendedAt cache recommendations cache evicted id 2 viewCount 0 itemName Phone category Electronics score 4.5 reason content-based - Second doc*

### Demo 6 – Postman - GET /api/recommendations - With 2 Docs - viewCount + X-Cache
[Demo6 List viewCount](screenshots/demo6.png)

*GET http://localhost:8100/api/recommendations - Postman - 200 OK Time 42 ms Size 746 B - Returns 2 docs id 2 Phone 4.5 content-based + id 1 Laptop 4.8 collaborative filtering - viewCount 0 + recommendedAt - Proof of List Persistence - H2 - idx_user + idx_category + X-Cache: Caffeine*

### Demo 7 – Postman - GET /api/recommendations/user1?strategy=collaborative - Collaborative-Strategy count 1
[Demo7 Collaborative](screenshots/demo7.png)

*GET http://localhost:8100/api/recommendations/user1?strategy=collaborative - Status 200 OK Time 20 ms Size 702 B - engine Recommendation-Pattern - collaborative filtering + content-based + hybrid + count 1 + strategy Collaborative-Strategy + userId user1 + results id 1 Laptop 4.8 collaborative filtering - X-Recommendation-Strategy: Collaborative-Strategy - Core Tier 10 Feature - Netflix*

### Demo 8 – Postman - GET /api/recommendations/user1?strategy=content - Content-Strategy count 1
[Demo8 Content](screenshots/demo8.png)

*GET http://localhost:8100/api/recommendations/user1?strategy=content - Status 200 OK Time 25 ms Size 672 B - engine Recommendation-Pattern - collaborative filtering + content-based + hybrid + count 1 + strategy Content-Strategy + userId user1 + results id 2 Phone 4.5 content-based - category match - X-Recommendation-Strategy: Content-Strategy*

### Demo 9 – Postman - GET /api/recommendations/user1?strategy=hybrid - Hybrid-Strategy count 2 - Core Feature
[Demo9 Hybrid](screenshots/demo9.png)

*GET http://localhost:8100/api/recommendations/user1?strategy=hybrid - Status 200 OK Time 11 ms Size 888 B - Returns engine Recommendation-Pattern - collaborative filtering + content-based + hybrid + count 2 + strategy Hybrid-Strategy + userId user1 + results id 1 Laptop 4.8 collaborative filtering + id 2 Phone 4.5 content-based - sorted by score 4.8 then 4.5 - Core Tier 10 Feature - Netflix Amazon YouTube recommendation - Hybrid = Collaborative + Content sorted by score - Most important demo - Same as 97 fuzzy fixed count 1*

### Demo 10 – Postman - GET /api/recommendations/search?category=Electronics - count 2
[Demo10 Search Category](screenshots/demo10.png)

*GET http://localhost:8100/api/recommendations/search?category=Electronics - Status 200 OK Time 23 ms Size 719 B - Returns count 2 + category Electronics + results id 1 Laptop 4.8 + id 2 Phone 4.5 - Search by category - Same as 97 search Exact count 2*

### Demo 11 – Eclipse Console - JUnit Console Logs
[Demo11 JUnit Console](screenshots/demo11.png)

*Eclipse Console - Builder Pattern Test Passed: Laptop + Format Recommendation Test Passed: Recommendation for user1: Laptop (4.80) - content-based + Mockito Test Passed: getRecommendationById - Mock Rec: Laptop + Mockito Test Passed: getAllRecommendations - Mocked 2 recs - Caching: recommendations + Recommendation Entity Test Passed + Search Test Passed: Found 1 rec for category Electronics - Strategy Pattern Collaborative*

### Demo 12 – Eclipse JUnit - Green Bar - 6/6 Tests Passed
[Demo12 JUnit Green](screenshots/demo12.png)

*Eclipse JUnit - Finished after 6.594 seconds - Runs: 6/6 Errors: 0 Failures: 0 Green Bar - RecommendationServiceTest [Runner: JUnit 5] (5.479 s) - testBuilderPattern 5.479 s + 6 tests - Was 2/2 Tier 5 -> Now 6/6 Tier 10*

---

# ▶ How to Run - Recommendation Engine Repo

## 1⃣ Clone the Repository

```bash
git clone https://github.com/raviteja-dev950/98-recommendation-engine.git
cd 98-recommendation-engine
```

## 2⃣ Verify application.properties & Controllers

```properties
server.port=${PORT:8100}
spring.datasource.url=jdbc:h2:mem:recommenddb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.cache.type=caffeine
spring.cache.caffeine.spec=maximumSize=1000,expireAfterAccess=600s,recordStats
spring.application.name=98-recommendation-engine
```

## 3⃣ Run in Eclipse IDE (No Docker Needed)

```text
File -> New -> Spring Starter Project
  Name: 98-recommendation-engine
  Group: com.recommendation
  Artifact: 98-recommendation-engine
  Package: com.recommendation
  Java: 17
  Dependencies: H2, Spring Data JPA, Spring Web, Validation, Cache, Caffeine
Finish
Replace src + pom.xml from this repo
Delete META-INF folder if exists (Eclipse bug - Same as 93/94/95/96/97)
Project -> Clean -> Clean all
Right Click Project -> Maven -> Update Project -> Force Update -> OK
Right Click Project -> Run As -> Maven clean -> Maven install
Right Click Project -> Run As -> Spring Boot App -> Or java -jar target/*.jar
```

## 4⃣ Test with Browser + Postman - 7 Endpoints + Collaborative Content Hybrid

- GET http://localhost:8100/ -> Live JSON Tier 10 SCALE
- GET http://localhost:8100/health -> UP + cache Active Caffeine Stats enabled + recommendation Active Recommendation Pattern
- GET http://localhost:8100/api/recommendations -> [] empty then 2 docs viewCount 0 + X-Cache
- POST http://localhost:8100/api/recommend?userId=user1&itemId=item1&itemName=Laptop&category=Electronics&score=4.8&reason=collaborative filtering - similar users liked -> 200 OK id 1
- POST http://localhost:8100/api/recommend?userId=user1&itemId=item2&itemName=Phone&category=Electronics&score=4.5&reason=content-based - category match -> 200 OK id 2
- GET http://localhost:8100/api/recommendations -> 2 docs viewCount 0 + X-Cache
- GET http://localhost:8100/api/recommendations/user1?strategy=collaborative -> Collaborative-Strategy count 1
- GET http://localhost:8100/api/recommendations/user1?strategy=content -> Content-Strategy count 1
- GET http://localhost:8100/api/recommendations/user1?strategy=hybrid -> Hybrid-Strategy count 2 sorted 4.8 4.5 - Core Netflix Amazon
- GET http://localhost:8100/api/recommendations/search?category=Electronics -> count 2
- Browser refresh list multiple times -> X-Cache: Caffeine hit

## 5⃣ Test JUnit - 6/6 Green Bar - Tier 10

```text
Right Click RecommendationServiceTest.java -> Run As -> JUnit Test
Expected: Runs 6/6 Errors 0 Failures 0 Green Bar + Console Builder Pattern Test Passed + Format Recommendation Test Passed + Recommendation Entity Test Passed + Mockito Test Passed: getRecommendationById + Search Test Passed: Found 1 rec for category Electronics + Mockito Test Passed: getAllRecommendations - Mocked 2 recs - Caching: recommendations + Finished after 6.594 seconds RecommendationServiceTest [Runner: JUnit 5] (5.479 s)
```

## 6⃣ Deploy to Render (Live) - TIER 10 SCALE - Docker Multi-Stage

```text
Runtime: Docker (Multi-Stage)
Build: Docker builds maven:3.9-eclipse-temurin-17 AS build -> mvn clean package -DskipTests
Start: java -jar app.jar
Port: 8100 local, 10000 Render (Tomcat auto)
Env: PORT=10000 (Render sets)
Live: https://nine8-recommendation-engine.onrender.com
Deploy succeeded Live - 2m23s
```

Dockerfile:
```dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
RUN mkdir -p data
COPY --from=build /app/target/*.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

# 🔄 Flow Diagram - How Recommendation Engine Works - Tier 10 SCALE

```text
    User Laptop (Eclipse + Browser + Postman)
        |
        +-- 98-recommendation-engine
        |       +-- RecommendationEngineApplication.java (Main + Tomcat 8100 local 10000 Render + Started 13.796s local 89.599s Render)
        |       +-- CacheConfig.java (@Configuration @EnableCaching + CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats())
        |       +-- SecurityHeadersConfig.java (@Configuration implements WebMvcConfigurer + HandlerInterceptor + nosniff DENY XSS)
        |       +-- Recommendation.java (Entity + id + userId + itemId + itemName + category + score + reason + recommendedAt + viewCount + Inner Builder - Builder Pattern)
        |       +-- RecommendationRepository.java (JpaRepository + findAllByOrderByRecommendedAtDesc + findByUserIdOrderByScoreDesc + findByCategoryContainingIgnoreCase + findByUserIdAndCategory - Repository Pattern)
        |       +-- RecommendationService.java (Builder Pattern recommend + CacheEvict + viewCount + idx_user + idx_category + Cacheable + formatRecommendationInfo + isRelevant + Strategy Pattern Collaborative vs Content vs Hybrid)
        |       +-- RecommendationController.java (7 endpoints + Home Live JSON Tier 10 + Health UP + Recommend POST + List GET @Cacheable + Collaborative GET Collaborative-Strategy + Content GET Content-Strategy + Hybrid GET Hybrid-Strategy sorted 4.8 4.5 + Search Category GET count 2 + X-Recommendation-Strategy - Strategy Pattern core - Netflix Amazon)
        |       +-- RecommendationServiceTest.java (JUnit 5 + Mockito - 6 tests green - Runs 6/6 Errors 0 Failures 0 Green Bar 5.479s)
        |       +-- application.properties (server.port=${PORT:8100} + datasource jdbc:h2:mem:recommenddb + cache type caffeine + caffeine spec maximumSize=1000,expireAfterAccess=600s,recordStats)
        |       +-- screenshots (demo1-12)
        |       +-- Dockerfile (Multi-Stage - Fix for openjdk not found + COPY target error + data not found)
        |       +-- CONTRIBUTING.md (12466 chars - Tier 10 GitHub Goal)
        |       +-- .github/ISSUE_TEMPLATE (bug_report.md + feature_request.md)
        |
        v
    git push origin main -> GitHub raviteja-dev950/98-recommendation-engine -> Render Auto Deploy Docker Multi-Stage -> Tomcat 10000 -> Started Application 89.599s -> Your service is live https://nine8-recommendation-engine.onrender.com - STATUS Deploy succeeded | Live - DURATION 2m23s
        |
        v
    Browser / Portfolio - localhost:8100/ Live JSON Tier 10 + localhost:8100/health UP + localhost:8100/api/recommendations [] then 2 docs + POST recommend 200 OK + GET recommendations/user1?strategy=collaborative count 1 + GET recommendations/user1?strategy=content count 1 + GET recommendations/user1?strategy=hybrid count 2 sorted 4.8 4.5 + GET recommendations/search?category=Electronics count 2 + JUnit Green Bar 6/6 + Render Live https://nine8-recommendation-engine.onrender.com/ + Live health - Portfolio ready - Tier 10 SCALE 98/102 - 96%
```

---

# 🧪 API Testing Examples

```bash
# Home - Tier 10 SCALE
curl http://localhost:8100/
curl https://nine8-recommendation-engine.onrender.com/

# Health - UP + cache Active + recommendation Active
curl http://localhost:8100/health
curl https://nine8-recommendation-engine.onrender.com/health

# List - Empty [] before recommend
curl http://localhost:8100/api/recommendations

# Recommend - Builder Pattern + CacheEvict + Recommendation Pattern - Collaborative
curl -X POST "http://localhost:8100/api/recommend?userId=user1&itemId=item1&itemName=Laptop&category=Electronics&score=4.8&reason=collaborative filtering - similar users liked"

# Recommend - Content-based
curl -X POST "http://localhost:8100/api/recommend?userId=user1&itemId=item2&itemName=Phone&category=Electronics&score=4.5&reason=content-based - category match"

# List After Recommend - viewCount + idx_user + idx_category + X-Cache
curl http://localhost:8100/api/recommendations

# Collaborative - 200 OK Collaborative-Strategy count 1
curl http://localhost:8100/api/recommendations/user1?strategy=collaborative

# Content - 200 OK Content-Strategy count 1
curl http://localhost:8100/api/recommendations/user1?strategy=content

# Hybrid - 200 OK Hybrid-Strategy count 2 sorted 4.8 4.5 - Core Netflix Amazon
curl http://localhost:8100/api/recommendations/user1?strategy=hybrid

# Search Category - 200 OK count 2
curl http://localhost:8100/api/recommendations/search?category=Electronics

# Render Live
curl https://nine8-recommendation-engine.onrender.com/
curl https://nine8-recommendation-engine.onrender.com/health
curl https://nine8-recommendation-engine.onrender.com/api/recommendations
```

---

# 👨💻 Author

Ravi Teja - Java Full Stack Developer - 102 Java Full Stack Projects Challenge - Project 98 / 102 - Tier 10 – System Design Level – SCALE – TIER 10 SCALE 98/102 - 96% - Deploy succeeded Live 2m23s - Fixed dbc typo + META-INF + openjdk not found + COPY target + data not found + POST 400 Query Params empty + 405 Method Not Allowed + Tier 5 -> Tier 10 with Caching + Security + Builder + Strategy + Recommendation Pattern Collaborative Content Hybrid + JUnit5 Mockito 6/6 Green - 98/102 96%

---

## ⭐ Support

If you found this project helpful, consider giving it a ⭐ Star on GitHub.

**Single Repo:** [98-recommendation-engine](https://github.com/raviteja-dev950/98-recommendation-engine)

**Live URL:** https://nine8-recommendation-engine.onrender.com/

**Deploy:** Deploy succeeded | Live Green Tick - DURATION 2m23s - DEPLOYED Nov 3, 2026 - TRIGGER First Deploy - SOURCE - Your service is live - Available at primary URL https://nine8-recommendation-engine.onrender.com - Docker Multi-Stage - Same as 97 Live 2m35s - Collaborative Content Hybrid count 2 sorted 4.8 4.5 - Recommendation Pattern!

**Tier 10:** 93 Rate Limited API (Live) + 94 URL Shortener Scale (Live 2m32s) + 95 Chat App WebSockets (Live 2m23s) + 96 Video Streaming API (Live 2m23s) + 97 Search with Elastic (Live 2m35s) + 98 Recommendation Engine (Live 2m23s - Caching Caffeine 1000 max 600s Stats recordStats + Security Headers nosniff DENY XSS + Builder Pattern Recommendation.Builder + Strategy Pattern Collaborative vs Content vs Hybrid + Repository + Caching + JUnit5 Mockito 6/6 Green + viewCount + idx_user + idx_category + Recommendation Pattern Collaborative Content Hybrid sorted 4.8 4.5) + 99 Multi-tenant SaaS + 100 Audit Log + 101 SaaS Idea + 102 Capstone OSS = **TIER 10 FINAL 10 PROJECTS - 96% DONE - Only 4 left to 100%**
