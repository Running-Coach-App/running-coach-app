# Decisions

## DEC-001

Target the beginner to intermediate runner in the first release.

- **Status:** Active
- **Date:** 2026-10-02
- **Made by:** Customer
- **Source:** [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions)
- **Why:** the `Customer` does not know what marathon runners' training requires, so the first release serves the runners he can speak for.

## DEC-002

Treat the phone alone as the baseline input, with a wearable optional.

- **Status:** Active
- **Date:** 2026-10-02
- **Made by:** Customer
- **Source:** [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions)
- **Why:** he wants the product to run from whatever the phone already gives — motion sensors, microphone, GPS — and called a watch worth exploring rather than required.

## DEC-003

Do not ask for uploads of health or medical documents.

- **Status:** Active
- **Date:** 2026-10-02
- **Made by:** Customer
- **Source:** [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions)
- **Why:** users will not upload them — they are either too lazy or treat it as a security problem — and the goal is to help people exercise, not to collect data.

## DEC-004

Keep processing on the phone where possible.

- **Status:** Active
- **Date:** 2026-10-02
- **Made by:** Customer
- **Source:** [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions)
- **Why:** he would rather the run were processed on the phone than sent to the cloud, and expects a small model embedded on the device rather than a server.

## DEC-005

Leave social and friend-sharing features out of these ten weeks.

- **Status:** Active
- **Date:** 2026-10-02
- **Made by:** Customer
- **Source:** [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions)
- **Why:** sharing between accounts means connections, security, and sharing and unsharing data, which he judged a project on its own and unreachable in ten weeks; he left it open as a later paid tier.

## DEC-006

Ship the first release on Android, in English.

- **Status:** Active
- **Date:** 2026-10-02
- **Made by:** Customer
- **Source:** [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions)
- **Why:** he has no iOS device and cannot test one, and English is the language the team and he are both comfortable in.

## DEC-007

Drop GAP-01 and GAP-03.

- **Status:** Active
- **Date:** 2026-10-09
- **Made by:** Customer
- **Source:** [the Week 2 validation exchange](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-02/meeting-report.md#decisions)
- **Why:** he judged both gaps not important, and with no adaptive plan wanted there is nothing to explain and no load measure to connect.

## DEC-008

Scope the first release to reading stats aloud and answering simple verbal stats queries, with Gemma as the candidate engine.

- **Status:** Active
- **Date:** 2026-10-09
- **Made by:** Customer
- **Source:** [the Week 2 validation exchange](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-02/meeting-report.md#decisions)
- **Why:** for the scope of the project it is enough to read available stats to the user and to respond to simple verbal queries, with no fixed command list, and he suggested Google's open source small model Gemma to handle those queries and generate the responses.

## DEC-009

Build the minimum usable product as a Kotlin Android app, and speak with the platform voice.

- **Status:** Active
- **Date:** 2026-10-17
- **Made by:** Team
- **Source:** [DEC-006](#dec-006) and [the on-device feasibility verdict](research/on-device-feasibility.md#verdict)
- **Why:** [DEC-006](#dec-006) already ships the first release on Android, because the `Customer` has no iOS device to test. The slice on `main` is Kotlin 2.0.21 with Android Gradle Plugin 8.7.3, Gradle 8.11.1, `minSdk` 26, and `compileSdk` 35. Platform text-to-speech fits the spoken cues and the short stat answers. Gemma stays a candidate until a phone spike measures it, so this release does not depend on it.

## DEC-010

Keep navigation outside the remaining course weeks.

- **Status:** Active
- **Date:** 2026-10-17
- **Made by:** Customer
- **Source:** [the Week 3 validation meeting](../reports/week-03/meeting-report.md#decisions)
- **Why:** changing course mid-run is navigation, and the remaining weeks are too short; the helper should report what already happened.

## DEC-011

Speak a missing stat once, then omit it until it is available again.

- **Status:** Active
- **Date:** 2026-10-17
- **Made by:** Customer
- **Source:** [the Week 3 validation meeting](../reports/week-03/meeting-report.md#decisions)
- **Why:** repeating "not available" every three minutes is annoying; say it once, then only report what the phone has until the missing value returns.

## DEC-012

Answer off-topic questions with a polite focus-on-running reply.

- **Status:** Active
- **Date:** 2026-10-17
- **Made by:** Customer
- **Source:** [the Week 3 validation meeting](../reports/week-03/meeting-report.md#decisions)
- **Why:** the coach must stay on running stats; a short "focus on running, we will talk later" style reply is better than inventing an answer or going silent without guidance.

## DEC-013

Keep a three-minute spoken stats cadence for the MUP.

- **Status:** Active
- **Date:** 2026-10-17
- **Made by:** Customer
- **Source:** [the Week 3 validation meeting](../reports/week-03/meeting-report.md#decisions)
- **Why:** three minutes matches the repository screenshot and is enough for the simple product; a configurable cadence can wait.

## DEC-014

Affirm interval effort cues and silence on steady.

- **Status:** Active
- **Date:** 2026-10-17
- **Made by:** Customer
- **Source:** [the Week 3 validation meeting](../reports/week-03/meeting-report.md#decisions)
- **Why:** with the phone in a pocket he wants spoken jog / harder / easier when effort changes, and no unnecessary effort prompts when effort stays the same; stats may still speak during a steady run.

## DEC-015

Affirm pocket start and stop without motion detection.

- **Status:** Active
- **Date:** 2026-10-17
- **Made by:** Customer
- **Source:** [the Week 3 validation meeting](../reports/week-03/meeting-report.md#decisions)
- **Why:** volume keys for interval and steady are acceptable; motion detection on phones is unreliable. A spoken "start the session" remains welcome later.

## DEC-016

Prefer an on-device model for spoken intent; keywords are the backup.

- **Status:** Active
- **Date:** 2026-10-17
- **Made by:** Customer
- **Source:** [the Week 3 validation meeting](../reports/week-03/meeting-report.md#decisions)
- **Why:** there are too many ways to ask for the same stats for a brittle keyword list alone; try a small on-device model first, and fall back to keywords if that path does not fit.

## DEC-017

Affirm [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) from the Week 4 demonstration.

- **Status:** Active
- **Date:** 2026-10-23
- **Made by:** Customer
- **Source:** [the Week 4 validation meeting](../reports/week-04/meeting-report.md#story-verdicts)
- **Why:** he heard a session start, interval effort cues, and a stop in the shared demo and said the audio part was good; pocket volume-key start and stop were not exercised with him on his own phone in this meeting.

## DEC-018

Affirm [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38) on audio and require the same stats on screen.

- **Status:** Active
- **Date:** 2026-10-23
- **Made by:** Customer
- **Source:** [the Week 4 validation meeting](../reports/week-04/meeting-report.md#story-verdicts)
- **Why:** the spoken time and missing-distance handling in the demo sounded fine for a first usable product, and he wants what the coach says also shown on the phone while he asks and while it answers.

## DEC-019

Affirm [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39) for the first usable product.

- **Status:** Active
- **Date:** 2026-10-23
- **Made by:** Customer
- **Source:** [the Week 4 validation meeting](../reports/week-04/meeting-report.md#story-verdicts)
- **Why:** he heard "Jog." and "Hard." in the demo and treated the coaching audio as acceptable for the first cut.

## DEC-020

Affirm [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) for the first usable product.

- **Status:** Active
- **Date:** 2026-10-23
- **Made by:** Customer
- **Source:** [the Week 4 validation meeting](../reports/week-04/meeting-report.md#story-verdicts)
- **Why:** stat questions and off-topic replies in the demo were good enough to keep using the app; he would like more varied wording when the same stat question is asked twice, but called that a nice-to-have rather than a blocker.

## DEC-021

Install only from a build the `Customer` makes from the repository.

- **Status:** Active
- **Date:** 2026-10-23
- **Made by:** Customer
- **Source:** [the Week 4 validation meeting](../reports/week-04/meeting-report.md#decisions)
- **Why:** he will not install an APK received outside the repository, for example over Telegram, and will clone the repository and build the APK himself so he knows what is on his phone.

## DEC-022

Proceed with on-screen run stats in the next increment.

- **Status:** Active
- **Date:** 2026-10-23
- **Made by:** Customer
- **Source:** [the Week 4 validation meeting](../reports/week-04/meeting-report.md#decisions)
- **Why:** after the demo he told the team to go ahead and show on the phone the data he hears, and rated seeing the stats on screen as more important than polishing phrasing for the first usable product.
