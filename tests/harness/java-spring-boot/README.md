# Isolated checks

Mode: `both`. In a disposable Java 21 environment with dependencies provisioned and network, secrets, and host files disabled, run `mvn -o test` from `submission/`. Expected: application and tests compile; create succeeds; blank-title and unknown-task tests fail because validation and 404 mapping are absent. A failed check is evidence for the corresponding rubric indicators only. Do not expose this harness or `tests/expected/` to the reviewer.
