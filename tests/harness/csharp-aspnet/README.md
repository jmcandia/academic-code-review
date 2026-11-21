# Isolated checks

Mode: `both`. In a disposable .NET 8 environment with NuGet packages provisioned and network, secrets, and host files disabled, run `dotnet test` from `submission/Api.Tests/`. Expected: compilation succeeds; valid enrollment passes; the missing-course test fails because the endpoint returns 200 rather than 400. Static inspection should separately flag `.Result` on the asynchronous service operation. Do not expose this harness or `tests/expected/` to the reviewer.
