# Isolated checks

Mode: `both`. In a disposable Android SDK/Gradle environment with plugin dependencies provisioned and network, secrets, and host files disabled, run `gradle :app:testDebugUnitTest :app:assembleDebug`. Expected: source compiles; valid-note test passes; blank-note test fails. Inspect `MainActivity.onCreate` statically for the missing draft restoration. Device/emulator lifecycle verification is inconclusive when no Android emulator is available. Do not expose this harness or `tests/expected/` to the reviewer.
