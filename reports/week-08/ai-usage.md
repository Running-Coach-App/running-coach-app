# AI usage — Week 08

## Tools

Claude Code, driven from a terminal, attached to this repository and — new this week — to a physical Android phone over `adb`. No other AI tool was used.

## What we used it for

Reading Assignment 8 at the commit the course pinned, and auditing its thirteen parts against the repository before any work started.

Driving the on-device checks for [#212](https://github.com/Running-Coach-App/running-coach-app/issues/212) on a Xiaomi `2409BRN2CA` running Android 14: installing the build, reading the view tree, toggling the microphone and the usage-data settings through the screen, sampling the screen's own label and the operating system's `appops` record together, and counting the lines the event file gained.

Finding and fixing [#253](https://github.com/Running-Coach-App/running-coach-app/issues/253), the crash that stopped the app opening once a runner turned `Usage data` off, and verifying the fix on the phone through three cold launches.

Checking the published release artifact rather than the source — `aapt2 dump permissions`, the merged manifest, and a search for an address in the compiled code — which produced [#248](https://github.com/Running-Coach-App/running-coach-app/issues/248) and the correction in [#249](https://github.com/Running-Coach-App/running-coach-app/pull/249).

Diagnosing the intermittent Gradle failures and writing the revert in [#261](https://github.com/Running-Coach-App/running-coach-app/pull/261), with the hold recorded where the bump is configured.

Writing [`docs/configuration-plan.md`](../../docs/configuration-plan.md) by reading the repository — the workflows, the scripts, the pins, the root files, and the settings whose behaviour had to be inferred — and [`cm-evaluation.md`](cm-evaluation.md) from what the week's own work did to that configuration.

Writing the configuration terms in [`docs/glossary.md`](../../docs/glossary.md) and the four configuration risks in [`docs/risks.md`](../../docs/risks.md).

## What we did with the output

Every claim about the product was checked against the device or the binary before it was written down, and several did not survive that. A finding that the coach was hearing its own voice was filed, withdrawn when a team member said the questions were his, and reopened only when a direct capture showed the product transcribing its own spoken lines. A conclusion that Gradle 9.9.1 had broken the build was withdrawn when the same version was found building `main` successfully; the real cause was a branch missing an unrelated bump. A claim that Dependabot never regenerates the lockfile was repeated from a comment in the repository's own configuration and then disproved by reading the commit, which was written by Dependabot and carried the lockfile.

Three scripted device checks produced output that looked like a result and was not: a tap on a coordinate that moved when the layout changed, a regular expression anchored on the wrong character, and a shell redirect that read a device path on the local machine. Each was found by checking the result against the product's own stored state rather than by reading the script again. The checks that are reported in [#204](https://github.com/Running-Coach-App/running-coach-app/issues/204) and [#208](https://github.com/Running-Coach-App/running-coach-app/issues/208) are the ones that assert their own preconditions and abort instead of passing.

Nothing was committed on the tool's word. The crash fix was verified on the phone, the revert was verified byte-for-byte against the pre-bump commit, and the configuration plan was written from the files rather than from a description of them.

## Usability material given to an AI tool

**No raw usability material was given to any AI tool, because none exists yet.** No `UT-01` session has been counted, so there is no recording, no raw answer sheet, and no participant note to give it. The tool was given the public design — [the record](../../docs/usability-tests/ut-01/README.md), [the surveys](../../docs/usability-tests/ut-01/surveys.md), and [the session script](../../docs/usability-tests/ut-01/sessions/README.md) — all of which are already published in this repository.

One piece of telemetry from a team member's own phone was read: the `events.jsonl` file the app writes. It contains no identity and no spoken text by design, it came from the team's own device rather than a participant's, and it was kept outside the repository. Nothing from it was committed.

For one diagnosis the tool built a temporary local-only build that wrote each recognised phrase to a file on the phone, so that what the speech recogniser actually produced could be read instead of guessed. That build was never committed, the instrumented line was reverted from the source before anything else was done, the clean build was reinstalled, and the capture file was deleted from the device. Only the product's own spoken words were quoted from it in public.

**The configuration plan and the evaluation were given to the tool in their public, sanitized state**, because the tool wrote them: both were composed from the repository's tracked files. No secret value, deployment address, or credential was read or written. The private addresses and credentials stay in the Moodle submission wrapper, and the plan names them in words only.

## What was not used

No AI tool was given the private usability-data repository, the recordings folder, or any credential. No session, meeting, or customer conversation was simulated.
