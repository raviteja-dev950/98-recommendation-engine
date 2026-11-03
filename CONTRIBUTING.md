# 🤝 Contributing to 98 – Recommendation Engine | Tier 10 System Design Level | SCALE

Thank you for your interest in contributing to Project 98 Recommendation Engine – Part of 100 Projects Java Full Stack Development Roadmap Tier 10 System Design Level Scale + Polish!

This project is Tier 10 SCALE: Caching (Caffeine 1000 max 600s recordStats Redis pattern ready), Security (Headers nosniff DENY XSS Protection), Testing (JUnit 5 Mockito 6/6 Green Bar), Design Patterns (Builder Pattern Recommendation.Builder Fluent API + Strategy Pattern Collaborative vs Content vs Hybrid Netflix Amazon YouTube core + Repository Pattern JpaRepository + Caching Pattern Cache-aside), Redis pattern, Elasticsearch pattern (Recommendation Pattern collaborative filtering + content-based + hybrid sorted by score), JUnit, Mockito, Docker Multi-Stage, Render Live 2m23s.

**Live URL:** https://nine8-recommendation-engine.onrender.com/

## 📋 Table of Contents
- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
- [Development Setup - Eclipse From Scratch](#development-setup)
- [Tier 10 Requirements - Must Follow](#tier-10-requirements)
- [Bug Reports - META-INF + H2 + Docker + Query Params](#bug-reports)
- [Pull Request Process](#pull-request-process)
- [Coding Standards - Same as 97](#coding-standards)
- [Testing - 6/6 Green Bar](#testing)
- [Architecture - Caching + Security + Recommendation](#architecture)

## Code of Conduct
Be respectful. No harassment. This is a learning project - 98/102 96% - Help others reach 100%.

## How Can I Contribute?
- Report bugs: META-INF folder bug, H2 driver runtime scope, dbc typo jdbc, openjdk not found, COPY target lstat, data not found, POST 400 Query Params empty, 405 Method Not Allowed
- Suggest features: New strategy (Popular, Trending), viewCount increment, collaborative matrix, Elasticsearch real integration, Redis real
- Improve docs: README 12 demos, architecture diagram, flow diagram
- Add tests: Builder pattern, Strategy pattern, Caching stats, Security headers

## Development Setup - Eclipse From Scratch - Same as 93-97

### Prerequisites
- Java 17 (eclipse-temurin:17-jdk-alpine) - Local Java 21.0.10
- Eclipse IDE 2024+
- Maven 3.9+
- Postman / Browser
- Git

### Steps - Exact Same as 97 Search with Elastic

1. **Eclipse New Spring Starter Project**
   ```
   File -> New -> Spring Starter Project
   Name: 98-recommendation-engine
   Group: com.recommendation
   Artifact: 98-recommendation-engine
   Package: com.recommendation
   Type: Maven
   Java Version: 17
   Packaging: Jar
   Dependencies: H2 Database, Spring Data JPA, Spring Web, Validation, Cache Abstraction
   Finish
   ```

2. **Fix pom.xml - Add Caffeine Manually - Tier 10 SCALE pom**
   ```xml
   <dependency>
     <groupId>com.github.ben-manes.caffeine</groupId>
     <artifactId>caffeine</artifactId>
   </dependency>
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-cache</artifactId>
   </dependency>
   ```

3. **application.properties - Port 8100 + H2 recommenddb + Caffeine 1000 max 600s Stats**
   ```properties
   server.port=${PORT:8100}
   spring.datasource.url=jdbc:h2:mem:recommenddb
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.h2.console.enabled=true
   spring.cache.type=caffeine
   spring.cache.caffeine.spec=maximumSize=1000,expireAfterAccess=600s,recordStats
   ```

4. **Delete META-INF Bug - Same as 93-97**
   - Delete `src/main/resources/META-INF` folder if exists
   - Delete `target` folder
   - Project -> Clean -> Clean all
   - Right Click -> Maven -> Update Project -> Force Update -> OK

5. **Create Java Files - Same Order as 97**
   - `model/Recommendation.java` - Entity + Builder Pattern inner class + viewCount + idx_user + idx_category
   - `repository/RecommendationRepository.java` - JpaRepository + findAllByOrderByRecommendedAtDesc + findByUserIdOrderByScoreDesc + findByCategoryContainingIgnoreCase
   - `config/CacheConfig.java` - CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats()
   - `config/SecurityHeadersConfig.java` - WebMvcConfigurer + HandlerInterceptor + nosniff DENY XSS
   - `service/RecommendationService.java` - Builder + CacheEvict + Strategy Pattern Collaborative vs Content vs Hybrid
   - `controller/RecommendationController.java` - 7 endpoints + X-Cache + X-Recommendation-Strategy
   - `RecommendationEngineApplication.java` - Main
   - `RecommendationServiceTest.java` - 6 tests JUnit5 Mockito
   - `Dockerfile` - Multi-Stage
   - `.gitignore`

6. **Run**
   ```
   Right Click Project -> Run As -> Maven clean
   Right Click Project -> Run As -> Maven install
   Right Click Project -> Run As -> Spring Boot App
   Console: Tomcat started on port 8100 + Started Application in 13.796s
   ```

7. **Test - 12 Demos**
   - GET http://localhost:8100/ -> Live JSON Tier 10
   - GET http://localhost:8100/health -> UP
   - GET http://localhost:8100/api/recommendations -> []
   - POST http://localhost:8100/api/recommend?userId=user1&itemId=item1&itemName=Laptop&category=Electronics&score=4.8&reason=collaborative filtering - similar users liked -> 200 OK id 1
   - POST -> id 2 Phone
   - GET /api/recommendations -> 2 docs
   - GET /api/recommendations/user1?strategy=collaborative -> count 1
   - GET /api/recommendations/user1?strategy=content -> count 1
   - GET /api/recommendations/user1?strategy=hybrid -> count 2 sorted 4.8 4.5 - Core Feature
   - GET /api/recommendations/search?category=Electronics -> count 2
   - JUnit: Right Click RecommendationServiceTest -> Run As JUnit Test -> Runs 6/6 Errors 0 Failures 0 Green Bar 6.594s

## Tier 10 Requirements - Must Follow - Same as 93-97

**Caching - System Design Core**
- CacheConfig.java @Configuration @EnableCaching
- CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats()
- @Cacheable("recommendations") + @Cacheable("recommendation") + @CacheEvict(allEntries=true)
- X-Cache: Caffeine + Cache-Control: public max-age=3600
- Redis pattern ready

**Security - Tier 10**
- SecurityHeadersConfig.java @Configuration implements WebMvcConfigurer + HandlerInterceptor
- X-Content-Type-Options: nosniff
- X-Frame-Options: DENY
- X-XSS-Protection: 1; mode=block
- Validation @NotBlank + userId empty check

**Design Patterns - 4 Patterns**
- Builder Pattern: Recommendation.java Inner Builder userId() itemId() itemName() category() score() reason() recommendedAt() build() Fluent API
- Strategy Pattern: RecommendationService + Controller Collaborative vs Content vs Hybrid - Collaborative-Strategy collaborative filtering similar users liked vs Content-Strategy content-based category match vs Hybrid-Strategy sorted by score - Netflix Amazon YouTube core
- Repository Pattern: JpaRepository + findAllByOrderByRecommendedAtDesc + idx_user + idx_category
- Caching Pattern: CacheConfig + @Cacheable + @CacheEvict Cache-aside + Stats enabled + Redis ready

**Redis Pattern**
- Caffeine Cache 1000 max 600s Stats enabled = Redis pattern ready
- Badge: Caching Caffeine 1000 max 600s Stats blue
- For real Redis: Replace Caffeine with RedisCacheManager + RedisTemplate

**Elasticsearch Pattern**
- Recommendation Pattern collaborative filtering + content-based + hybrid = Elasticsearch pattern
- Engine field: Recommendation-Pattern - collaborative filtering + content-based + hybrid
- Count + sorted by score = Elasticsearch relevance scoring
- Same as 97 Exact vs Fuzzy vs Autocomplete = Elasticsearch pattern
- For real Elasticsearch: Use ElasticsearchRepository + @Document

**JUnit + Mockito**
- 6 tests: testBuilderPattern + testRecommendationEntity + testFormatRecommendationInfo + testGetRecommendationById_Mockito + testSearchByCategory_Mockito + testGetAllRecommendations_Mockito
- Runs: 6/6 Errors: 0 Failures: 0 Green Bar
- @ExtendWith(MockitoExtension.class) + @Mock + @InjectMocks + when().thenReturn() + verify()
- ByteBuddy agent warning is OK - OpenJDK 64-Bit Server VM warning Sharing is only supported for boot loader classes because bootstrap classpath has been appended is OK

**Docker Multi-Stage - Fix for Render**
- FROM maven:3.9-eclipse-temurin-17 AS build + COPY pom.xml + COPY src + RUN mvn clean package -DskipTests
- FROM eclipse-temurin:17-jdk-alpine + RUN mkdir -p data + COPY --from=build /app/target/*.jar app.jar
- Fix: openjdk:17-jdk-slim not found -> eclipse-temurin:17-jdk-alpine
- Fix: COPY target/*.jar lstat no such file -> Multi-Stage
- Fix: data not found -> mkdir -p data
- EXPOSE 10000 + ENTRYPOINT java -jar app.jar

**GitHub Goal - Tier 10**
- CONTRIBUTING.md 12466 chars (this file)
- .github/ISSUE_TEMPLATE/bug_report.md + feature_request.md
- 18 Badges + Live Link + Architecture Diagram + Flow Diagram
- Release Tag v1.0.0 + Live Link https://nine8-recommendation-engine.onrender.com
- Screenshots 12 demos
- Render Deploy succeeded Live 2m23s DURATION DEPLOYED TRIGGER First Deploy SOURCE baefad5

## Bug Reports - Known Bugs Fixed - Document for Others

**Bug 1:** Cannot load driver class: org.h2.Driver
- Cause: <scope>runtime</scope> in H2 dependency
- Fix: Remove scope + Maven Update Project Force Update + Clean

**Bug 2:** Unable to resolve name [org.hibernate.dialect.H2Dialect ] as strategy - Extra newline space
- Cause: spring.jpa.database-platform with trailing space
- Fix: Remove database-platform + driverClassName lines

**Bug 3:** URL must start with 'jdbc' - Typo dbc:h2:mem:recommenddb
- Fix: Correct to jdbc:h2:mem:recommenddb

**Bug 4:** RecommendationController red errors - META-INF folder bug
- Cause: Eclipse creates src/main/resources/META-INF breaking Maven + Maven dependencies not downloaded
- Fix: Delete META-INF + Delete target + Maven Update Project Force Update - Same as 93-97

**Bug 5:** docker.io/library/openjdk:17-jdk-slim: not found
- Fix: Change to eclipse-temurin:17-jdk-alpine

**Bug 6:** COPY target/*.jar app.jar ERROR: lstat /target: no such file or directory
- Cause: Docker build doesn't run mvn package
- Fix: Multi-Stage Dockerfile

**Bug 7:** POST /api/recommend -> 400 Bad Request
- Cause: Query Params empty in Postman
- Fix: Set Params tab Key Value userId itemId itemName category score reason

**Bug 8:** GET /api/recommendations/user1?strategy=content -> 405 Method Not Allowed
- Cause: Used POST but endpoint is GET
- Fix: Change Method to GET - Same as 96 bug

**Bug 9:** Was 2/2 tests Tier 5 - Not Tier 10 compliant + UnnecessaryStubbingException
- Cause: Only Entity + Format tests - No Builder + No Mockito + No Caching + No Security + Stubbing both findAllByOrderByRecommendedAtDesc and findAll
- Fix: Remove when(repository.findAll()) + Rebuild to Tier 10 SCALE Caffeine 1000 max 600s Stats + Security Headers + Builder Pattern + Strategy Pattern + 6 tests Green Bar

## Pull Request Process
1. Fork repo
2. Create branch: git checkout -b feature/AmazingFeature98
3. Commit: git commit -m 'Add AmazingFeature98 - Tier 10 SCALE'
4. Push: git push origin feature/AmazingFeature98
5. Open PR - Describe Tier 10 compliance - Caching + Security + Builder + Strategy + JUnit Mockito + Redis + Elasticsearch pattern + Screenshots 12 demos + JUnit Green Bar 6/6 + Render Live link
6. Wait for review - Ensure CI passes - 6/6 Green

## Coding Standards - Same as 97
- Java 17 - No Lombok - Builder pattern manual
- Spring Boot 3.2.5
- No System.out.println - Use logger
- Validation @NotBlank
- viewCount field + idx_user + idx_category
- CacheEvict on recommend
- X-Cache + X-Recommendation-Strategy headers
- RESTful endpoints
- 18 badges in README
- Screenshots naming: demo1.png to demo14.png - demo1 Home, demo2 Health, demo3 Empty, demo4-5 POST recommend, demo6 List 2 docs, demo7 Collaborative count 1, demo8 Content count 1, demo9 Hybrid count 2 sorted 4.8 4.5 core, demo10 Search count 2, demo11 JUnit Console, demo12 JUnit Green Bar, demo13 Render Live, demo14 Live URL

## Testing - 6/6 Green Bar - Tier 10
- Run: Right Click RecommendationServiceTest.java -> Run As -> JUnit Test
- Expected: Finished after 6.594 seconds - Runs: 6/6 Errors: 0 Failures: 0 Green Bar - RecommendationServiceTest [Runner: JUnit 5] (5.479 s)
- Console: Builder Pattern Test Passed: Laptop + Format Recommendation Test Passed: Recommendation for user1: Laptop (4.80) - content-based + Mockito Test Passed: getRecommendationById - Mock Rec: Laptop + Mockito Test Passed: getAllRecommendations - Mocked 2 recs - Caching: recommendations + Recommendation Entity Test Passed + Search Test Passed: Found 1 rec for category Electronics - Strategy Pattern Collaborative

## Architecture - Caching + Security + Recommendation Collaborative Content Hybrid + Docker + Render
- User Laptop (Eclipse + Browser + Postman) -> 98-recommendation-engine -> RecommendationEngineApplication Main Tomcat 8100 local 10000 Render Started 13.796s local 89.599s Render -> CacheConfig Caffeine 1000 max 600s Stats -> SecurityHeadersConfig nosniff DENY XSS -> Recommendation Entity Builder -> RecommendationRepository JpaRepository idx_user idx_category -> RecommendationService Builder CacheEvict Strategy Collaborative Content Hybrid -> RecommendationController 7 endpoints Home Live JSON Tier 10 Health UP Recommend POST List GET Collaborative GET Content GET Hybrid GET Search Category GET X-Recommendation-Strategy -> RecommendationServiceTest 6 tests green -> application.properties port 8100 recommenddb cache caffeine spec -> Dockerfile Multi-Stage -> CONTRIBUTING.md 12466 chars -> .github ISSUE_TEMPLATE -> screenshots demo1-12 -> .gitignore -> git push -> GitHub raviteja-dev950/98-recommendation-engine -> Render Auto Deploy Docker Multi-Stage Tomcat 10000 Started Application 89.599s Your service is live https://nine8-recommendation-engine.onrender.com STATUS Deploy succeeded Live DURATION 2m23s -> Browser Portfolio localhost:8100/ Live JSON Tier 10 + health UP + recommendations [] then 2 docs + recommend 200 OK + collaborative count 1 + content count 1 + hybrid count 2 sorted 4.8 4.5 + search count 2 + JUnit Green Bar 6/6 + Render Live - Portfolio ready Tier 10 SCALE 98/102 96%

## License
MIT - See LICENSE file

## Contact
Ravi Teja - Java Full Stack Developer - 100 Projects Challenge - 98/102 96% - Only 4 left to 100% - GitHub raviteja-dev950

**TIER 10 SCALE - 98/102 96% - Deploy succeeded Live 2m23s - Fixed dbc typo + META-INF + openjdk not found + COPY target + data not found + POST 400 Query Params empty + 405 Method Not Allowed + Tier 5 -> Tier 10 with Caching + Security + Builder + Strategy + Recommendation Pattern Collaborative Content Hybrid + JUnit5 Mockito 6/6 Green - 98/102 96%**

**Single Repo:** 98-recommendation-engine - Live URL https://nine8-recommendation-engine.onrender.com - Deploy succeeded Live Green Tick DURATION 2m23s DEPLOYED TRIGGER First Deploy SOURCE - Your service is live - Available at primary URL - Docker Multi-Stage - Same as 97 Live 2m35s - Collaborative Content Hybrid count 2 sorted 4.8 4.5 - Recommendation Pattern!

**Tier 10 Final:** 93 Rate Limited API (Live) + 94 URL Shortener Scale (Live 2m32s) + 95 Chat App WebSockets (Live 2m23s) + 96 Video Streaming API (Live 2m23s) + 97 Search with Elastic (Live 2m35s) + 98 Recommendation Engine (Live 2m23s - Caching Caffeine 1000 max 600s Stats recordStats + Security Headers nosniff DENY XSS + Builder Pattern Recommendation.Builder + Strategy Pattern Collaborative vs Content vs Hybrid + Repository + Caching + JUnit5 Mockito 6/6 Green + viewCount + idx_user + idx_category + Recommendation Pattern Collaborative Content Hybrid sorted 4.8 4.5) + 99 Multi-tenant SaaS + 100 Audit Log + 101 SaaS Idea + 102 Capstone OSS = TIER 10 FINAL 10 PROJECTS - 96% DONE
