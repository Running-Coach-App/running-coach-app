# QR-05 QRT-01 result

- **Checked:** 2026-11-07
- **Level:** `scripted`
- **Result:** Passes
- **Environment:** Gradle 8.11.1 with JDK 17 on the development machine; no phone, emulator, or staging deployment.

## Run

Ran `gradle :app:testDebugUnitTest --tests '*TelemetryTest.aFailedLineCanBeDiagnosedByIdFromTheStoredTelemetry'`.

The test passed: 1 test, 0 failures, 0 errors, 0 skipped; recorded duration 0.051 seconds. It wrote one synthetic `dropped_unavailable` stats line through `FileTelemetrySink`, selected the record by `line_id`, and verified the expected session, kind, outcome, occurrence time, and delay.

The exact synthetic record was:

```json
{"occurred_at":1700,"session_id":"session-1","source":"smoke","line_id":"line-failed-1","line_kind":"stats","outcome":"dropped_unavailable","latency_ms":2400}
```

This is the scripted fallback declared in [QR-05](../../docs/quality-requirements/qr/QR-05.md). It checks the production file sink and record shape; it is not a deployed staging result.
