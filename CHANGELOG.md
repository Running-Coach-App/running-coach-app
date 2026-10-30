# Changelog

All notable changes to this project are documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

- A setup screen with live time, pace, and distance, a green start action, and a location warning when GPS is unavailable.
- A coach sheet that pulses while listening, animates while speaking, and reveals words as they are said (FR-010).
- An empty state on History with a prompt and a start action.
- A launcher mark, splash, history of finished runs, a one-run report, and a profile with an optional name, voice speed, and lifetime totals.

### Changed

- The foreground notification shows the same compact stats while a session runs.
- After a stop, the coach speaks a one-line summary of distance and elapsed time (FR-007).
- Questions such as "How am I doing?" return time, pace, and distance; the screen refreshes when you ask.

## [0.2.0] - 2026-10-25

### Added

- A GitHub Actions workflow that runs the Android unit tests and assembles the debug APK on pull requests and on `main`.
- Quality requirements with their priority matrix, functional requirements with their index, a container view, and four architectural decision records, all under `docs/`.
- A project glossary and a root `AGENTS.md` describing the repository's layout, checks, conventions, and off-limits files.

### Changed

- The coach speaks the run's stats every three minutes instead of after fifteen seconds and then every minute.
- An off-topic question gets a reply in the coach's own voice, with its own line for food, weather, work, music, and sleep, instead of one fixed refusal.
- A stat the coach cannot give is named once and then left out until it is available again, instead of being repeated on every line.
- The sprint due dates moved to the Saturdays Assignment 4 sets.

## [0.1.0] - 2026-10-18

### Added

- A pocket session on Android that speaks a start and a stop, the run's time, pace, and distance, an effort word when the effort changes, and an answer to a spoken question about those three stats.
- Setup and run instructions in `docs/setup.md`.
- A GitHub Pages site for `docs/`.
- The Week 3 AI usage report.
- The Android stack decision, DEC-009, and Gradle updates in Dependabot.
