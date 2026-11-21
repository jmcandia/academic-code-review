
# Evaluation Workflow

## 1. Purpose

Define the complete operational workflow for evaluating
student programming assignments.

The workflow must be deterministic, traceable,
secure and reproducible.

## 2. Workflow overview

The evaluation consists of eight stages:

1. Input collection.
2. Assignment analysis.
3. Rubric validation.
4. Project inspection and technology detection.
5. Technical verification.
6. Academic scoring.
7. Report generation.
8. Teacher review.

## 3. Stage 1: Input collection

Collect:

- Assignment instructions.
- Evaluation rubric.
- Student submission.
- Grading configuration.

Supported submission types:

- Git repository.
- ZIP archive.
- Individual source files.

Validate the availability and integrity of the inputs.

If essential information is missing, request it before scoring.

## 4. Stage 2: Assignment analysis

Read the assignment instructions.

Identify:

- Learning objectives.
- Functional requirements.
- Technical requirements.
- Required technologies.
- Architectural constraints.
- Expected deliverables.
- Explicit exclusions.

Create a requirement-to-rubric mapping.

Identify requirements not covered by the rubric.

Do not introduce new scoring criteria without teacher approval.

## 5. Stage 3: Rubric validation

Validate the rubric against references/rubric-schema.md.

Check:

- Schema version.
- Required fields.
- Criterion identifiers.
- Criterion weights.
- Indicator weights.
- Score ranges.
- Grading scale.
- Grade conversion.
- Passing threshold.
- Report formats.

Criterion weights must sum to 100.

Indicator weights within each criterion must sum to 100.

If validation fails, stop academic scoring.

Report actionable validation errors.

## 6. Stage 4: Project inspection and technology detection

Inspect the submission without executing student code.

Identify:

- Programming languages.
- Frameworks.
- Build systems.
- Application entry points.
- Project modules.
- Dependency declarations.
- Configuration files.
- Test structure.
- Architectural organization.

### 6.1 Technology detection

Use project evidence to identify the technology profile.

Python / Django indicators:

- manage.py
- django dependencies
- settings.py
- urls.py
- models.py

C# / ASP.NET indicators:

- .csproj files
- Microsoft.AspNetCore dependencies
- Program.cs
- Controllers
- appsettings.json

Java / JavaFX indicators:

- JavaFX dependencies
- javafx.application.Application
- FXML resources
- JavaFX controllers
- Scene Builder resources

Java / Spring Boot indicators:

- spring-boot-starter dependencies
- Spring Boot Maven or Gradle plugins
- @SpringBootApplication
- application.properties
- application.yml
- Spring Boot application configuration

JavaScript / TypeScript indicators:

- package.json
- tsconfig.json
- JavaScript or TypeScript source files
- framework-specific configuration

Kotlin / Android indicators:

- Android Gradle Plugin
- Kotlin Android plugin
- AndroidManifest.xml
- Kotlin source files
- Android application modules

Detection must be based on multiple indicators whenever possible.

A dependency declaration alone does not prove
that the corresponding framework is actually used.

### 6.2 Profile selection

Load the corresponding technology references:

| Technology              | Reference                                      |
| ----------------------- | ---------------------------------------------- |
| Python / Django         | references/technology/python-django.md         |
| C# / ASP.NET            | references/technology/csharp-aspnet.md         |
| Java / JavaFX           | references/technology/java-javafx.md           |
| Java / Spring Boot      | references/technology/java-spring-boot.md      |
| JavaScript / TypeScript | references/technology/javascript-typescript.md |
| Kotlin / Android        | references/technology/kotlin-android.md        |

JavaFX and Spring Boot must be evaluated independently.

If a project contains multiple frameworks or modules,
load all relevant profiles.

If detection is ambiguous:

1. Record the detected indicators.
2. Explain the ambiguity.
3. Request clarification when it affects evaluation.
4. Avoid unsupported technology-specific conclusions.

### 6.3 Profile limitations

Technology profiles provide technical inspection guidance.

They do not define additional academic scoring criteria.

The teacher-provided rubric remains authoritative.

Do not penalize technologies, architectures or dependencies
that are not prohibited by the assignment.

## 7. Stage 5: Technical verification

Perform static inspection first.

Identify implementations relevant to each rubric criterion.

When an isolated execution environment is available
and authorized, perform appropriate checks:

- Compilation.
- Unit tests.
- Integration tests.
- Static analysis.
- Dependency validation.
- Configuration validation.

Apply references/security-guidelines.md.

Do not execute arbitrary code outside the approved sandbox.

Record:

- Tool and version.
- Execution command.
- Environment.
- Execution status.
- Relevant output.
- Limitations.

Distinguish environmental failures from student implementation defects.

A successful build does not prove functional correctness.

A failed build does not automatically invalidate unrelated criteria.

## 8. Stage 6: Academic scoring

Evaluate every rubric criterion independently.

For each criterion:

1. Identify relevant indicators.
2. Select the appropriate technology guidance.
3. Locate supporting evidence.
4. Verify expected behavior.
5. Determine compliance.
6. Assign indicator scores.
   When the rubric uses discrete performance levels, record the selected
   level identifier and descriptor and award exactly its configured value.
7. Aggregate criterion scores.
8. Calculate weighted contribution.
9. Document justification.
10. Record uncertainty and limitations.

Use:

- references/scoring-methodology.md
- references/evidence-guidelines.md
- Relevant technology profiles.

Do not skip criteria.

If a criterion cannot be evaluated,
mark it as not_verifiable and explain why.

Do not penalize the same underlying defect multiple times
unless independent consequences are explicitly established.

## 9. Stage 7: Report generation

Generate requested formats:

- Markdown.
- YAML.
- JSON.
- HTML.

Ensure all reports contain identical evaluation values.

Include:

- Assignment information.
- Student information when available.
- Submission revision.
- Detected technologies.
- Selected technology profiles.
- Overall result.
- Criterion breakdown.
- Indicator breakdown.
- Evidence references.
- Technical verification results.
- Recommendations.
- Limitations.
- Teacher review status.

Set the initial completed evaluation status to:

pending_teacher_review

## 10. Stage 8: Teacher review

Present the evaluation for teacher approval.

Supported decisions:

- Approve.
- Modify.
- Request reevaluation.
- Reject.

For modifications, record:

- Original score.
- Revised score.
- Criterion identifier.
- Reason.
- Teacher authorization.
- Date.

Recalculate dependent totals and grade conversions
after any scoring modification.

An approved evaluation must preserve its original
automated assessment and teacher modifications.

## 11. Reevaluation

When reevaluation is requested:

- Identify the reason.
- Determine whether the submission changed.
- Determine whether the rubric changed.
- Determine whether technology detection changed.
- Reuse valid evidence when appropriate.
- Reinspect affected components.
- Recalculate scores.
- Preserve previous evaluation results.

Never silently overwrite a previous evaluation.

## 12. Batch evaluation

When multiple students are evaluated:

1. Validate the rubric once.
2. Process submissions independently.
3. Detect each project's technologies independently.
4. Select relevant technology profiles per submission.
5. Preserve individual evidence.
6. Use identical grading configuration.
7. Detect missing or duplicate submissions.
8. Generate individual reports.
9. Generate a course summary.

Do not assume all students use identical project structures.

Never use one student's implementation
as evidence for another student's score.

## 13. Workflow failure handling

If a stage fails:

- Record the failure.
- Identify affected criteria.
- Preserve completed work.
- Avoid fabricated results.
- Request clarification when necessary.

An incomplete evaluation must not be presented
as a completed evaluation.

## 14. Completion criteria

An evaluation is ready for teacher review when:

- The rubric is valid.
- The submission has been inspected.
- Technologies have been identified.
- Relevant profiles have been selected.
- All criteria have been addressed.
- Scores have been calculated.
- Evidence has been recorded.
- Limitations have been documented.
- Reports have been generated.

Final approval remains the responsibility of the teacher.
