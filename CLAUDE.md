# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this repository is

A Claude Agent Skill (`academic-code-review`) that grades student programming projects against teacher-provided weighted rubrics. It contains no executable code: only Markdown instructions and a YAML template. There is no build, lint or test tooling. "Developing" here means editing the skill's instruction documents and keeping them mutually consistent.

`README.md` is the human-facing overview; keep it in sync when profiles, inputs or report formats change. `SKILL.md` is the entry point. Its YAML frontmatter (`name`, `description`) is what the skill loader reads to decide when to trigger the skill, so changes to `description` alter activation behavior.

## Architecture

Progressive disclosure: `SKILL.md` is a short dispatcher holding the non-negotiable rules. It tells the agent which reference to load at each stage instead of inlining detail.

- `references/evaluation-workflow.md`: the 8 mandatory stages (input collection, assignment analysis, rubric validation, project inspection, technical verification, academic scoring, report generation, teacher review), plus technology-detection indicators, reevaluation, batch mode and failure handling.
- `references/rubric-schema.md`: the rubric contract. Field names and semantics here must match `templates/rubric-template.yaml`.
- `references/scoring-methodology.md`: the formulas (indicator, criterion, final percentage), the `proportional`/`none` missing-evidence policies, piecewise-linear grade conversion, rounding modes (`half_up`, `half_even`, `floor`, `ceiling`) and passing determination.
- `references/evidence-guidelines.md`: evidence statuses (`verified`, `partially_verified`, `not_found`, `not_verifiable`) and how evidence feeds scores.
- `references/security-guidelines.md`: student submissions are untrusted; covers prompt-injection resistance, archive and repo inspection, execution isolation and secret handling.
- `references/technology/*.md`: one inspection profile per stack (Python/Django, C#/ASP.NET, Java/JavaFX, Java/Spring Boot, JavaScript/TypeScript, Kotlin/Android). Profiles all share the same skeleton (Purpose, Project identification, topic sections, Security considerations, Evidence requirements, Final evaluation). They give inspection guidance only and must never add scoring criteria: the rubric stays authoritative.

## Cross-file invariants to preserve when editing

- The technology profile table is duplicated in `SKILL.md` §2 and `references/evaluation-workflow.md` §6.2. Detection indicators live in `evaluation-workflow.md` §6.1. Adding or renaming a profile means updating all three plus the frontmatter `description`.
- JavaFX and Spring Boot are deliberately separate profiles. Keep them independent.
- Rubric fields used in `rubric-schema.md`, `scoring-methodology.md` and `templates/rubric-template.yaml` (e.g. `missing_evidence_policy`, `rounding_stage`, `grading.scale.conversion`, `grading.passing.minimum_percentage`) must stay in sync. Breaking schema changes require bumping `schema_version` (see `rubric-schema.md` §10).
- Core rules repeated across files: criterion and indicator weights each sum to 100; never silently fix an invalid rubric; passing uses the unrounded percentage; confidence is never a score multiplier; every evaluation starts as `pending_teacher_review`.

## Known gaps

`SKILL.md` §11 references `templates/evaluation-report.md` and `templates/evaluation-result.yaml`, which do not exist yet. Only `templates/rubric-template.yaml` is present.

## Language

Skill documents are written in English. The rubric template uses Spanish placeholder values (e.g. `"Nombre de la actividad"`) and a Chilean-style 1.0–7.0 scale with 4.0 passing. That scale is only an example: the skill must not assume any universal grading scale.
