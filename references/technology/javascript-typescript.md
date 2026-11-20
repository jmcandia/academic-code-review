
# JavaScript / TypeScript Evaluation Profile

## 1. Purpose

Provide technical inspection guidelines for academic projects
developed using JavaScript and TypeScript.

Supported project types:

- JavaScript applications.
- TypeScript applications.
- Node.js applications.
- REST APIs.
- Frontend applications.
- Full-stack applications.
- React applications.
- Angular applications.
- Vue applications.
- Express and NestJS applications.

This profile supplements the general evaluation methodology.

It does not introduce independent grading criteria.

## 2. Project identification

Inspect:

- package.json
- package-lock.json
- pnpm-lock.yaml
- yarn.lock
- tsconfig.json
- jsconfig.json
- vite.config.*
- angular.json
- next.config.*
- src/
- public/
- tests/
- eslint.config.*

Identify:

- JavaScript or TypeScript.
- Runtime environment.
- Framework.
- Package manager.
- Build tool.
- Entry points.
- Dependencies.
- Test framework.
- Module system.

Do not assume a specific framework or package manager.

## 3. JavaScript fundamentals

Inspect:

- Variables and scope.
- Functions.
- Arrow functions.
- Objects and arrays.
- Classes.
- Prototypes.
- Modules.
- Destructuring.
- Spread and rest operators.
- Closures.
- Promises.
- Async and await.
- Exception handling.

Evaluate only the language concepts required by the assignment.

## 4. TypeScript fundamentals

When TypeScript is used, inspect:

- Type annotations.
- Interfaces.
- Type aliases.
- Classes.
- Generics.
- Enums.
- Union types.
- Intersection types.
- Optional properties.
- Type narrowing.
- Strict compiler options.

Check whether types accurately represent the application domain.

Identify unnecessary use of any when type safety is relevant.

Do not penalize valid JavaScript interoperability
unless prohibited by the assignment.

## 5. Project architecture

Inspect:

- Directory organization.
- Module boundaries.
- Separation of responsibilities.
- Component organization.
- Service organization.
- Shared utilities.
- Configuration.
- Dependency management.

Evaluate architecture according to assignment requirements.

Do not impose a particular architectural pattern
on introductory projects.

## 6. Frontend applications

When applicable, inspect:

- Component organization.
- Props and state.
- Event handling.
- Conditional rendering.
- Lists and keys.
- Form handling.
- Routing.
- Lifecycle behavior.
- State management.
- API integration.

For React, inspect relevant use of:

- Components.
- Hooks.
- useState.
- useEffect.
- Context.
- Custom hooks.

For Angular, inspect:

- Components.
- Services.
- Dependency Injection.
- Templates.
- Directives.
- Pipes.
- Routing.
- Forms.
- Signals when applicable.

For Vue, inspect:

- Components.
- Props.
- Reactive state.
- Computed properties.
- Watchers.
- Lifecycle hooks.
- Routing.

Do not apply framework-specific rules
to projects that do not use that framework.

## 7. Backend applications

When Node.js is used, inspect:

- Application entry point.
- Routing.
- Controllers.
- Services.
- Middleware.
- Request handling.
- Response handling.
- Error handling.
- Dependency management.

For Express, inspect:

- Router.
- Middleware.
- Route handlers.
- Request and response objects.
- Error middleware.

For NestJS, inspect:

- Modules.
- Controllers.
- Providers.
- Services.
- Dependency Injection.
- DTOs.
- Pipes.
- Guards.
- Interceptors.
- Exception filters.

Do not assume Express or NestJS is mandatory.

## 8. REST APIs and HTTP

Inspect:

- HTTP methods.
- Endpoint definitions.
- Request validation.
- Response structures.
- Status codes.
- Error responses.
- Routing conventions.
- API documentation.

Verify endpoint behavior against assignment requirements.

## 9. Data management

When applicable, inspect:

- Data models.
- Repository abstractions.
- Database clients.
- ORM usage.
- Query construction.
- CRUD operations.
- Transactions.
- Data validation.

Relevant technologies may include:

- Prisma.
- TypeORM.
- Sequelize.
- Mongoose.
- Drizzle.

Do not require a specific ORM unless specified.

## 10. Authentication and authorization

When required, inspect:

- Authentication flows.
- Session management.
- Token handling.
- JWT.
- Authorization policies.
- Role-based access control.
- Password handling.
- Route protection.

Never expose credentials or secrets in reports.

## 11. Asynchronous programming

Inspect:

- Promises.
- Async and await.
- Error propagation.
- Concurrent operations.
- Event handling.
- Resource cleanup.

Identify:

- Unhandled promise rejections.
- Incorrect asynchronous control flow.
- Missing error handling.
- Unnecessary blocking operations.

## 12. Configuration and dependencies

Inspect:

- package.json scripts.
- Dependency declarations.
- Environment variables.
- Build configuration.
- Runtime configuration.
- Compiler configuration.

Check that sensitive values are not hardcoded.

Do not automatically install arbitrary packages.

## 13. Testing

Inspect:

- Jest.
- Vitest.
- Mocha.
- Jasmine.
- Playwright.
- Cypress.
- Testing Library.
- Supertest.

Evaluate:

- Test relevance.
- Assertions.
- Expected behavior.
- Edge cases.
- Component behavior.
- API behavior.
- Error scenarios.

Do not infer test coverage from the number of test files.

## 14. Code quality

Inspect:

- Naming conventions.
- Modularity.
- Reusability.
- Separation of concerns.
- Type safety.
- Error handling.
- Maintainability.
- Appropriate abstractions.
- Avoidance of duplicated logic.

When configured, inspect ESLint and Prettier results.

Do not treat formatting preferences as functional defects.

## 15. Accessibility and interface quality

When relevant to the assignment, inspect:

- Semantic HTML.
- Accessible labels.
- Keyboard navigation.
- Form accessibility.
- Alternative text.
- Appropriate component semantics.

Visual appearance must be verified through rendered output
when the rubric requires it.

Do not infer visual correctness solely from source code.

## 16. Security considerations

Inspect:

- Input validation.
- Output encoding.
- XSS prevention.
- CSRF protection when applicable.
- SQL injection prevention.
- Authentication.
- Authorization.
- Dependency security.
- Secret management.
- CORS configuration.

Treat package scripts and build tools as untrusted.

Never execute student code outside an approved isolated environment.

## 17. Documentation

Inspect:

- README.md.
- Installation instructions.
- Runtime requirements.
- Environment configuration.
- Build instructions.
- Execution instructions.
- API documentation.

## 18. Evidence requirements

For every finding, record:

- File path.
- Line range when available.
- Relevant component, function or class.
- Observed implementation.
- Expected behavior.
- Associated rubric criterion.
- Scoring impact.

## 19. Final evaluation

Apply the general scoring methodology.

This profile provides technical inspection guidance only.

The assignment rubric remains the sole authority
for academic scoring.
