# Evaluation Lab

This lab defines six cross-technology fixtures and two evaluation modes:

- `static`: inspect files without running the submission.
- `both`: perform static inspection and, only in an approved isolated environment, execute the fixture's documented checks.

The configured campaign uses `both` for all six projects. A run should record static findings and execution findings separately, then compare each to the expected results. Never execute fixture code on the host. The `expected/` directory is the answer key: do not include it in the submission context for a run being measured.

## Fixture matrix

| Fixture | Technology | Primary behavior under review |
|---|---|---|
| `python-django` | Python / Django | CRUD, validation and authorization boundaries |
| `java-spring-boot` | Java / Spring Boot | REST validation, persistence and error mapping |
| `csharp-aspnet` | C# / ASP.NET | API contract, validation and async persistence |
| `java-javafx` | Java / JavaFX | UI state, input validation and event handling |
| `javascript-typescript` | JavaScript / TypeScript | asynchronous API flow, input handling and UI states |
| `kotlin-android` | Kotlin / Android | lifecycle-safe state, form validation and repository use |

Each fixture is intentionally designed to include real defects, compliant behavior, and at least one non-finding trap. Exact defect locations and expected scoring belong only in `expected/`. The JavaFX fixture maps the 13 weighted DSY1102 indicators; the other five use normalized five-criterion rubrics with two indicators per criterion.

## Outcome protocol

For every run, preserve the original report and record the skill revision, fixture ID, mode, date, model/agent identifier when available, and execution environment. Compare findings by defect ID and evidence, not wording. A detection counts only when the report cites relevant evidence and explains the impact. A false positive is an asserted defect contradicted by the fixture. A missed defect is an expected defect with no supported finding. Findings with no evidence do not count as detections.

Do not require a particular architecture or style unless the fixture assignment requires it. Environmental execution failures are recorded as inconclusive, never as student defects. Expected scores are based on the rubric's explicit levels and weights and must be recalculated from indicator data, not copied as an unexplained total.

`expected/` is evaluator-only reference data. When measuring the skill, stage only `fixtures/<id>/` plus the corresponding assignment and rubric. Do not pass expected results or defect manifests to the reviewing agent.
