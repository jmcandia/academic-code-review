
# Evidence Guidelines

## 1. Purpose

Define the standards for collecting, validating and presenting
evidence during academic code evaluation.

Evidence must support every relevant scoring decision.

## 2. Evidence principles

All evidence must be:

- Relevant to the evaluation criterion.
- Traceable to the submitted project.
- Reproducible whenever possible.
- Sufficient to justify the assigned score.
- Presented without modifying the original submission.

Never invent evidence or assume an implementation exists.

## 3. Evidence sources

Supported evidence sources include:

### 3.1 Source code

- Classes and methods.
- Functions.
- Interfaces.
- Models and entities.
- Controllers and services.
- Configuration files.
- Database definitions.
- Application resources.

### 3.2 Project structure

- Directory organization.
- Module separation.
- Dependency configuration.
- Build configuration.
- Application entry points.

### 3.3 Automated verification

- Unit test results.
- Integration test results.
- Compilation output.
- Static analysis.
- Dependency validation.

### 3.4 Documentation

- README files.
- API documentation.
- Installation instructions.
- Architecture documentation.

Documentation alone does not prove that the described
functionality has been implemented.

## 4. Evidence references

Whenever possible, reference exact file locations.

Recommended format:

```yaml
evidence:
  - type: "source_code"
    file: "src/repositories/student.py"
    line_start: 15
    line_end: 38
    description: "Implements student persistence operations."
    relevance: "Supports criterion C02."
```

If line numbers cannot be determined, reference the file
and relevant symbol.

Never fabricate line numbers.

## 5. Evidence quality

Use the following classification:

### Direct evidence

The implementation explicitly demonstrates the requirement.

### Supporting evidence

The implementation provides indirect support.

### Negative evidence

A required implementation is demonstrably absent
or incorrect within the inspected scope.

### Inconclusive evidence

Available information is insufficient to reach a reliable conclusion.

## 6. Evidence and scoring

A scoring decision must be supported by evidence
proportional to the importance of the criterion.

Full scores require sufficient evidence of full compliance.

Partial scores require explicit identification of
implemented and missing requirements.

Zero scores require verified non-compliance,
not merely the inability to inspect.

## 7. Evidence integrity

Preserve the original student submission.

Do not:

- Modify source files.
- Repair student implementations.
- Generate missing code and treat it as original.
- Replace dependencies without documenting the change.
- Attribute generated test results to the student's implementation
  without identifying the test environment.

Record the evaluated revision whenever available.

## 8. Duplicate evidence and penalties

The same defect may be referenced by multiple criteria
only when it has independently relevant consequences.

Do not automatically apply multiple deductions
for a single underlying defect.

## 9. Test evidence

When automated tests are executed, record:

- Test identifier.
- Test command.
- Execution environment.
- Execution status.
- Relevant output.
- Limitations.

Distinguish test failure from test infrastructure failure.

A missing test suite does not automatically prove
that the implementation is incorrect.

## 10. Evidence reporting

Every significant finding should contain:

- Criterion identifier.
- Evidence classification.
- File and line references.
- Description of the finding.
- Expected behavior.
- Observed behavior.
- Scoring impact.
- Recommended correction.

## 11. Insufficient evidence

When evidence is insufficient:

1. Explain what could not be verified.
2. Identify the missing information.
3. Avoid unsupported conclusions.
4. Apply the configured missing evidence policy.
5. Escalate to teacher review when fairness is affected.

## 12. Final verification

Before generating the report, verify:

- Every reference points to an existing file.
- Line numbers are within the file boundaries.
- Evidence corresponds to the evaluated submission.
- Findings support their associated scoring decisions.
- No fabricated execution results exist.
