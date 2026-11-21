# Evaluation Report

Replace each `{{...}}` token with the corresponding value. Expand repeated sections for each item in the result YAML. Show `null` values as “Not provided” or “Not configured”; omit empty lists and their headings.

> **Proposed assessment — pending teacher review**
> This report is an evidence-based proposal. The teacher retains final grading authority.

## Evaluation record

| Field | Value |
|---|---|
| Assignment | {{assignment.name}} (`{{assignment.id}}`) |
| Course | {{assignment.course}} |
| Student | {{student.name}} |
| Submission | {{submission.location}} |
| Revision | {{submission.revision}} |
| Evaluated on | {{evaluation.date}} |
| Evaluator version | {{evaluation.evaluator_version}} |
| Rubric version | {{rubric.schema_version}} |
| Review status | `{{evaluation.status}}` |

## Result

| Measure | Result |
|---|---:|
| Weighted percentage | {{grading.percentage}}% |
| Institutional grade | {{grading.grade}} |
| Passing threshold | {{grading.passing_threshold_percentage}}% |
| Passing status | {{grading.passed}} |

Calculation: {{grading.calculation}}

## Project profile

- **Detected technologies:** {{project.technologies}}
- **Selected profiles:** {{project.selected_profiles}}
- **Project structure:** {{project.structure_summary}}
- **Detection evidence:** {{project.detection_evidence}}

## Criterion results

{{#each grading.criteria}}
### {{id}} — {{name}} (weight: {{weight}}%)

**Score:** {{score}} / {{max_score}} · **Weighted contribution:** {{contribution}} points

{{description}}

| Indicator | Level | Result | Evidence status | Rationale |
|---|---|---:|---|---|
{{#each indicators}}
| {{id}} — {{description}} | {{performance_level}} | {{score}} / {{max_score}} | {{verification_status}} | {{justification}} |
{{/each}}
{{/each}}

## Findings

{{#each findings}}
### {{severity}} — {{title}} (`{{id}}`)

{{description}}

- **Criterion / indicator:** {{criterion_id}} / {{indicator_id}}
- **Expected:** {{expected_behavior}}
- **Observed:** {{observed_behavior}}
- **Scoring impact:** {{scoring_impact}}
- **Recommendation:** {{recommendation}}
- **Evidence references:** {{evidence_refs}}
{{/each}}

## Evidence

{{#each evidence}}
- **{{id}} ({{type}}):** `{{file}}` (lines {{line_start}}–{{line_end}}; symbol: {{symbol}}). {{description}} Relevance: {{relevance}}
{{/each}}

## Technical verification

| Check | Environment / command | Status | Result |
|---|---|---|---|
{{#each technical_checks}}
| {{name}} | {{environment_and_command}} | {{status}} | {{summary}} |
{{/each}}

### Limitations

{{#each technical_limitations}}
- {{this}}
{{/each}}

## Observations and recommendations

{{#each observations}}
- {{this}}
{{/each}}

{{#each recommendations}}
- {{this}}
{{/each}}

## Unverifiable items

{{#each unverifiable_items}}
- **{{criterion_id}} / {{indicator_id}}:** {{reason}} (impact on result: {{scoring_impact}})
{{/each}}

## Teacher review

- **Status:** `{{teacher_review.status}}`
- **Decision:** {{teacher_review.decision}}
- **Reviewer:** {{teacher_review.reviewer}}
- **Date:** {{teacher_review.date}}
- **Comments:** {{teacher_review.comments}}

Any teacher adjustment must record the original score, revised score, reason, authorizing teacher and date. Recalculate dependent totals and preserve this proposed assessment.
