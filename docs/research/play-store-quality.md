# Play Store Quality And Publishing

The `Customer` asked for this twice. In [the Week 5 meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-05/meeting-transcript.md) he said to "open the Google Play requirements for publishing", to take "the top things, as many as fit this course", not to "invent wheels", and to add "some kind of automated scanner in the repository that checks for vulnerabilities, security problems, and package dependencies", which he called "a quality requirement from me". In [the Week 6 meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-06/meeting-transcript.md) he asked whether the team had "researched what Google requires from an application to be considered high quality". This page is that research.

Sources were read on 2026-11-13. Each is linked under [Sources](#sources).

## Verdict

Google's own baseline is one page, [Core app quality](https://developer.android.com/docs/quality-guidelines/core-app-quality) ([archived 2026-11-10; read 2026-11-13](https://web.archive.org/web/20261110195135/https://developer.android.com/docs/quality-guidelines/core-app-quality)). It describes itself as "the minimum quality that all apps should meet", and it is a checklist of named criteria, not a gate: nothing on the page says that meeting it is a precondition for publishing. What does carry a mechanical consequence is [Android vitals](https://developer.android.com/topic/performance/vitals) ([archived 2026-09-16; read 2026-11-13](https://web.archive.org/web/20260916013235/https://developer.android.com/topic/performance/vitals)), where two numbers decide whether Play keeps showing the app. That is the part worth turning into quality requirements, and it is the part that matches what the `Customer` meant by "Play Store will punish an app that takes a lot of CPU or battery".

Three of Google's criteria are the ones that fit the sprints that are left, and each becomes a requirement rather than a note:

- **Stability** is the only criterion with a published number attached. `Stability_ANR` says the app must not crash or block the UI thread, and Android vitals puts a threshold under it: exceeding **1.09%** user-perceived crash rate or **0.47%** user-perceived ANR rate across devices makes the app "likely to be less discoverable on Google Play". This is [`QR-06`](../quality-requirements/qr/QR-06.md).
- **Background work** is where this product is most exposed. `Background_Service_Optimization` names, as a poor use of a background service, "keeping GPS powered on" — which is exactly what a coached session does. The requirement is therefore not "do not keep GPS on" but "do not keep it on when no session is running". This is [`QR-07`](../quality-requirements/qr/QR-07.md).
- **Security and privacy** is the `Customer`'s own addition, and the one he returned to: "proof, for open source, that you are not sending data somewhere. People know the scanner: they can run it and see." This is [`QR-08`](../quality-requirements/qr/QR-08.md), tested by `scripts/scan.sh`.

Two findings are worth more than the requirements they did not become. The product's foreground notification does **not** use `MediaStyle`, which `Audio_Notification_Style` requires of an app that plays audio in the background, so the product fails a criterion today. And the product requests both `ACCESS_FINE_LOCATION` and `ACCESS_COARSE_LOCATION` while `Minimize_Permissions` asks for coarse "where possible"; the fine permission is justified here, but the pairing should be a deliberate decision rather than a default.

The rest of the page is out of scope for an app of this shape, and saying so is part of the research: there is no sign-in, so the identity criteria do not apply; no `WebView`, so the WebView criteria do not apply; no video; no network traffic at all, so the three networking criteria are satisfied by absence rather than by configuration. Scoping it this way is what the `Customer` asked for when he said "limit the scope" and "the most important 80 percent".

## What Google Actually Publishes

Google's quality material splits into two kinds, and conflating them is the usual mistake.

**The checklist.** [Core app quality](https://developer.android.com/docs/quality-guidelines/core-app-quality) ([archived 2026-11-10; read 2026-11-13](https://web.archive.org/web/20261110195135/https://developer.android.com/docs/quality-guidelines/core-app-quality)) lists criteria under five headings: User experience, Functionality, Performance and stability, Privacy and security, and Google Play. Each criterion has an identifier in snake case, such as `Target_SDK_Version`, and a matching test row prefixed `T-`. The page calls the set "the minimum quality that all apps should meet" and offers it as something to test against. It is advisory in tone — items are worded with "must", "should", and plain statements mixed together — and it does not claim to gate publication. Three items do state a Play rule inside their own text: adherence to the Developer Content Policy, the ban on notifications used for cross-promotion, which it calls "strictly prohibited by the Play Store", and Android App Bundles, which it says have been "mandatory for all new apps in the Google Play Store" since August 2021.

**The thresholds.** [Android vitals](https://developer.android.com/topic/performance/vitals) ([archived 2026-09-16; read 2026-11-13](https://web.archive.org/web/20260916013235/https://developer.android.com/topic/performance/vitals)) is the part with teeth. Google names a set of "core vitals" and publishes a bad behaviour threshold for each. Two apply to every app:

| Metric | Overall, across devices | Per phone model |
| --- | --- | --- |
| User-perceived crash rate | 1.09% | 8% |
| User-perceived ANR rate | 0.47% | 8% |

A user-perceived crash is, in Google's words, "a crash that is likely to have been noticed by the user", and the rate is "the percentage of your daily users who experienced at least one user-perceived crash". For ANRs, "currently, only 'input dispatching timed out' ANRs are counted". Play "uses the last 28 days of data to assess your app's quality", and if an app exceeds a threshold Play "may reduce the visibility of your title" and "may also show users a warning on your store listing".

This is the concrete form of what the `Customer` described. He said Google "collects metrics anyway, and if it crashes a lot on some phones they will hide it from Google Play for those phones" — which is the per-phone-model 8% threshold, almost exactly.

## Findings

- **The baseline is a checklist, not a gate.** Nothing in Core app quality says an app is rejected for missing an item. The enforcement that exists is the vitals thresholds, which act on an app that is already published and is already being used by enough people to produce a rate. For a product that nobody outside the team has installed, no vitals number exists yet, and none will until [`TOS-02`](../threshold-of-success.md#tos-02) is met. The requirements this page produces are therefore written against behaviour the team can test on one phone, not against a store metric the team cannot yet read.

- **Background services are the criterion this product is closest to failing.** `Background_Service_Optimization` reads: "App avoids running unnecessarily long services in the background to ensure the smooth running of the user's device." Its examples of poor use name maintaining a network connection for notifications, maintaining a Bluetooth connection, and keeping GPS powered on. A coached session keeps GPS powered on for its whole duration, which is the product working as designed — a running coach that does not know where the runner is cannot speak pace or distance. The defensible line is that GPS runs while a session runs and not otherwise, which is what the code does: `stopSession()` and `onDestroy()` both call `removeUpdates`. That is a property worth locking down with a test, because it is one careless early return away from a service that drains a battery all day.

- **The `Customer` was right that battery is policed, but not through this criterion.** Play's battery vital is excessive partial wake locks, which Google lists as a core vital in beta where "exceeding the bad behavior threshold does not currently make your app less discoverable". So the battery pressure he described is real but currently soft. The hard thresholds today are crashes and ANRs.

- **Audio background playback has a requirement the product does not meet.** `Audio_Playback_Background` requires a foreground service and "a persistent, non-dismissible notification in the status bar or on the lock screen", which the product has. `Audio_Notification_Style` then requires that "app must create a notification styled with `MediaStyle`". The product builds its notification with `NotificationCompat.Builder(...).setOngoing(true)` and no `MediaStyle`, although `CoachService` already holds a `MediaSession` that would supply the token. This is a real gap, small to close, and it is the clearest example of why reading the actual criteria beats guessing at them. It is filed as [issue #197](https://github.com/Running-Coach-App/running-coach-app/issues/197) rather than turned into a quality requirement, because it is one specific defect, not a property to hold.

- **Audio focus is already handled by the platform for this product.** `Audio_Focus_Request` says the app "should request audio focus when audio starts playing and abandon audio focus when playback stops", and its test notes this "happens automatically for apps that target Android 12 (API level 31) and higher". The product targets 35, so the criterion is met by the platform. `Audio_Focus_Change`, handling another app's request, is the half that is not automatic.

- **The permission set is nearly minimal, with one pairing to justify.** `Minimize_Permissions` asks the app to request "only the minimum permissions" and to use "coarse location where possible". The product declares both fine and coarse location. Fine is the right choice for pace over short distances, where coarse location's error is larger than the distance covered between two stats lines, but the two are declared together and nothing in the repository says why. `Runtime_Permissions` and `Permission_Rationale` are met: the app asks when the feature is used rather than at startup. `Graceful_Degradation` is met and is already the subject of [`QR-04`](../quality-requirements/qr/QR-04.md), which keeps a session speaking when the fix is lost.

- **The networking criteria are satisfied by absence.** `Network_Security_Traffic`, `Network_Security_Configuration`, and `Security_Provider_Initialization` all concern an app that makes network calls. This product declares no network permission at all, which is a stronger position than any configuration: there is no traffic to secure. [`ADR-005`](../architecture/adr/ADR-005.md) and [`ADR-006`](../architecture/adr/ADR-006.md) record that decision for telemetry, and it is what [`QR-08`](../quality-requirements/qr/QR-08.md) now holds in place.

- **The SDK criteria are met and are a standing obligation, not a one-off.** `Target_SDK_Version` and `Compile_SDK_Version` ask for the latest SDK, and the page names no specific API level; the product sets `targetSdk` and `compileSdk` to 35. `SDK_Maintenance` asks that dependencies be kept current and states that the developer is "accountable for the entire app codebase, inclusive of any third-party SDKs used" — which is the clause the dependency half of the scanner answers.

- **The product ships no dependency with a known vulnerability, and its build pulls in nine packages that do.** Running the scan against all 149 locked dependencies, nothing on `releaseRuntimeClasspath` — the set that ends up inside the APK — has an advisory. Nine packages do: `io.netty` (seven artifacts), `com.google.guava`, `com.google.protobuf`, and `commons-io`. Every one of them appears only in configurations named `_internal-unified-test-platform-*`, which is the Android Gradle plugin's harness for running instrumented tests on a device. This project runs no instrumented tests, so that harness is never invoked. They cannot reach a runner and they are not in the APK, so the scan reports them and does not fail on them, and the reasoning is written into the script. Google's own reusable workflow runs alongside the script and records the same findings to the repository's Security tab, with its gate turned off for the same reason: the script is what fails a branch. The honest fix is a newer Android Gradle plugin; [`#127`](https://github.com/Running-Coach-App/running-coach-app/issues/127) and the Android Gradle plugin 9 break stand in the way, so this is recorded rather than closed.

- **Several criteria cannot be checked without a device matrix the team does not have.** `Orientation_Transitions`, `Display_State_Parity`, `Graphic_Quality`, `Visual_Contrast`, `Line_Length`, and the fold and tablet cases all need the emulators Google's own test environment section names. They are not rejected as inapplicable; they are untested, and that is a different claim.

## What Becomes A Requirement, And What Does Not

| Google's criterion | What the product does | Outcome |
| --- | --- | --- |
| `Stability_ANR`, plus the vitals crash and ANR thresholds | No crash seen in the team's own sessions; no vitals data exists because nobody outside the team has installed | [`QR-06`](../quality-requirements/qr/QR-06.md) |
| `Background_Service_Optimization` | GPS runs for the whole session, and is released on stop and on destroy | [`QR-07`](../quality-requirements/qr/QR-07.md) |
| `Minimize_Permissions`, `SDK_Maintenance`, and the `Customer`'s scanner | No network permission; no vulnerable shipped dependency | [`QR-08`](../quality-requirements/qr/QR-08.md) |
| `Audio_Notification_Style` | Notification is not `MediaStyle` | A defect, [issue #197](https://github.com/Running-Coach-App/running-coach-app/issues/197) |
| `Audio_Focus_Request` | Automatic at `targetSdk` 31 and above | Met by the platform |
| `Audio_Focus_Change` | Not verified | Untested |
| `Target_SDK_Version`, `Compile_SDK_Version` | Both 35 | Met |
| `Component_Export`, `Component_Permissions` | Components declare `android:exported`; `PendingIntent` uses `FLAG_IMMUTABLE` | Met |
| `Graceful_Degradation` | A session keeps speaking what it still has | Met, held by [`QR-04`](../quality-requirements/qr/QR-04.md) |
| `Network_Security_*`, `Security_Provider_Initialization` | No network traffic exists | Satisfied by absence |
| `WebView_*`, `Autofill_Hints`, `Credential_Manager`, `Biometric_Authentication`, `App_Logins_Restoration` | No WebView and no sign-in | Not applicable to this product |
| `Video_*` | No video | Not applicable |
| `Orientation_Transitions`, `Display_State_Parity`, `Graphic_Quality`, `Visual_Contrast`, `Line_Length` | Not measured | Untested: needs the device matrix Google's test environment names |
| `App_Bundles` | The release is an APK, not an App Bundle | Outstanding, and required before any real Play submission |
| `Play_Feature_Graphic`, `Play_Content_Rating`, `Play_Content_Policies`, `Play_User_Reviews` | No store listing exists | Out of scope for this course |

## On Publishing For Real

The `Customer` said to "work towards publishing on the Play Store". Nothing in this course needs an actual submission, and three things would have to change first, so they are recorded here rather than attempted:

1. **The build must be an App Bundle, not an APK.** Google states that App Bundles have been mandatory for new apps since August 2021. The product publishes a debug APK from every CI run and attaches one to each release, which is right for a `Customer` who installs by hand and wrong for a store.
2. **The build must be signed with a release key.** [`#137`](https://github.com/Running-Coach-App/running-coach-app/issues/137) has carried this since `SPRINT-05`, and the key itself can never enter this repository.
3. **A Data safety declaration would be needed.** The Core app quality page does not mention it — it says only that apps "must also follow the Google Play User Data policies" — but the Play Console requires the form. With [`DEC-030`](../decisions.md#dec-030) and [`DEC-031`](../decisions.md#dec-031) now allowing usage and performance metrics to be collected and sent, that form would have to say so, and the opt-out the `Customer` asked for becomes part of the answer rather than a nicety.

## Sources

- [Core app quality](https://developer.android.com/docs/quality-guidelines/core-app-quality) ([archived 2026-11-10; read 2026-11-13](https://web.archive.org/web/20261110195135/https://developer.android.com/docs/quality-guidelines/core-app-quality)) — the criteria, their identifiers, and the test rows.
- [Android vitals](https://developer.android.com/topic/performance/vitals) ([archived 2026-09-16; read 2026-11-13](https://web.archive.org/web/20260916013235/https://developer.android.com/topic/performance/vitals)) — the core vitals and the bad behaviour thresholds.
- [Android vitals in Play Console](https://support.google.com/googleplay/android-developer/answer/9844486) ([archived 2026-10-22; read 2026-11-13](https://web.archive.org/web/20261022220922/https://support.google.com/googleplay/android-developer/answer/9844486)) — the definitions of user-perceived crash and ANR rates, the 28-day window, and what exceeding a threshold does.
- [OSV-Scanner documentation](https://google.github.io/osv-scanner/) ([archived 2026-11-04; read 2026-11-13](https://web.archive.org/web/20261104020404/https://google.github.io/osv-scanner/)) — the scanner used for the dependency half, its supported Gradle lockfiles, and its exit codes.
- [OSV.dev](https://osv.dev/) ([archived 2026-11-10; read 2026-11-13](https://web.archive.org/web/20261110143547/https://osv.dev/)) — the advisory database both the tool and the script query.
