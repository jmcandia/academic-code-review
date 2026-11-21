# Isolated checks

Mode: `both`. In a disposable Node 22 environment with npm packages provisioned and network, secrets, and host files disabled, run `npm test` from `submission/`. Expected: TypeScript compilation succeeds; latest-query-wins and rejection-state tests fail due to missing request ordering protection and missing catch/finally handling. Do not expose this harness or `tests/expected/` to the reviewer.
