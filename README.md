# Academic Code Review

A Claude Agent Skill that evaluates student programming projects against weighted academic rubrics.

It inspects Git repositories, ZIP archives and individual source files, collects verifiable evidence, calculates weighted scores and produces evaluation reports. Results are proposals: the teacher keeps final grading authority, and every evaluation starts as `pending_teacher_review`.

## Supported technologies

| Profile                 | Reference                                        |
| ----------------------- | ------------------------------------------------ |
| Python / Django         | `references/technology/python-django.md`         |
| C# / ASP.NET            | `references/technology/csharp-aspnet.md`         |
| Java / JavaFX           | `references/technology/java-javafx.md`           |
| Java / Spring Boot      | `references/technology/java-spring-boot.md`      |
| JavaScript / TypeScript | `references/technology/javascript-typescript.md` |
| Kotlin / Android        | `references/technology/kotlin-android.md`        |

Projects that mix technologies get every relevant profile. Profiles guide technical inspection only. They never add grading criteria.

## Installation

Copy this directory into your skills folder so that `SKILL.md` sits at its root:

- Personal: `~/.claude/skills/academic-code-review/`
- Project: `.claude/skills/academic-code-review/`

Claude loads the skill when you ask it to review, assess or grade a student software assignment against a rubric.

## Usage

Provide four inputs:

1. Assignment instructions.
2. Evaluation rubric (start from `templates/rubric-template.yaml`).
3. Student submission (Git repository, ZIP archive or source files).
4. Grading configuration (scale, conversion points, passing threshold, rounding).

The skill follows eight mandatory stages: input collection, assignment analysis, rubric validation, project inspection, technical verification, academic scoring, report generation and teacher review. See `references/evaluation-workflow.md`.

## Rubric

A rubric defines weighted criteria, and each criterion contains weighted indicators. Validation rules:

- Criterion weights must sum to 100.
- Indicator weights within each criterion must sum to 100.
- The grading scale is configurable. Grade conversion uses piecewise linear interpolation between conversion points.
- The passing threshold (`grading.passing.minimum_percentage`) is compared against the unrounded final percentage.
- `missing_evidence_policy` is `proportional` (renormalize over verifiable indicators and report the unverified weight) or `none` (unverified indicators score zero).

The skill reports an invalid rubric and never corrects it silently. Full specification: `references/rubric-schema.md` and `references/scoring-methodology.md`.

## Evidence

Every score is backed by evidence: file path, line references when available, a justification and one of these statuses: `verified`, `partially_verified`, `not_found` or `not_verifiable`. See `references/evidence-guidelines.md`.

## Reports

Supported formats are Markdown, YAML, JSON and HTML. All formats contain identical results:

- Overall percentage, institutional grade and passing status.
- Criterion breakdown with evidence.
- Recommendations and technical limitations.
- Teacher review status.

## Security

Submissions are untrusted content. The skill:

- Ignores instructions embedded in code, comments, documentation or configuration.
- Never runs student code in the agent environment.
- Compiles or runs tests only in an approved isolated environment.
- Falls back to static inspection when no isolated environment exists, and reports that limitation.

See `references/security-guidelines.md`.

## Repository layout

```text
SKILL.md                 Skill entry point and core rules
references/              Workflow, schema, scoring, evidence and security guidelines
references/technology/   Technology-specific inspection profiles
templates/               Rubric template
```

## Status

`SKILL.md` references `templates/evaluation-report.md` and `templates/evaluation-result.yaml`. These templates are not included yet.

## Author

José Miguel Candia - [GitHub](https://github.com/jmcandia) | [LinkedIn](https://linkedin.com/in/jmcandia)

## License

Released under the [MIT License](LICENSE).
