
# Python / Django Evaluation Profile

## 1. Purpose

Provide technical inspection guidelines for academic projects
developed using Python and Django.

This profile supports:

- Traditional Django applications.
- Django REST Framework APIs.
- Django applications using relational databases.
- Modular Django projects.

This profile supplements the general evaluation methodology.

It does not introduce independent grading criteria.

## 2. Project identification

Inspect the following indicators:

- manage.py
- requirements.txt
- pyproject.toml
- Pipfile
- Django settings modules
- urls.py
- models.py
- apps.py
- migrations/
- tests.py

Identify:

- Python version.
- Django version.
- Installed applications.
- Database configuration.
- Project entry point.
- Application modules.
- External dependencies.

Do not assume that a particular directory structure is mandatory.

## 3. Project architecture

Inspect:

- Separation between project configuration and applications.
- Application responsibilities.
- Module organization.
- Reusable components.
- Configuration management.
- Dependency organization.

Evaluate architectural decisions according to assignment requirements.

Do not require unnecessary architectural complexity.

## 4. Models and data modeling

Inspect:

- Model definitions.
- Field types.
- Primary keys.
- Foreign keys.
- Relationships.
- Constraints.
- Model validation.
- Meta options.

Relevant elements:

- models.Model
- ForeignKey
- OneToOneField
- ManyToManyField
- unique=True
- null
- blank
- choices

Check whether the data model represents the required domain.

Do not assume that every project requires complex relationships.

## 5. Database and ORM

Inspect:

- ORM queries.
- QuerySet usage.
- CRUD operations.
- Filtering.
- Ordering.
- Aggregations.
- Transactions.
- Database migrations.

Check:

- Migration consistency.
- Appropriate query construction.
- Potential N+1 query problems when relevant.
- Database configuration.
- Data integrity.

Do not require a specific database unless specified.

## 6. Views and request handling

Inspect:

- Function-based views.
- Class-based views.
- Request processing.
- Response handling.
- HTTP methods.
- Status codes.
- Redirects.
- Error handling.

For REST APIs, inspect:

- APIView.
- ViewSet.
- GenericAPIView.
- ModelViewSet.
- Routers.
- Serializers.

Verify that endpoints satisfy the assignment requirements.

## 7. Forms and serializers

Inspect:

- Django Forms.
- ModelForms.
- Django REST Framework serializers.
- Input validation.
- Required fields.
- Data conversion.
- Error responses.

Relevant components:

- forms.Form
- forms.ModelForm
- serializers.Serializer
- serializers.ModelSerializer
- validate()
- validate_field()

Do not confuse frontend validation with server-side validation.

## 8. URL routing

Inspect:

- Root URL configuration.
- Application URL configuration.
- URL patterns.
- Named routes.
- Namespaces.
- Route parameters.
- API router configuration.

Verify that expected endpoints are accessible through
their configured routes.

## 9. Authentication and authorization

When required, inspect:

- Django authentication.
- Login and logout.
- User models.
- Permissions.
- Groups.
- Decorators.
- Middleware.
- Django REST Framework permissions.
- Token or session authentication.

Relevant elements:

- authenticate()
- login()
- logout()
- login_required
- PermissionRequiredMixin
- IsAuthenticated
- IsAdminUser

Do not require a particular authentication strategy
unless specified by the assignment.

## 10. Templates and frontend integration

For traditional Django applications, inspect:

- Template inheritance.
- Context handling.
- Template tags.
- Static files.
- Forms.
- CSRF protection.

For API-based projects, inspect the separation between
backend responsibilities and frontend clients.

## 11. Application configuration

Inspect:

- settings.py
- Environment variables.
- INSTALLED_APPS.
- MIDDLEWARE.
- Database settings.
- Static and media configuration.
- Allowed hosts.
- Debug configuration.

Check that sensitive credentials are not hardcoded.

Do not reproduce discovered secrets in evaluation reports.

## 12. Exception handling and validation

Inspect:

- Model validation.
- Form validation.
- Serializer validation.
- Exception handling.
- HTTP error responses.
- Logging.

Distinguish validation errors from infrastructure failures.

## 13. Testing

Inspect:

- unittest.
- Django TestCase.
- SimpleTestCase.
- APIClient.
- APITestCase.
- pytest and pytest-django, when used.

Evaluate:

- Test relevance.
- Assertions.
- Expected behavior.
- Edge cases.
- Error scenarios.

Do not infer test coverage from the number of test files.

## 14. Code quality

Inspect:

- Naming conventions.
- Function responsibilities.
- Class responsibilities.
- Reusability.
- Encapsulation.
- Separation of concerns.
- Appropriate abstraction.
- Avoidance of duplicated logic.
- PEP 8 compliance when relevant.

Do not penalize stylistic preferences that do not affect
the rubric or maintainability.

## 15. Security considerations

Inspect relevant security controls:

- CSRF protection.
- Authentication.
- Authorization.
- SQL injection prevention.
- Password handling.
- Secret management.
- DEBUG configuration.
- Input validation.
- Safe file uploads.

Never execute management commands or application code
outside an approved isolated environment.

## 16. Documentation

Inspect:

- README.md.
- Installation instructions.
- Virtual environment setup.
- Dependency installation.
- Database configuration.
- Migration instructions.
- Application startup instructions.
- API documentation.

## 17. Evidence requirements

For each finding, record:

- File path.
- Line range when available.
- Relevant class, function or model.
- Expected behavior.
- Observed implementation.
- Associated rubric criterion.
- Scoring impact.

## 18. Final evaluation

Apply the general scoring methodology.

This profile provides technical inspection guidance only.

The assignment rubric remains the sole authority
for academic scoring.
