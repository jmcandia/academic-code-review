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

For each evaluation, provide the assignment instructions, a YAML rubric, the student submission (Git repository, ZIP archive or source files) and the grading configuration (scale, conversion points, passing threshold and rounding). Start a conversation with the agent where the skill is installed and ask it to use `academic-code-review`.

### Evaluate one submission

Attach the assignment, rubric and one submission, then use a prompt such as:

```text
Use academic-code-review to evaluate this submission against the attached assignment and rubric. Apply the attached grading configuration. Generate an evaluation-report.md and evaluation-result.yaml. Include evidence with file paths and line references where available, and report any technical limitations. Do not execute the submission unless an approved isolated environment is available.
```

### Evaluate multiple submissions with one rubric

Provide the assignment, rubric and grading configuration once, and organize submissions into clearly identified folders, for example:

```text
submissions/
  student-001/
  student-002/
  student-003/
```

Then ask for a batch evaluation:

```text
Use academic-code-review to evaluate every submission in the attached submissions folder against the same assignment, rubric and grading configuration. Validate the rubric once, then assess each submission independently. Generate evaluation-report.md and evaluation-result.yaml for each student, plus a course summary with each student identifier, percentage, grade, passing status and limitations. Do not use one student's code as evidence for another student's evaluation. Do not execute submissions unless an approved isolated environment is available.
```

Keep each student's evidence and reports separate. If no approved isolated environment is available, the skill performs static inspection and reports execution as unverified. The full workflow, including batch handling, is in `references/evaluation-workflow.md`.

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
