# Academic Code Review

An Agent Skill that evaluates student programming projects against weighted academic rubrics.

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

Install the skill from this public GitHub repository with the [`skills` CLI](https://www.skills.sh/docs/cli). You need Node.js and npm (the command runs through `npx`).

For a project-local installation, run this from the repository where you want to use the skill:

```sh
npx skills add jmcandia/academic-code-review --skill academic-code-review
```

For a user-wide installation, add `-g`:

```sh
npx skills add jmcandia/academic-code-review --skill academic-code-review -g
```

The CLI prompts you to choose the agent(s) to configure. To select an agent explicitly, add `-a <agent>` (for example, `-a claude-code`). Check the CLI documentation for supported agents and options. After installation, ask your agent to review, assess or grade a student software assignment against a rubric. If the skill does not appear, restart the agent and confirm it was installed in the correct scope.

## Usage

Prepare a YAML rubric with the assignment, grading configuration, performance levels and criteria. Start a conversation with the agent where the skill is installed and ask it to use `academic-code-review`. The rubric template also has singular `student` and `submission` fields: fill them for a single evaluation, or leave them empty and provide a student-to-submission mapping for a batch. Do not put a list of students inside the rubric; each generated evaluation result represents one student and one submission.

### Configure and evaluate one student

Copy `templates/rubric-template.yaml` to `rubric.yaml`, complete its assignment, grading and criteria sections, then set the student and submission fields for this evaluation:

```yaml
student:
  id: "2026001"
  name: "Ana Pérez"

submission:
  type: zip
  location: "submissions/2026001.zip"
  submitted_at: null
  commit: null
```

Provide that rubric, the assignment materials and the ZIP, repository or source files to the agent. For example:

```text
Use academic-code-review to evaluate the submission at submissions/2026001.zip using the attached assignment and rubric.yaml. Generate evaluation-report.md and evaluation-result.yaml for student 2026001, Ana Pérez. Include evidence with file paths and line references where available, and report technical limitations. Do not execute the submission unless an approved isolated environment is available.
```

### Configure and evaluate a batch

Use one common `rubric.yaml` with the assignment, grading configuration, performance levels and criteria filled in. Leave its singular `student` and `submission` fields empty. Organize the files with identifiable student IDs, for example:

```text
submissions/
  2026001-Ana-Perez.zip
  2026002-Bruno-Soto.zip
  2026003-Camila-Ruiz.zip
```

Provide the rubric, assignment materials and all submissions, and give the agent an explicit mapping:

```text
Use academic-code-review to evaluate this batch with the attached assignment and rubric.yaml. Validate the rubric once, then evaluate each submission independently using this mapping:
- 2026001, Ana Pérez: submissions/2026001-Ana-Perez.zip
- 2026002, Bruno Soto: submissions/2026002-Bruno-Soto.zip
- 2026003, Camila Ruiz: submissions/2026003-Camila-Ruiz.zip

Generate a separate evaluation-report.md and evaluation-result.yaml for each student. Record that student's ID, name and submission path in the corresponding result. Also generate a course summary with each student's percentage, grade, passing status and limitations. Do not use one student's code as evidence for another. Do not execute submissions unless an approved isolated environment is available.
```

The mapping can be supplied in the prompt or a separate roster file; it is not a list inside the rubric schema. Alternatively, make a copy of the common rubric for each student and change only its `student` and `submission` fields. Keep each student's evidence and reports separate. If no approved isolated environment is available, the skill performs static inspection and reports execution as unverified. The full workflow, including batch handling, is in `references/evaluation-workflow.md`.

### Review and approve an evaluation

Every evaluation starts as `pending_teacher_review`. Review the evidence, criterion scores, grade calculation and limitations before deciding. If you approve it without changes, ask the agent to update both output files:

```text
I reviewed this evaluation and approve it without score changes. Update evaluation-result.yaml and evaluation-report.md to record status `approved`, my name as reviewer, today's date, and this decision. Keep the proposed scores and evidence unchanged, and make sure both files show the same review status.
```

If you change any score, ask the agent to preserve the original assessment, record the criterion, original and revised scores, reason, reviewer and date, and recalculate dependent totals and grade conversion. Keep the Markdown and YAML results synchronized. See `templates/evaluation-result.yaml` and `templates/evaluation-report.md` for the review fields.

## Rubric

A rubric defines weighted criteria, and each criterion contains weighted indicators. Validation rules:

- Criterion weights must sum to 100.
- Indicator weights within each criterion must sum to 100.
- Rubrics may define any number of discrete performance levels. A criterion may use `allowed_performance_levels` to exclude levels that do not apply to that question; if omitted, all shared levels are available.
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

`templates/evaluation-report.md` and `templates/evaluation-result.yaml` provide matching human-readable and machine-readable evaluation records.

## Author

José Miguel Candia - [GitHub](https://github.com/jmcandia) | [LinkedIn](https://linkedin.com/in/jmcandia)

## License

Released under the [MIT License](LICENSE).
