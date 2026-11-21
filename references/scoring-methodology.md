
# Scoring Methodology

## 1. Purpose

Define a deterministic, transparent and reproducible methodology
for scoring student programming assignments.

All scoring decisions must be traceable to the rubric
and supported by evidence.

## 2. Evaluation hierarchy

The scoring model follows this hierarchy:

Assignment
  -> Criteria
      -> Indicators
          -> Evidence
          -> Indicator score
      -> Criterion score
  -> Final weighted percentage
  -> Institutional grade

Each level must preserve the contribution of the previous level.

## 3. Indicator scoring

Each indicator receives a score between zero and its maximum.

The evaluator must consider:

- Requirements satisfied.
- Requirements partially satisfied.
- Requirements not satisfied.
- Evidence availability.
- Technical limitations.

Scores must not exceed the configured maximum.

When a rubric defines discrete performance levels, select the level whose
descriptor best matches the evidence and award its configured percentage
of the indicator maximum. Do not create intermediate levels unless the
rubric authorizes them. Record the selected level and descriptor.

If the criterion defines `allowed_performance_levels`, restrict selection
to those IDs. Do not select a globally defined level that the criterion
excludes. If the field is absent, use all levels in `performance_levels`.
Never infer an omitted level from the gap between two available scores.

### 3.1 Evidence-based scoring

For each indicator, record:

- Indicator identifier.
- Expected behavior.
- Observed implementation.
- Evidence references.
- Verification status.
- Selected performance level and descriptor when the rubric defines discrete levels.
- Awarded score.
- Maximum score.
- Justification.

An indicator must not receive full credit solely because
the relevant file or class exists.

The implementation must demonstrate the expected behavior.

## 4. Indicator aggregation

Indicator weights within each criterion must sum to 100.

For fully verifiable indicators:

indicator_contribution =
  (indicator_score / indicator_max_score)
  * indicator_weight

criterion_ratio =
  SUM(indicator_contribution) / 100

criterion_score =
  criterion_ratio * criterion_max_score

Criterion contribution to final percentage:

criterion_contribution =
  criterion_ratio * criterion_weight

## 5. Missing evidence

Missing evidence must be handled according to the rubric policy.

### 5.1 Proportional policy

When some indicators cannot be verified:

- Calculate the criterion using verifiable indicators.
- Normalize their weights against the total weight of verifiable indicators.
- Report the weight of unverifiable indicators.
- Clearly identify the resulting uncertainty.

Example:

Criterion weight: 20.

Indicator weights:

- I01: 50%, score 10/10.
- I02: 30%, score 5/10.
- I03: 20%, not verifiable.

Verifiable weight = 80%.

Normalized criterion ratio:

((50 * 1.0) + (30 * 0.5)) / 80
= 0.8125

Criterion contribution:

0.8125 * 20
= 16.25 points.

The report must explicitly indicate that 20% of the criterion
could not be verified.

### 5.2 None policy

Indicators without evidence receive no points.

Their contribution is zero.

However, the evaluator must distinguish between:

- Verified absence of implementation.
- Insufficient evidence.
- Technical inability to inspect.

If the criterion cannot be fairly evaluated,
request teacher intervention instead of treating the result
as a definitive score.

## 6. Criterion aggregation

Each criterion has an independent weight.

Criterion contribution:

criterion_contribution =
  (criterion_score / criterion_max_score)
  * criterion_weight

Final percentage:

final_percentage =
  SUM(criterion_contribution)

The result must be between zero and 100.

## 7. Grade conversion

Convert the final percentage into the institutional scale.

Use the conversion table defined in the rubric.

For consecutive points A and B:

grade =
  grade_A +
  ((percentage - percentage_A) /
   (percentage_B - percentage_A))
  * (grade_B - grade_A)

Use piecewise linear interpolation.

Values outside the configured percentage range must be rejected.

Never assume a universal institutional grading scale.

## 8. Rounding

Rounding must follow the configured policy.

Supported modes:

- half_up
- half_even
- floor
- ceiling

Avoid binary floating-point artifacts when performing
grade calculations.

Use decimal arithmetic where possible.

The report must retain sufficient precision
to reproduce the final result.

## 9. Passing determination

Passing is determined by comparing the configured
minimum percentage with the final percentage.

passed =
  final_percentage >= minimum_percentage

The comparison must use the unrounded percentage.

The displayed grade does not override this rule.

## 10. Consistency and fairness

Apply the following controls:

### 10.1 No duplicate penalties

A single defect must not reduce multiple criteria
unless the rubric explicitly evaluates independent consequences.

Example:

A missing validation must not automatically reduce
both validation and code quality scores.

### 10.2 No unsupported deductions

Every deduction must have an explicit justification.

### 10.3 No implicit requirements

Do not penalize features that were not requested
or established by the rubric.

### 10.4 Consistent expectations

Equivalent implementations must receive equivalent scores,
regardless of coding style preferences.

### 10.5 Partial credit

Award partial credit when the implementation satisfies
some verifiable requirements.

Do not force binary pass/fail decisions when the rubric
allows graduated scoring.

## 11. Technical execution results

Compilation and test results provide evidence,
but they do not automatically determine academic scores.

Distinguish:

- Compilation success.
- Test execution success.
- Test coverage.
- Runtime behavior.
- Static analysis findings.

A successful compilation does not prove functional correctness.

A failed build does not automatically imply zero points
for unrelated criteria.

Report environmental failures separately from student defects.

## 12. Confidence and limitations

Confidence is descriptive, not an additional grading multiplier.

Suggested confidence levels:

- high: sufficient direct evidence.
- medium: partial evidence or limited execution.
- low: substantial uncertainty.

Do not multiply the academic score by confidence.

Report unverifiable indicators and their influence
on the final result.

If uncertainty materially affects fairness,
request teacher review before presenting a definitive result.

## 13. Reproducibility

Every evaluation must retain:

- Rubric version.
- Assignment identifier.
- Evaluated submission revision.
- Evaluator version.
- Evaluation date.
- Criterion scores.
- Evidence references.
- Calculation results.
- Manual adjustments.

Manual adjustments must record:

- Original score.
- New score.
- Reason.
- Teacher authorization.

## 14. Final report

Every report must include:

1. Final weighted percentage.
2. Institutional grade, if configured.
3. Passing threshold.
4. Passing status.
5. Criterion breakdown.
6. Indicator breakdown when available.
7. Evidence and justifications.
8. Unverifiable indicators.
9. Technical execution results.
10. Evaluation limitations.
11. Teacher validation status.

The evaluation must remain in
pending_teacher_review until approved by the teacher.
