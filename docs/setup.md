# Setup and run

A clean checkout of this repository builds the pocket coach: start a session, hear the time, pace, and distance, hear Jog, Hard, or Easier on an interval session, ask how long the run has been going, and stop.

## Prerequisites

- JDK 17.
- Android SDK 35, from Android Studio or the command-line tools.
- Gradle 8.11.1. The version is the one in [`gradle/wrapper/gradle-wrapper.properties`](https://github.com/Running-Coach-App/running-coach-app/blob/main/gradle/wrapper/gradle-wrapper.properties). The wrapper jar is not in the repository, so use a local Gradle of that version.
- A phone or emulator on API 26 or newer, with an English text-to-speech voice. The app's `minSdk` is 26 and `compileSdk` is 35.

## Install

Clone the repository and change into it.

```text
git clone https://github.com/Running-Coach-App/running-coach-app.git
cd running-coach-app
```

## Configuration

App configuration is [`.env.example`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.env.example). This build has no required keys. Copy it to `.env` only when you add a local override. `.env` is ignored.

The Android SDK path is not an environment variable. Create `local.properties` in the repository root, untracked, with one line:

```text
sdk.dir=C\:\\path\\to\\Android\\Sdk
```

Use the SDK path on your machine. Android Studio writes this file when you open the project.

## Run

From the repository root, with Gradle 8.11.1 on your PATH:

```text
gradle :app:assembleDebug
```

Install `app/build/outputs/apk/debug/app-debug.apk` on the phone or emulator. Open the app and allow location, notifications, and the microphone when asked.

Start an interval session or a steady session from the buttons. The coach says "Session started." Three minutes later it says the elapsed time, the pace, and the distance, and it repeats that line every three minutes. Until there is a GPS fix, the pace and the distance are spoken as not available yet once, and are then left out of the following lines until a fix arrives. An interval session also says "Jog.", then "Hard.", then "Easier.", one minute each. A steady session does not say those words.

Ask "How long have I been running?" aloud, or type that question and press Ask. A question that is not about time, pace, or distance gets "Let us keep the focus on the run. Ask me about your time, your pace, or your distance." Stop the session. The coach says "Session stopped." and does not keep speaking cues.

The volume keys and the headset button are handled while this screen is in front. They are not a covered-screen control yet.

## Checks and tests

Unit tests, from the repository root:

```text
gradle :app:testDebugUnitTest
```

Markdown, from the repository root:

```text
npx markdownlint-cli2 "**/*.md"
```

Links, with [Lychee](https://lychee.cli.rs/) installed:

```text
lychee .
```

The same Markdown check and link check run on pull requests and on `main`.
