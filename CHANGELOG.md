# Changelog

All notable changes to this project are documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

- A runner can turn off the record the app keeps of their runs, on the profile screen under Usage data. It is on by default. Turning it off swaps the recording sink for one that does nothing, so no record is written rather than written and filtered out later, and the setting is read again at the start of every session (DEC-030).

### Changed

- The run screen is titled Run, the same word as its tab, and the session kind is shown on a line of its own below it rather than as the heading (DEC-024).
- The two session actions read Interval and Steady. The word Start is gone from both, and Stop is unchanged (DEC-025).

### Removed

- The typed question field and its Ask button are gone from the run screen. A single microphone control replaces them: it is on by default, it shows whether the coach is listening, and turning it off stops the coach listening inside the running session rather than at the next one, so a runner can talk to somebody without the app hearing it. The setting is remembered. Asking the coach a question aloud is unchanged (DEC-026, FR-004, FR-005).

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
