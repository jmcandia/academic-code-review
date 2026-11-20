
# C# / ASP.NET Evaluation Profile

## 1. Purpose

Provide technical inspection guidelines for academic projects
developed using C# and ASP.NET.

Supported project types:

- ASP.NET Core Web API.
- ASP.NET Core MVC.
- Razor Pages.
- Entity Framework Core applications.
- Layered .NET applications.
- Applications using authentication and authorization.

This profile supplements the general evaluation methodology.

It does not introduce independent grading criteria.

## 2. Project identification

Inspect:

- *.sln
- *.slnx
- *.csproj
- Program.cs
- appsettings.json
- appsettings.Development.json
- Controllers/
- Models/
- Views/
- Pages/
- Data/
- Services/
- wwwroot/

Identify:

- .NET SDK version.
- Target framework.
- C# language version.
- ASP.NET Core version.
- Application entry point.
- Project references.
- NuGet dependencies.
- Test projects.
- Database configuration.

Do not assume a particular .NET version.

## 3. Project architecture

Inspect:

- Solution organization.
- Project boundaries.
- Namespace organization.
- Separation of responsibilities.
- Controller layer.
- Service layer.
- Data access layer.
- Domain models.
- Dependency management.

Evaluate architecture according to assignment requirements.

Do not require Clean Architecture, DDD or microservices
unless explicitly requested.

## 4. C# language fundamentals

Inspect:

- Classes and objects.
- Interfaces.
- Encapsulation.
- Inheritance.
- Polymorphism.
- Abstract classes.
- Generics.
- Collections.
- Exception handling.
- Properties.
- Constructors.
- Access modifiers.

When relevant, inspect:

- LINQ.
- Async and await.
- Nullable reference types.
- Records.
- Delegates and events.

Evaluate only the concepts required by the assignment.

## 5. ASP.NET Core fundamentals

Inspect:

- Application startup.
- WebApplication configuration.
- Middleware pipeline.
- Service registration.
- Dependency Injection.
- Configuration providers.
- Environment-specific behavior.

Relevant components:

- WebApplication.CreateBuilder()
- builder.Services
- builder.Build()
- app.Use()
- app.Map()
- app.Run()

Check whether middleware is registered in an appropriate order.

Do not assume that every application requires identical middleware.

## 6. Dependency Injection and services

Inspect:

- Service registration.
- Interface-based dependencies.
- Constructor injection.
- Service lifetimes.
- Separation of concerns.

Relevant lifetimes:

- Singleton.
- Scoped.
- Transient.

Check for inappropriate lifetime combinations,
including captive dependencies.

Do not penalize valid alternatives unless the rubric specifies them.

## 7. Controllers and HTTP APIs

Inspect:

- ControllerBase.
- ApiController.
- Route.
- HttpGet.
- HttpPost.
- HttpPut.
- HttpPatch.
- HttpDelete.
- FromBody.
- FromRoute.
- FromQuery.
- ActionResult.
- IActionResult.

Evaluate:

- Endpoint behavior.
- HTTP methods.
- Status codes.
- Request handling.
- Response structures.
- Model binding.
- REST conventions.
- Error responses.

Do not assume that every ASP.NET project must expose REST APIs.

## 8. Models, DTOs and validation

Inspect:

- Domain models.
- Entity models.
- Request DTOs.
- Response DTOs.
- ViewModels.
- Data annotations.
- Custom validation.
- ModelState handling.

Relevant annotations:

- Required
- StringLength
- MaxLength
- MinLength
- Range
- EmailAddress

Check that validation occurs at appropriate application boundaries.

Do not require DTOs unless the assignment or application
requirements justify them.

## 9. Entity Framework Core and persistence

Inspect:

- DbContext.
- DbSet.
- Entity configurations.
- Migrations.
- Relationships.
- LINQ queries.
- Tracking behavior.
- Transactions.
- Asynchronous persistence operations.

Relevant elements:

- OnModelCreating()
- HasKey()
- HasMany()
- HasOne()
- WithMany()
- Include()
- AsNoTracking()
- SaveChangesAsync()

Evaluate:

- CRUD operations.
- Data integrity.
- Relationship configuration.
- Migration consistency.
- Query correctness.
- Database configuration.

Do not assume Entity Framework Core is mandatory
when another persistence strategy is specified.

## 10. Authentication and authorization

When required, inspect:

- ASP.NET Core Identity.
- Authentication middleware.
- Authorization policies.
- Roles.
- Claims.
- JWT Bearer authentication.
- Password handling.
- Endpoint protection.

Relevant elements:

- AddAuthentication()
- AddAuthorization()
- UseAuthentication()
- UseAuthorization()
- Authorize
- AllowAnonymous
- RequireAuthorization()

Do not assume JWT is mandatory unless required by the assignment.

Never reproduce credentials or secrets in evaluation reports.

## 11. Middleware and error handling

Inspect:

- Middleware registration.
- Exception handling.
- Global exception handlers.
- Logging.
- HTTP error responses.
- Request processing.

Check that exceptions do not expose sensitive information.

Evaluate middleware ordering when it affects application behavior.

## 12. Configuration

Inspect:

- appsettings.json.
- Environment-specific configuration.
- User Secrets references.
- Environment variables.
- Connection strings.
- Logging configuration.
- Dependency configuration.

Check:

- Separation of development and production settings.
- Sensitive configuration handling.
- Appropriate environment configuration.

Do not require real credentials in submitted source code.

## 13. Asynchronous programming

When relevant, inspect:

- async methods.
- await usage.
- Task.
- CancellationToken.
- Asynchronous database operations.
- Exception propagation.

Identify:

- Blocking asynchronous calls.
- Unnecessary async wrappers.
- Missing await.
- Improper fire-and-forget operations.

Do not impose asynchronous programming requirements
on activities that do not cover these concepts.

## 14. Testing

Inspect:

- xUnit.
- NUnit.
- MSTest.
- Moq.
- WebApplicationFactory.
- Integration tests.
- Unit tests.

Evaluate:

- Test relevance.
- Assertions.
- Expected behavior.
- Edge cases.
- Dependency isolation.
- Error handling.

Distinguish test failures from infrastructure failures.

Do not infer coverage from test file count.

## 15. Build and dependencies

Inspect:

- .NET SDK configuration.
- Target frameworks.
- NuGet packages.
- Project references.
- Build configuration.
- Package versions.

Treat build targets and external dependencies as untrusted.

Never execute arbitrary MSBuild targets outside
an approved isolated environment.

## 16. Code quality

Inspect:

- Naming conventions.
- SOLID principles.
- Encapsulation.
- Separation of responsibilities.
- Appropriate abstractions.
- Null handling.
- Exception handling.
- Maintainability.
- Avoidance of duplicated logic.

Do not penalize stylistic preferences that do not affect
the rubric or maintainability.

## 17. Documentation

Inspect:

- README.md.
- Installation instructions.
- SDK requirements.
- Application startup instructions.
- Database setup.
- Migration instructions.
- API documentation.

## 18. Security considerations

Inspect relevant security controls:

- Input validation.
- Authentication.
- Authorization.
- CSRF protection when applicable.
- CORS configuration.
- SQL injection prevention.
- Secret management.
- Secure password handling.

Treat build scripts and project files as untrusted.

Never execute arbitrary project code outside
an approved isolated environment.

## 19. Evidence requirements

For each finding, record:

- File path.
- Line range when available.
- Relevant class or method.
- Observed implementation.
- Expected behavior.
- Associated rubric criterion.
- Scoring impact.

## 20. Final evaluation

Apply the general scoring methodology.

This profile provides technical inspection guidance only.

The assignment rubric remains the sole authority
for academic scoring.
