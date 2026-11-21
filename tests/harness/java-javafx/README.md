# Isolated checks

Fixture mode: `both`.

1. Static review: inspect `submission/` only; do not expose `tests/expected/` to the reviewer.
2. In a disposable Java 21 environment with Maven dependencies available and no network/secrets/host files, run `mvn -o test` from `submission/`. Expected: compilation succeeds; the add persistence test passes; the delete persistence test fails because the repository mutates memory without writing the DAO.
3. Launch `mvn -o javafx:run` only when a JavaFX-capable isolated display is available. If no display/runtime is available, report launch as inconclusive, not as a code defect.

Never run this fixture from the host during routine skill authoring. Record tool versions, commands, environment, and outputs in the evaluation result when checks are performed.
