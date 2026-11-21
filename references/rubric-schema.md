
# Rubric Schema

## 1. Purpose

Define the canonical structure of academic evaluation rubrics
used by Academic Code Review.

All agents must interpret rubric files consistently,
regardless of programming language, framework or execution environment.

The canonical configuration format is YAML.

## 2. Schema version

Every rubric must declare:

```yaml
schema_version: "1.0"
```

Unsupported schema versions must be rejected until explicitly supported.

## 3. Assignment

The assignment section identifies the academic activity.

Required fields:

- id: Unique assignment identifier.
- name: Activity name.
- description: Activity instructions.

Optional fields:

- course
- academic_level
- language
- framework
- due_date

The assignment must provide sufficient information
to understand what the student is expected to implement.

## 4. Grading configuration

The grading section defines the scoring rules.

### 4.1 Total weight

```yaml
grading:
  total_weight: 100
```

The sum of all criterion weights must equal total_weight.

Weights must be positive numeric values.

### 4.2 Maximum criterion score

Each criterion defines its own maximum score.

```yaml
max_score: 10
```

The maximum score must be greater than zero.

### 4.2.1 Discrete performance levels

Rubrics may define a shared set of discrete performance levels when each
criterion uses the same descriptive scale. Store the exact awarded score
for each level; do not interpolate between levels unless the rubric
explicitly allows it.

```yaml
performance_levels:
  - id: "excellent"
    percentage: 100
    label: "Muy buen desempeño"
    description: "Complete implementation and stable behavior."
  - id: "good"
    percentage: 80
    label: "Buen desempeño"
    description: "Minor omissions without affecting the main flow."
```

When present, each criterion may provide a descriptor override for any
level. The score for a criterion is the selected level percentage times
its maximum score. The final percentage remains the weighted sum of the
criterion ratios. Validate that level identifiers are unique and level
percentages are between 0 and 100. Preserve the rubric's order and labels.
Criterion-specific overrides use `performance_level_overrides`, keyed by
the shared level identifier.

### 4.3 Grading scale

```yaml
scale:
  name: "Institutional Scale"
  minimum: 1.0
  maximum: 7.0
  passing_grade: 4.0
  decimal_places: 1
  rounding: "half_up"
```

Rules:

- minimum must be lower than maximum.
- passing_grade must be within the configured scale.
- decimal_places must be a non-negative integer.
- rounding must use a supported rounding mode.

Supported rounding modes:

- half_up
- half_even
- floor
- ceiling

### 4.4 Percentage conversion

The conversion table defines how the final percentage
is translated into an institutional grade.

```yaml
conversion:
  - percentage: 0
    grade: 1.0
  - percentage: 60
    grade: 4.0
  - percentage: 100
    grade: 7.0
```

Validation requirements:

1. The first percentage must be 0.
2. The last percentage must be 100.
3. Percentages must be strictly increasing.
4. Grades must be non-decreasing.
5. All grades must remain within the configured scale.
6. Every segment must support deterministic interpolation.

Conversion between points is piecewise linear.

For two consecutive points:

grade =
  grade_a +
  ((percentage - percentage_a) /
   (percentage_b - percentage_a)) *
  (grade_b - grade_a)

The final grade is rounded according to the configured rounding mode.

### 4.5 Passing threshold

```yaml
passing:
  minimum_percentage: 60
```

The threshold is independent of the institutional grade conversion.

A student passes when the unrounded final percentage
is greater than or equal to minimum_percentage.

Do not infer approval solely from a rounded displayed grade.

### 4.6 Missing evidence policy

Supported policies:

- proportional
- none

`proportional`:

Evaluate only the verifiable indicators and calculate their contribution
proportionally within the criterion.

The unverifiable portion must be reported separately.

`none`:

Do not award points for indicators without verifiable evidence.

This policy must not be used to convert an inspection limitation
into an automatic finding of non-compliance.

### 4.7 Rounding stage

Supported values:

- score
- grade

`score` means round the final percentage before grade conversion.

`grade` means convert the unrounded percentage and round only
the resulting grade.

The selected method must be consistent across the entire evaluation.

## 5. Criteria

Each criterion must include:

- id
- name
- description
- weight
- max_score
- indicators

An indicator may also be represented as a criterion with one indicator
when the source rubric assigns a direct overall weight to each indicator.
In that case, retain the indicator's original identifier and description;
use a single nested indicator at 100% so the canonical weight arithmetic
remains valid. Do not invent category weights.

Example:

```yaml
criteria:
  - id: "C01"
    name: "Data modeling"
    description: "Correct implementation of data models."
    weight: 25
    max_score: 10
    indicators:
      - id: "I01"
        description: "Defines the required entities."
        weight: 60
      - id: "I02"
        description: "Establishes correct relationships."
        weight: 40
    evidence_required: true
```

Criterion identifiers must be unique.

Indicator identifiers must also be unique within the rubric.

Criterion weights must sum to total_weight.

Indicator weights within each criterion must sum to 100.

Indicator weights represent the relative contribution
to their criterion.

## 6. Student information

Student metadata is optional.

```yaml
student:
  id: null
  name: null
  email: null
```

Never infer student identity from unrelated information.

## 7. Submission information

```yaml
submission:
  type: "zip"
  location: ""
  submitted_at: null
  commit: null
```

Supported submission types:

- git
- zip
- files

The location must identify the supplied project or files.

For Git submissions, commit identifies the evaluated revision
when available.

## 8. Evaluation metadata

```yaml
evaluation:
  status: "pending"
  evaluator_version: "1.0"
  include_line_references: true
  include_recommendations: true
  teacher_validation_required: true
```

Evaluation status must distinguish:

- pending
- in_progress
- completed
- pending_teacher_review
- approved
- rejected

## 9. Validation rules

Before evaluation:

1. Validate the schema version.
2. Validate required assignment fields.
3. Validate grading configuration.
4. Validate conversion points.
5. Validate criterion identifiers.
6. Validate criterion weights.
7. Validate indicator weights.
8. Validate score ranges.
9. Validate submission type.
10. When discrete performance levels are present, validate unique level IDs,
    percentages within 0–100, and every criterion override references a defined level.

An invalid rubric must not be silently corrected.

Report all validation errors and request teacher clarification
when necessary.

## 10. Backward compatibility

Schema changes must preserve existing rubric interpretation
whenever possible.

Breaking changes require a new schema version.

Agents must not reinterpret historical evaluations using
a different schema without explicit migration.

## 11. Source of truth

The rubric is the authoritative source for:

- Evaluation criteria.
- Criterion weights.
- Maximum scores.
- Grading scale.
- Passing threshold.
- Conversion rules.

The agent must not introduce additional grading criteria
without explicit teacher authorization.
