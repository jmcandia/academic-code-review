# Isolated checks

Mode: `both`. In a disposable Python environment with `requirements.txt` dependencies provisioned and network, secrets, and host files disabled, run `python manage.py test` from `submission/`. Expected: test discovery and database setup succeed; valid owner update passes; cross-owner update and negative-stock update tests fail. Do not expose this harness or `tests/expected/` to the reviewer.
