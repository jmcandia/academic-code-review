
# Kotlin / Android Evaluation Profile

## 1. Purpose

Provide technical inspection guidelines for academic applications
developed using Kotlin and Android.

Supported project types:

- Native Android applications.
- XML-based Android interfaces.
- Jetpack Compose applications.
- Applications using Room.
- Applications using Retrofit.
- Offline-first applications.
- Applications using MVVM.
- Applications with local and remote data synchronization.

This profile supplements the general evaluation methodology.

It does not introduce independent grading criteria.

## 2. Project identification

Inspect:

- settings.gradle
- settings.gradle.kts
- build.gradle
- build.gradle.kts
- gradle/libs.versions.toml
- AndroidManifest.xml
- src/main/java/
- src/main/kotlin/
- src/main/res/
- src/test/
- src/androidTest/

Identify:

- Kotlin version.
- Android Gradle Plugin version.
- Gradle version.
- Compile SDK.
- Minimum SDK.
- Target SDK.
- Application ID.
- Modules.
- Dependencies.
- Application entry point.

Do not assume a specific Android architecture.

## 3. Kotlin language fundamentals

Inspect:

- Variables and constants.
- Null safety.
- Functions.
- Classes and objects.
- Data classes.
- Interfaces.
- Inheritance.
- Extension functions.
- Collections.
- Generics.
- Sealed classes.
- Exception handling.
- Scope functions.

Evaluate concepts according to assignment requirements.

## 4. Android application architecture

Inspect:

- Package organization.
- Module organization.
- Separation of responsibilities.
- UI layer.
- Domain logic.
- Data layer.
- Dependency management.
- Application configuration.

When applicable, inspect:

- MVVM.
- Repository pattern.
- Use cases.
- Dependency Injection.
- Unidirectional data flow.

Do not require Clean Architecture or multiple layers
for introductory assignments.

## 5. Android components and lifecycle

When applicable, inspect:

- Activity.
- Fragment.
- Service.
- BroadcastReceiver.
- Application class.
- Lifecycle management.
- Intent handling.
- Navigation.

Relevant lifecycle methods include:

- onCreate()
- onStart()
- onResume()
- onPause()
- onStop()
- onDestroy()

Check lifecycle handling when relevant to the activity.

## 6. User interfaces with XML Views

Inspect:

- Layout XML files.
- View hierarchy.
- ConstraintLayout.
- LinearLayout.
- FrameLayout.
- RecyclerView.
- Adapters.
- ViewBinding.
- DataBinding.
- Resource management.
- Event handling.

Verify that layouts satisfy the assignment requirements.

Do not require Jetpack Compose when XML Views are specified.

## 7. Jetpack Compose

When Compose is used, inspect:

- @Composable functions.
- Composition.
- State management.
- Recomposition.
- remember.
- mutableStateOf.
- rememberSaveable.
- State hoisting.
- Modifiers.
- LazyColumn.
- LazyRow.
- Material components.
- Navigation Compose.

Check:

- Appropriate component responsibilities.
- State ownership.
- UI consistency.
- Reusable composables.
- Event handling.

Do not impose Compose-specific requirements
on XML-based projects.

## 8. Navigation

Inspect:

- Navigation Component.
- NavHost.
- NavController.
- Navigation graphs.
- Destinations.
- Arguments.
- Back navigation.
- Navigation state.

For Compose applications, inspect Navigation Compose
when used.

Verify that navigation matches the assignment requirements.

## 9. ViewModel and state management

When applicable, inspect:

- ViewModel.
- StateFlow.
- SharedFlow.
- LiveData.
- UI state.
- State restoration.
- Lifecycle-aware collection.
- Event handling.

Evaluate whether state survives relevant configuration changes
when required by the assignment.

Do not require a ViewModel for every simple screen.

## 10. Persistence and local storage

Inspect:

- Room.
- SQLite.
- DAO interfaces.
- Entities.
- Database classes.
- DataStore.
- SharedPreferences.
- Repository implementations.

For Room, inspect:

- @Entity
- @Dao
- @Database
- @Query
- @Insert
- @Update
- @Delete
- TypeConverters

Evaluate:

- Data modeling.
- CRUD operations.
- Query correctness.
- Persistence behavior.
- Migration handling when applicable.

Do not assume Room is mandatory unless specified.

## 11. Networking and remote APIs

When applicable, inspect:

- Retrofit.
- OkHttp.
- HTTP requests.
- API interfaces.
- Serialization.
- Response handling.
- Error handling.
- Network configuration.

Check:

- Appropriate HTTP methods.
- Request construction.
- Response processing.
- Error states.
- Loading states.
- Network permissions.

Never assume network connectivity is always available.

## 12. Coroutines and asynchronous programming

Inspect:

- Kotlin Coroutines.
- suspend functions.
- CoroutineScope.
- Dispatchers.
- Structured concurrency.
- Flow.
- StateFlow.
- Lifecycle-aware scopes.

Identify:

- Blocking operations on the main thread.
- Incorrect coroutine scope usage.
- Unhandled exceptions.
- Unnecessary global scopes.
- Incorrect dispatcher selection.

Evaluate only when relevant to the assignment.

## 13. Offline-first and synchronization

When required, inspect:

- Local data source.
- Remote data source.
- Repository coordination.
- Source of truth.
- Synchronization strategy.
- Conflict resolution.
- Retry handling.
- Connectivity handling.
- Pending operations.
- Synchronization status.

For bidirectional synchronization, inspect:

- Local-to-remote updates.
- Remote-to-local updates.
- Conflict detection.
- Conflict resolution.
- Duplicate prevention.
- Idempotency.
- Failure recovery.

Do not assume offline-first synchronization
is required for ordinary Android applications.

## 14. Dependency Injection

When applicable, inspect:

- Hilt.
- Dagger.
- Koin.
- Manual dependency injection.

Evaluate dependency configuration and object responsibilities.

Do not require a specific dependency injection framework
unless specified.

## 15. Permissions and application configuration

Inspect:

- AndroidManifest.xml.
- Runtime permissions.
- Application configuration.
- Network permissions.
- File access.
- Activity declarations.
- Exported components.
- Intent filters.

Check that permissions are appropriate and not unnecessarily broad.

## 16. Testing

Inspect:

- JUnit.
- MockK.
- Mockito.
- AndroidX Test.
- Compose UI Testing.
- Espresso.
- Instrumentation tests.

Evaluate:

- Unit tests.
- ViewModel tests.
- Repository tests.
- DAO tests.
- UI tests.
- Integration tests.

Distinguish test infrastructure failures
from implementation defects.

Do not infer test coverage from test file count.

## 17. Build and dependencies

Inspect:

- Gradle configuration.
- Android Gradle Plugin.
- Kotlin plugin.
- Version catalogs.
- Dependency declarations.
- SDK compatibility.
- Build variants.
- Signing configuration references.

Treat Gradle scripts and plugins as untrusted.

Never execute build scripts outside an approved isolated environment.

## 18. Code quality

Inspect:

- Naming conventions.
- Null safety.
- Separation of responsibilities.
- Reusable components.
- State management.
- Appropriate abstractions.
- Coroutine handling.
- Resource management.
- Maintainability.

Do not impose unnecessary architectural complexity
on introductory applications.

## 19. User experience and accessibility

When relevant to the assignment, inspect:

- Screen navigation.
- Layout adaptation.
- Accessibility labels.
- Content descriptions.
- Touch targets.
- Resource localization.
- Error messages.
- Loading and empty states.

Visual requirements must be verified through rendered output
when the rubric requires them.

Do not infer complete visual correctness from source code alone.

## 20. Security considerations

Inspect:

- Permission usage.
- Secret management.
- Network security configuration.
- Secure local storage when required.
- Exported components.
- Input validation.
- Authentication.
- Authorization.

Never expose credentials or tokens in evaluation reports.

## 21. Documentation

Inspect:

- README.md.
- Android Studio requirements.
- SDK requirements.
- Build instructions.
- Execution instructions.
- Application functionality.
- Backend configuration when applicable.

## 22. Evidence requirements

For every finding, record:

- File path.
- Line range when available.
- Relevant class or composable.
- Relevant Android component.
- Observed implementation.
- Expected behavior.
- Associated rubric criterion.
- Scoring impact.

## 23. Final evaluation

Apply the general scoring methodology.

This profile provides technical inspection guidance only.

The assignment rubric remains the sole authority
for academic scoring.
