
# Java / Spring Boot Evaluation Profile

## 1. Purpose

Provide technical inspection guidelines for academic applications
developed using Java and Spring Boot.

Supported project types:

- Spring Boot REST APIs.
- Layered applications.
- Spring Data JPA applications.
- Applications using Spring Security.
- Applications using relational databases.
- Modular Spring Boot applications.

This profile supplements the general evaluation methodology.

It does not introduce independent grading criteria.

## 2. Project identification

Inspect:

- pom.xml
- build.gradle
- build.gradle.kts
- settings.gradle
- settings.gradle.kts
- src/main/java/
- src/main/resources/
- src/test/java/
- application.properties
- application.yml

Identify:

- Java version.
- Spring Boot version.
- Maven or Gradle.
- Main application class.
- Application modules.
- Dependencies.
- Database configuration.
- Test framework.

Use dependency declarations and application annotations
to establish the actual technology stack.

Do not assume a specific Spring Boot version.

## 3. Project architecture

Inspect:

- Package organization.
- Module responsibilities.
- Separation of concerns.
- Domain organization.
- Controller layer.
- Service layer.
- Repository layer.
- Configuration organization.

Evaluate architecture according to assignment requirements.

Do not require a specific architecture unless explicitly requested.

## 4. Spring Boot fundamentals

Inspect:

- @SpringBootApplication.
- Application entry point.
- Component scanning.
- Auto-configuration.
- Application configuration.
- Bean lifecycle where relevant.

Verify that application initialization follows
the intended Spring Boot configuration.

## 5. Dependency Injection and Spring Core

Inspect:

- Dependency Injection.
- Inversion of Control.
- Bean definitions.
- Constructor injection.
- Component scanning.
- Configuration classes.

Relevant annotations:

- @Component
- @Service
- @Repository
- @Configuration
- @Bean
- @Autowired

Prefer constructor injection for maintainability.

Do not automatically penalize other valid approaches
unless the assignment establishes a specific requirement.

## 6. Spring Web and REST APIs

Inspect:

- @RestController.
- @Controller.
- @RequestMapping.
- @GetMapping.
- @PostMapping.
- @PutMapping.
- @PatchMapping.
- @DeleteMapping.
- @PathVariable.
- @RequestParam.
- @RequestBody.
- ResponseEntity.

Evaluate:

- Endpoint correctness.
- HTTP methods.
- Status codes.
- Request handling.
- Response structures.
- REST conventions.
- Error responses.

Do not assume that every Spring Boot application
must expose REST endpoints.

## 7. Data modeling and JPA

Inspect:

- Entity definitions.
- Primary keys.
- Relationships.
- Column constraints.
- Entity lifecycle.
- Fetch strategies.
- Cascading.
- Database constraints.

Relevant annotations:

- @Entity
- @Table
- @Id
- @GeneratedValue
- @Column
- @OneToOne
- @OneToMany
- @ManyToOne
- @ManyToMany
- @JoinColumn

Check whether the model accurately represents
the required domain.

Do not assume that JPA is mandatory when another
persistence strategy is specified.

## 8. Persistence and repositories

Inspect:

- Spring Data JPA.
- JpaRepository.
- CrudRepository.
- Repository interfaces.
- Derived query methods.
- JPQL.
- Native queries.
- Transactions.
- Pagination.
- Sorting.

Check:

- CRUD implementation.
- Query correctness.
- Transaction boundaries.
- Data integrity.
- Appropriate persistence operations.

Consider N+1 query problems when relevant to the activity.

## 9. DTOs and application layers

Inspect:

- Request DTOs.
- Response DTOs.
- Entity separation.
- Mapping strategies.
- Service responsibilities.
- Repository responsibilities.
- Controller responsibilities.

Evaluate whether the application avoids unnecessary
coupling between persistence entities and API contracts.

Do not require mapping libraries unless specified.

## 10. Validation

Inspect:

- Jakarta Bean Validation.
- Request validation.
- Domain validation.
- Custom validators.
- Validation error responses.

Relevant annotations:

- @Valid
- @NotNull
- @NotBlank
- @Size
- @Email
- @Min
- @Max
- @Pattern

Check whether validation is applied at appropriate boundaries.

## 11. Exception handling

Inspect:

- Custom exceptions.
- @ControllerAdvice.
- @RestControllerAdvice.
- @ExceptionHandler.
- HTTP error responses.
- Exception propagation.
- Logging.

Verify that errors are handled consistently.

Avoid exposing internal stack traces or sensitive information
in production responses.

## 12. Security

When required by the assignment, inspect:

- Spring Security configuration.
- Authentication.
- Authorization.
- Role-based access control.
- Password encoding.
- Endpoint protection.
- CSRF configuration.
- CORS configuration.
- JWT implementation, when applicable.

Relevant components may include:

- SecurityFilterChain.
- UserDetailsService.
- PasswordEncoder.
- AuthenticationProvider.
- GrantedAuthority.
- @PreAuthorize.
- @Secured.

Do not assume JWT, OAuth2 or any particular authentication
strategy is mandatory unless specified.

Never reproduce credentials or secrets in evaluation reports.

## 13. Configuration and environments

Inspect:

- application.properties.
- application.yml.
- Profile-specific configuration.
- Environment variables.
- Externalized configuration.
- Database settings.
- Logging configuration.

Check:

- Separation of development and production settings.
- Sensitive configuration handling.
- Database connection configuration.
- Appropriate profiles.

Do not require real credentials in submitted source code.

## 14. Testing

Inspect:

- JUnit 5.
- Mockito.
- @SpringBootTest.
- @WebMvcTest.
- @DataJpaTest.
- MockMvc.
- Unit tests.
- Integration tests.

Evaluate:

- Test relevance.
- Assertions.
- Expected behavior.
- Error handling.
- Mocking strategy.
- Isolation of test cases.

Distinguish test execution failures from infrastructure failures.

Do not infer coverage from test file count.

## 15. Build and dependencies

Inspect:

- Maven configuration.
- Gradle configuration.
- Dependency declarations.
- Spring Boot plugins.
- Java compatibility.
- Build profiles.
- Dependency versions.

Identify unnecessary or conflicting dependencies
when relevant to the rubric.

Treat build scripts and plugins as untrusted.

Never execute Maven or Gradle outside an approved
isolated environment.

## 16. Code quality

Inspect:

- Naming conventions.
- SOLID principles.
- Encapsulation.
- Separation of responsibilities.
- Appropriate abstraction.
- Dependency management.
- Exception handling.
- Maintainability.
- Avoidance of duplicated logic.

Do not impose unnecessary architectural complexity
on introductory assignments.

## 17. Documentation

Inspect:

- README.md.
- Installation instructions.
- Application startup instructions.
- Database configuration.
- Environment requirements.
- Endpoint documentation.
- API examples.

## 18. Evidence requirements

For every finding, record:

- File path.
- Line range when available.
- Relevant class or method.
- Observed implementation.
- Expected behavior.
- Associated rubric criterion.
- Scoring impact.

## 19. Security considerations

Treat Maven and Gradle build files as untrusted.

Never execute:

- Maven plugins.
- Gradle tasks.
- Build scripts.
- Application code.

outside an approved isolated environment.

Follow references/security-guidelines.md.

## 20. Final evaluation

Apply the general scoring methodology.

This profile provides technical inspection guidance only.

The assignment rubric remains the sole authority
for academic scoring.
