# Changelog

All notable changes to this project are documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

- Tagged releases attach a signed release APK from `.github/workflows/release.yml` when the four release signing secrets are set ([#137](https://github.com/Running-Coach-App/running-coach-app/issues/137)).
- A separate usability-test build that tags local session records with a facilitator-entered participant code, so research sessions can be exported and filtered without identifying runners in the regular app.

### Fixed

- A phone that is not moving no longer accumulates distance. Every fix the location provider produced was trusted and every difference between two of them was added as distance covered, so a phone lying still on a desk recorded 516 m in four and a half minutes and the lock screen showed a pace of 1:38 per kilometre. A fix is now measured with only when it reports an accuracy good enough to support the claim, a step counts only when the phone's own speed does not contradict it and it implies a speed a runner could reach, and a pace faster than any runner holds is not spoken at all: the coach says the pace is not available, in the words it already uses for a stat it does not have. The thresholds and the reason for each are in `ADR-007`.
- The record a session keeps of itself no longer holds values that cannot be true. A session's location-fix tracking carried over from the previous session, so every session after the first recorded a lost fix within milliseconds of starting and then reported more seconds without a fix than the session itself lasted: on one phone a 28-second session claimed 120, which made fix availability read −32.6%. Tracking now starts with the session, so a lost-fix interval always fits inside the session that reports it. A session the product ends is also recorded as such rather than as the runner stopping it, which is the `system` value the analytics document has always described and the product could never produce.
- Turning off `Usage data` no longer stops the app opening. The campus upload shim invoked the uploader with no receiver and threw on every debug launch; the crash handler happened to swallow it while usage data was on, and delegated to the system handler — killing the app — as soon as a runner turned it off. The shim now invokes the uploader correctly and can no longer take the app down, and whether a runner keeps usage data no longer decides whether a crash is fatal.

## [0.5.0](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.5.0) - 2026-11-14

### Added

- Campus deploy scripts under `deploy/`, a `main` workflow that builds and copies the debug APK to the university VM when secrets are set, and optional upload of `events.jsonl` and crash `diagnostics.jsonl` to the VM collector when usage data is on.
- A runner can turn off the record the app keeps of their runs, on the profile screen under Usage data. It is on by default. Turning it off swaps the recording sink for one that does nothing, so no record is written rather than written and filtered out later, and the setting is read again at the start of every session (DEC-030).
- Four quality requirements with tests rather than prose: `QR-06` for stability under a long session, `QR-07` for releasing the location fix when a session ends, `QR-08` for proving that the product as it ships sends nothing, and `QR-09` for whether a runner who has never seen the product can complete a coached session unaided.
- `scripts/scan.sh`, one command that checks every locked dependency against OSV.dev, that the shipped build declares no network permission and references no networking type, and that no credential is committed. A `Security scan` workflow runs it on every push and pull request, and asserts that it fails when a network permission is added, so the check cannot rot into one that always passes.
- The `UT-01` usability test: the record, the tasks and their end states, the help rule, the pre-test and post-test surveys with SUS and SEQ, the consent template, the session instructions, and the results stub, under `docs/usability-tests/ut-01/`.
- A `Docs` workflow that runs `mkdocs build --strict` on every pull request, so a link that leaves the documentation directory fails a check instead of breaking the published site.
- Research on Google Play's Core app quality checklist and Android vitals, and on OSV-Scanner, in `docs/research/play-store-quality.md`.

### Changed

- The run screen is titled Run, the same word as its tab, and the session kind is shown on a line of its own below it rather than as the heading (DEC-024).
- The two session actions read Interval and Steady. The word Start is gone from both, and Stop is unchanged (DEC-025).
- Every metric on the analytics page excludes usability-test traffic as well as smoke traffic, so a test session is never presented as a value of the product's own metrics.
- The documentation says which build cannot send a runner's data anywhere. The release build holds no network permission; the campus upload lives in the debug source set, and the usability build is assembled with no collector URL, so a session's record leaves the phone only over a cable (DEC-031).

### Removed

- The typed question field and its Ask button are gone from the run screen. A single microphone control replaces them: it is on by default, it shows whether the coach is listening, and turning it off stops the coach listening inside the running session rather than at the next one, so a runner can talk to somebody without the app hearing it. The setting is remembered. Asking the coach a question aloud is unchanged (DEC-026, FR-004, FR-005).

### Fixed

- The run screen said the coach was listening while the microphone was switched off. The indicator follows the microphone setting as well as the session, so it reports what the coach is actually doing.

## [0.4.0](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.4.0) - 2026-11-08

### Added

- The app records what the coach did during a run: the session starting, each stats line, each effort cue, each spoken question and its answer, a location fix lost and regained, the session stopping, and the after-run summary. Each record is one line of JSON in the app's own private storage, keyed by a random session identifier, and carries nothing a runner said and nothing that names them (FR-013).
- An analytics plan with one focus metric, weekly completed coached sessions, its counter-metric, its input metrics, and the query for each, plus the event table the recording is written from (`docs/analytics.md`).
- An observability plan with the signals the product emits and two service level indicators, `SLI-01` for spoken line latency and `SLI-02` for continuity through a lost location fix (`docs/observability.md`).
- A diagnosability quality requirement, `QR-05`, with a test that finds a failed spoken line in the recorded telemetry by its line identifier.
- Two architectural decision records, `ADR-005` and `ADR-006`, for keeping both kinds of record on the device, and the two telemetry backends shown on the container view as external systems the product does not reach.

### Changed

- Recording is off unless the app turns it on, and a failure to write a record never interrupts a run.

## [0.3.0](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.3.0) - 2026-10-31

### Added

- A setup screen with live time, pace, and distance, a green start action, and a location warning when GPS is unavailable.
- A coach sheet that pulses while listening, animates while speaking, and reveals words as they are said (FR-010).
- An empty state on History with a prompt and a start action.
- A launcher mark, splash, history of finished runs, a one-run report, and a profile with an optional name, voice speed, and lifetime totals.

### Changed

- The foreground notification shows the same compact stats while a session runs.
- After a stop, the coach speaks a one-line summary of distance and elapsed time (FR-007).
- Questions such as "How am I doing?" return time, pace, and distance; the screen refreshes when you ask.

## [0.2.0](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.2.0) - 2026-10-25

### Added

- A GitHub Actions workflow that runs the Android unit tests and assembles the debug APK on pull requests and on `main`.
- Quality requirements with their priority matrix, functional requirements with their index, a container view, and four architectural decision records, all under `docs/`.
- A project glossary and a root `AGENTS.md` describing the repository's layout, checks, conventions, and off-limits files.

### Changed

- The coach speaks the run's stats every three minutes instead of after fifteen seconds and then every minute.
- An off-topic question gets a reply in the coach's own voice, with its own line for food, weather, work, music, and sleep, instead of one fixed refusal.
- A stat the coach cannot give is named once and then left out until it is available again, instead of being repeated on every line.
- The sprint due dates moved to the Saturdays Assignment 4 sets.

## [0.1.0](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.1.0) - 2026-10-18

### Added

- A pocket session on Android that speaks a start and a stop, the run's time, pace, and distance, an effort word when the effort changes, and an answer to a spoken question about those three stats.
- Setup and run instructions in `docs/setup.md`.
- A GitHub Pages site for `docs/`.
- The Week 3 AI usage report.
- The Android stack decision, DEC-009, and Gradle updates in Dependabot.
