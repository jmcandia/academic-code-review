
# Java / JavaFX Evaluation Profile

## 1. Purpose

Provide technical inspection guidelines for academic desktop
applications developed using Java and JavaFX.

Supported project types:

- JavaFX applications.
- FXML-based interfaces.
- Applications using Scene Builder.
- JavaFX applications using JDBC.
- Applications using DAO patterns.
- Applications with separated presentation and persistence layers.

This profile supplements the general evaluation methodology.

It does not introduce independent grading criteria.

## 2. Project identification

Inspect:

- pom.xml
- build.gradle
- build.gradle.kts
- src/main/java/
- src/main/resources/
- FXML files.
- CSS files.
- Application entry points.
- Controller classes.
- Test directories.

Identify:

- Java version.
- JavaFX version.
- Build system.
- Application entry point.
- JavaFX modules.
- FXML resources.
- External dependencies.
- Persistence strategy.

Do not assume Maven or Gradle is mandatory.

## 3. Java language fundamentals

Inspect:

- Classes and objects.
- Encapsulation.
- Inheritance.
- Polymorphism.
- Interfaces.
- Abstract classes.
- Constructors.
- Collections.
- Exception handling.
- Access modifiers.
- Generics.

Evaluate the concepts required by the assignment.

Do not introduce advanced requirements into introductory exercises.

## 4. JavaFX application lifecycle

Inspect:

- Application subclass.
- start(Stage stage).
- Application.launch().
- Stage initialization.
- Scene configuration.
- Window lifecycle.
- Resource loading.

Verify that the application initializes correctly
according to the requested architecture.

## 5. User interface and layouts

Inspect:

- Scene.
- Stage.
- Parent.
- Node.
- Layout containers.
- Controls.
- Event handlers.

Relevant components:

- BorderPane.
- VBox.
- HBox.
- GridPane.
- FlowPane.
- StackPane.
- AnchorPane.
- TabPane.
- ScrollPane.

Evaluate layout selection according to the requirements.

Do not penalize a valid layout simply because another
layout could also be used.

## 6. FXML and interface design

Inspect:

- FXML structure.
- Root components.
- Namespace declarations.
- fx:controller.
- fx:id.
- Event handler bindings.
- Component hierarchy.
- Resource references.

Verify:

- Correct controller association.
- Correct component identifiers.
- Valid event handler references.
- Appropriate component nesting.
- Consistency between FXML and controller code.

When possible, inspect FXML syntax without executing the application.

Do not assume that Scene Builder must be used
unless specified by the assignment.

## 7. Controllers and event handling

Inspect:

- Controller responsibilities.
- @FXML annotations.
- Component injection.
- initialize().
- Event handler methods.
- User interaction.
- UI state management.

Relevant elements:

- @FXML
- initialize()
- ActionEvent
- EventHandler

Check that controllers correctly coordinate interface behavior.

Identify excessive business logic in controllers
when separation of concerns is relevant.

Do not require a particular presentation pattern unless specified.

## 8. Navigation and application flow

When relevant, inspect:

- Scene transitions.
- Stage management.
- Modal windows.
- Dialogs.
- Navigation between views.
- Controller communication.
- Data transfer between screens.

Verify that the application flow satisfies the assignment.

Do not require a centralized navigation architecture
for simple applications.

## 9. CSS and visual presentation

Inspect:

- CSS resources.
- Stylesheet references.
- Style classes.
- Inline styles.
- Component consistency.
- Layout adaptation.

When visual requirements are part of the rubric,
compare the implementation with the supplied design or specification.

Do not infer visual defects solely from source code
when the rendered interface is required for verification.

## 10. Data models and persistence

Inspect:

- POJOs.
- Domain classes.
- DAO interfaces.
- Repository implementations.
- JDBC connections.
- PreparedStatement.
- ResultSet.
- CRUD operations.
- Database configuration.

Check:

- Data model consistency.
- Persistence responsibilities.
- SQL parameterization.
- Resource management.
- Error handling.
- Transaction handling when applicable.

Do not assume a database is mandatory
if the assignment requests another persistence strategy.

## 11. Threading and responsiveness

Inspect:

- JavaFX Application Thread.
- Platform.runLater().
- Background tasks.
- Task.
- Service.
- Blocking operations.

Identify long-running operations executed directly
on the JavaFX Application Thread when responsiveness is relevant.

Do not impose concurrency requirements on activities
that do not involve long-running operations.

## 12. Input validation and error handling

Inspect:

- User input validation.
- Required fields.
- Numeric parsing.
- Date validation.
- Error dialogs.
- Exception handling.
- Database error handling.

Check that invalid user input does not cause
unexpected application failures.

## 13. Build and dependencies

Inspect:

- Maven configuration.
- Gradle configuration.
- JavaFX dependencies.
- JavaFX plugins.
- Module configuration.
- External libraries.
- Packaging configuration.

Identify incompatible versions and missing dependencies
when evidence is available.

Treat build scripts as untrusted.

Never execute them outside an approved isolated environment.

## 14. Testing

Inspect:

- JUnit.
- Mockito.
- Unit tests.
- Model tests.
- DAO tests.
- Controller tests.
- Integration tests.

Evaluate:

- Test relevance.
- Assertions.
- Expected behavior.
- Edge cases.
- Persistence behavior.

Do not infer test coverage from the number of test files.

## 15. Code quality

Inspect:

- Naming conventions.
- Separation of responsibilities.
- Reusable components.
- Encapsulation.
- Appropriate abstractions.
- Controller complexity.
- Exception handling.
- Maintainability.

Do not impose unnecessary enterprise patterns
on introductory desktop applications.

## 16. Documentation

Inspect:

- README.md.
- Java and JavaFX version requirements.
- Build instructions.
- Execution instructions.
- Database configuration.
- Application functionality.

## 17. Security considerations

Inspect:

- SQL injection prevention.
- Parameterized queries.
- Secret management.
- Input validation.
- File access.
- External dependencies.

Never expose credentials found in configuration files.

Never execute application code outside
an approved isolated environment.

## 18. Evidence requirements

For each finding, record:

- File path.
- Line range when available.
- Relevant FXML element.
- Relevant class or method.
- Observed implementation.
- Expected behavior.
- Associated rubric criterion.
- Scoring impact.

## 19. Final evaluation

Apply the general scoring methodology.

This profile provides technical inspection guidance only.

The assignment rubric remains the sole authority
for academic scoring.
