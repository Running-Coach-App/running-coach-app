# Week 08 report

## Project

**Running Coach App**, team 4. An Android app that speaks a runner's time, pace, and distance while the phone stays in a pocket, and answers a spoken question about the current run. Everything it records stays on the phone.

- Repository: <https://github.com/Running-Coach-App/running-coach-app>
- Documentation site: <https://running-coach-app.github.io/running-coach-app/>

## Summary

**The usability test did not run. No `UT-01` session has been counted, so this week reports no usability results, and [`QR-09 QRT-01`](../../docs/project-plan.md#quality-requirement-testing-plan) stays `Not verified`.** The design was finished in `SPRINT-07` and is unchanged; what did not happen is the sessions. The shortfall is declared in [`## Deviations`](#deviations) with its reason, and nothing smaller is presented in place of a result.

What the sprint did produce is a different kind of evidence. A physical phone was attached to the project for the first time, and **five defects were found in one afternoon that no unit test, no CI check, and no scanner could have reached**:

- **[#253](https://github.com/Running-Coach-App/running-coach-app/issues/253) — turning off `Usage data` made the app die on every launch.** The one privacy control the `Customer` asked for was the control that bricked the product, in the build on the releases page. Fixed in [#254](https://github.com/Running-Coach-App/running-coach-app/pull/254) and verified on hardware through three cold launches.
- **[#248](https://github.com/Running-Coach-App/running-coach-app/issues/248) — the published release asset is a debug build.** It holds `INTERNET`, is debuggable, and permits cleartext, while the README said the opposite. Corrected in [#249](https://github.com/Running-Coach-App/running-coach-app/pull/249). It has no collector address compiled into it, so it uploads nothing; the claim was true in effect and false in mechanism, and the mechanism is what the `Customer` asked to verify.
- **[#251](https://github.com/Running-Coach-App/running-coach-app/issues/251) — distance counts GPS jitter.** A stationary phone recorded 516 m in 270 s and displayed a pace of 1:38 per kilometre.
- **[#252](https://github.com/Running-Coach-App/running-coach-app/issues/252) — two telemetry fields cannot be true.** `lost_s` is measured across sessions, which makes the published fix-availability metric read −33% on real data.
- **[#250](https://github.com/Running-Coach-App/running-coach-app/issues/250) — the coach transcribes its own voice** as though a runner had spoken, which inflates `question_asked` in any export.

**The configuration review found a configuration that works and a signal that does not.** [`docs/configuration-plan.md`](../../docs/configuration-plan.md) inventories **11 `Active` `CFG-nn` items** across the five groups. [`cm-evaluation.md`](cm-evaluation.md) judges them against **four local goals**. Its first change is to **require a branch to be up to date with `main` before it can merge**: it keeps every check and every workflow, removes one mechanism — a person deciding from a timestamp whether a green tick is still true — and its main tradeoff is speed, because it serialises a merge queue that is currently parallel. That decision was made wrongly three times in one day this sprint.

Links: [the results](../../docs/usability-tests/ut-01/results.md) · [the sanitized notes](../../docs/usability-tests/ut-01/sessions/) · [the `QR/QRT` row](../../docs/project-plan.md#quality-requirement-testing-plan) · [the configuration plan](../../docs/configuration-plan.md) · [the evaluation](cm-evaluation.md) · [`REL-08`](../../docs/project-plan.md#rel-08) · [the retrospective](sprint-retrospective.md) · [the AI usage](ai-usage.md). The private usability-data repository and the recordings folder are named in the Moodle submission wrapper and never here.

No aggregate is reported this week, so there is no `n=<count>` caveat to state. The rows that are not `Passes` are in [`docs/project-plan.md#quality-requirement-testing-plan`](../../docs/project-plan.md#quality-requirement-testing-plan).

## Customer meeting

`SPRINT-08`'s Sprint Review. [The script](meeting-script.md) and [the report](meeting-report.md) carry it; [the transcript](meeting-transcript.md) says what happened to the recording.

_To complete after the meeting._ The outcomes of the six Week 7 action points are already recorded in [`## Previous action points`](meeting-report.md#previous-action-points): one done, one partly done, three not done, and one overdue and to be confirmed with him.

## Usability test

**No counted session has run.** Three was the requirement and five the design target; the count is zero.

- **Results:** [`results.md`](../../docs/usability-tests/ut-01/results.md) carries no aggregates, because there is nothing to aggregate. Its headings are the ones `SPRINT-07` fixed before any data existed, so that what gets reported was not chosen after the fact.
- **Conclusion:** none. A conclusion requires sessions.
- **Sanitized session notes:** none exist. [`sessions/`](../../docs/usability-tests/ut-01/sessions/) holds the facilitation script and the note template only.
- **SUS and SEQ:** not collected.
- **Instrumentation comparison:** not possible without a session's telemetry export.
- **Findings:** none from `UT-01`. The five defects this week came from the team's own device testing, not from a participant, and they are issues rather than `UT-01` findings — calling them findings would claim a test that did not happen.
- **Triage:** not applicable. No finding means no finding is forced, and saying so is the result.
- **`QR/QRT` result:** [`QR-09 QRT-01`](../../docs/quality-requirements/qr/QR-09.md#qrt-01) stays **`Not verified`**, and [the testing plan](../../docs/project-plan.md#quality-requirement-testing-plan) carries the reason. The `UT-01` record stays `Planned`.

**Why it did not run.** The design, the surveys, the consent, and the private repository were all finished in `SPRINT-07`. Three things were not: the questionnaires did not reach the `Customer` (the Week 7 action point, due 2026-11-19, overdue), the recordings folder still needs its outside collaborator to accept an invitation in person ([#216](https://github.com/Running-Coach-App/running-coach-app/issues/216)), and the instrumentation task ([#210](https://github.com/Running-Coach-App/running-coach-app/issues/210)) is open. Nothing in the tracker owned *running* the sessions until [#255](https://github.com/Running-Coach-App/running-coach-app/issues/255) was opened this week — the questionnaires arrived under a closed issue, so the study had a design and no owner.

[#255](https://github.com/Running-Coach-App/running-coach-app/issues/255) also carries a decision the team must take before the first session: the `Customer` offered himself as a respondent, and [`recruitment.md`](../../docs/usability-tests/ut-01/recruitment.md) excludes the `Customer` by name. Counted, counted-with-the-bias-recorded, or a practice round — any is defensible; deciding it in the moment is not.

One correction to the protocol landed this sprint: [#257](https://github.com/Running-Coach-App/running-coach-app/pull/257) moved the 18-or-older check **before** the consent form and the recorder. The script had asked it after both, with the instruction "stop and record nothing" — which could not be followed, because by then a signature had been collected and audio was recording.

## Configuration management

- **Plan:** [`docs/configuration-plan.md`](../../docs/configuration-plan.md), reviewed 2026-11-19.
- **Evaluation:** [`cm-evaluation.md`](cm-evaluation.md).
- **Baseline:** [`bd3ca33`](https://github.com/Running-Coach-App/running-coach-app/commit/bd3ca33d8c4e83fbbe824c16f4c7c0a23de47768), `main` on 2026-11-19.
- **`Active` items:** 11, across source control and release, checks, environments and secrets, dependencies and builds, and agent context and artifacts. No item has been dropped: the whole history contains one deleted file, a scratch list that was never a configuration item.
- **Local goals:** four — deciding that a change is safe to merge, reproducing the build a reader installs, keeping the context trustworthy for whoever reads it next, and putting the product where the `Customer` can reach it.
- **The first change:** require a branch to be up to date with `main` before it can merge.
- **What it keeps:** every check, every workflow, and the review requirement — nothing removed, no new tool.
- **Its tradeoff:** speed. It serialises a merge queue that is currently parallel, and it is worse while the link check keeps failing spuriously, because each forced re-run is another chance to draw a false red.

Both artifacts are linked rather than restated. The configuration terms are in [`docs/glossary.md`](../../docs/glossary.md) and the four configuration risks are [`RISK-08`](../../docs/risks.md#risk-08) to [`RISK-11`](../../docs/risks.md#risk-11).

## Threshold review

[`TOS-03`](../../docs/threshold-of-success.md#tos-03) is still `Open`: *"By the end of Week 9 a spoken question about the current run's time, pace, or distance is answered on the phone, with no round trip to a server."* Its measure is one session on a physical Android phone, cited from the Week 9 report, by 2026-11-27.

**That evidence now exists, a week early.** In a session on 2026-11-19 on a Xiaomi `2409BRN2CA`, six spoken questions were asked aloud through a locked screen and six were answered — `pace` twice, `time`, `distance`, and two deliberately off-topic ones correctly refused. The build under test declares no network permission in its main manifest, and the published build carries no collector address at all, so no round trip was possible. The status is **left `Open`** here rather than set, because the goal's own measure names the Week 9 report as where it is cited, and the goal is Week 9's to close.

The team has **no usability goal** in the threshold, so there is none to settle against `UT-01`. The required check is the quality requirement and its test, which is [`QR-09`](../../docs/quality-requirements/qr/QR-09.md), recorded above as `Not verified`.

## Week 9 handoff

- **The results:** [`results.md`](../../docs/usability-tests/ut-01/results.md), carrying no aggregates. Week 9 runs the sessions under [#255](https://github.com/Running-Coach-App/running-coach-app/issues/255) and fills it, or declares the shortfall again before the pitch.
- **The configuration plan:** [`docs/configuration-plan.md`](../../docs/configuration-plan.md), 11 `Active` items, reviewed 2026-11-19. It is updated in the same pull request as any change that alters what it records.
- **The evaluation:** [`cm-evaluation.md`](cm-evaluation.md) — four goal sections, each with its `Today`, its proposed change, its reasoning, and its tradeoffs, plus [`## What We Could Not Judge`](cm-evaluation.md#what-we-could-not-judge) and [`## The First Change`](cm-evaluation.md#the-first-change).
- **The final repository state:** `main` at the `REL-08` tag.
- **The private repository and the recordings folder:** both named with their access instructions in the Moodle submission wrapper, and never in this repository. The recordings folder still needs its outside collaborator to accept an invitation in person — [#216](https://github.com/Running-Coach-App/running-coach-app/issues/216).
- **The `REL-08` tag:** _to complete at the sprint close._
- **The deck's evidence:** the five device findings and their issues; the crash fix verified on hardware; the configuration evaluation's first change; `TOS-03`'s evidence above; and whatever `UT-01` produces if the sessions run.

## Coverage

| Deliverable | Where |
| --- | --- |
| Sprint plan | [`docs/project-plan.md#sprint-08`](../../docs/project-plan.md#sprint-08) |
| Usability results | [`docs/usability-tests/ut-01/results.md`](../../docs/usability-tests/ut-01/results.md) |
| Sanitized session notes | [`docs/usability-tests/ut-01/sessions/`](../../docs/usability-tests/ut-01/sessions/) — none written; no session ran |
| `QR-09` and its test | [`docs/quality-requirements/qr/QR-09.md`](../../docs/quality-requirements/qr/QR-09.md) and [`QRT-01`](../../docs/quality-requirements/qr/QR-09.md#qrt-01) |
| Findings and their issues | [`docs/usability-tests/ut-01/results.md#findings`](../../docs/usability-tests/ut-01/results.md#findings) — none; no session ran |
| Threshold review | [`#threshold-review`](#threshold-review) |
| Configuration management | [`#configuration-management`](#configuration-management) |
| Glossary | [`docs/glossary.md`](../../docs/glossary.md) |
| Risk register | [`docs/risks.md`](../../docs/risks.md) |
| `REL-08` | [`docs/project-plan.md#rel-08`](../../docs/project-plan.md#rel-08) |
| Sprint retrospective | [`reports/week-08/sprint-retrospective.md`](sprint-retrospective.md) |
| AI usage | [`reports/week-08/ai-usage.md`](ai-usage.md) |
| Week 7 action points | [`reports/week-08/meeting-report.md#previous-action-points`](meeting-report.md#previous-action-points) |
| Week 7 open questions | [`reports/week-08/meeting-report.md#previous-open-questions`](meeting-report.md#previous-open-questions) |
| Sprint Review | [`reports/week-08/meeting-report.md`](meeting-report.md) |
| Meeting script | [`reports/week-08/meeting-script.md`](meeting-script.md) |
| Meeting transcript | [`reports/week-08/meeting-transcript.md`](meeting-transcript.md) |
| Week 9 handoff | [`#week-9-handoff`](#week-9-handoff) |

## Repository evidence

_To complete at the sprint close with the final list and the CI run links._ Merged into `main` this sprint:

| Pull request | What it did | Closed |
| --- | --- | --- |
| [#242](https://github.com/Running-Coach-App/running-coach-app/pull/242) | The run and a stop control on the lock screen | [#224](https://github.com/Running-Coach-App/running-coach-app/issues/224) |
| [#243](https://github.com/Running-Coach-App/running-coach-app/pull/243) | The runner-set stats interval, and the README rewrite | [#223](https://github.com/Running-Coach-App/running-coach-app/issues/223), [#225](https://github.com/Running-Coach-App/running-coach-app/issues/225) |
| [#245](https://github.com/Running-Coach-App/running-coach-app/pull/245) | `FR-002` and `FR-012` no longer specify the same behaviour | [#244](https://github.com/Running-Coach-App/running-coach-app/issues/244) |
| [#249](https://github.com/Running-Coach-App/running-coach-app/pull/249) | Says what the build on the releases page actually is | part of [#248](https://github.com/Running-Coach-App/running-coach-app/issues/248) |
| [#254](https://github.com/Running-Coach-App/running-coach-app/pull/254) | The app no longer dies when a runner turns usage data off | [#253](https://github.com/Running-Coach-App/running-coach-app/issues/253) |
| [#257](https://github.com/Running-Coach-App/running-coach-app/pull/257) | The age check moved before consent and the recorder | [#256](https://github.com/Running-Coach-App/running-coach-app/issues/256) |
| [#259](https://github.com/Running-Coach-App/running-coach-app/pull/259) | The Gradle version named where the build reads it | [#258](https://github.com/Running-Coach-App/running-coach-app/issues/258) |
| [#261](https://github.com/Running-Coach-App/running-coach-app/pull/261) | The wrapper back to 9.8.2, with the hold recorded | [#260](https://github.com/Running-Coach-App/running-coach-app/issues/260) |

Plus the two Dependabot bumps, [#246](https://github.com/Running-Coach-App/running-coach-app/pull/246) and [#247](https://github.com/Running-Coach-App/running-coach-app/pull/247), the second of which was reverted by #261.

## Deviations

1. **Fewer than three counted `UT-01` sessions ran — zero.** The requirement is three and the design target five. The reasons are in [`## Usability test`](#usability-test): the questionnaires did not reach the `Customer` by their due date, the recordings folder is not yet shared, the instrumentation task is open, and until [#255](https://github.com/Running-Coach-App/running-coach-app/issues/255) nothing in the tracker owned running the sessions. The `UT-01` record stays `Planned`, `results.md` carries no aggregates, and no usability result is claimed.
2. **[`QR-09 QRT-01`](../../docs/quality-requirements/qr/QR-09.md#qrt-01) is not recorded as `Passes` or `Fails`.** It stays `Not verified` and moves to [`SPRINT-09`](../../docs/project-plan.md#sprint-09), because its test is `UT-01` and no session was counted.
3. **[`QR-07 QRT-01`](../../docs/quality-requirements/qr/QR-07.md#qrt-01) did not run**, having already moved from `SPRINT-07` to `SPRINT-08`. It needs a session on a physical phone with `adb shell dumpsys location` read before, during, and after. A phone was attached this sprint and was spent on [#212](https://github.com/Running-Coach-App/running-coach-app/issues/212) and the crash in [#253](https://github.com/Running-Coach-App/running-coach-app/issues/253) instead. It moves to `SPRINT-09`.
4. **No usability fix lands in `REL-08`**, because no finding exists to fix. The release carries the product fixes the sprint found by other means, which is not the same thing and is not presented as such.
5. **The five device findings are issues, not `UT-01` findings.** They are not written as `### Finding n` in `results.md`, because they came from the team's own testing rather than from a participant, and numbering them there would claim a test that did not happen.
6. **`SPRINT-08` carries no `**Planned Velocity:**`.** This is the third sprint in which the planned figure was not a forecast, and it is also a carried retrospective action that is `Not done` — recorded in [the retrospective](sprint-retrospective.md#carried-actions) rather than only here.

## Privacy

No private-only material was committed to this repository, and no participant identity was committed to it. No participant exists yet; the private usability-data repository, the recordings folder, and the staging and production addresses and credentials are named only in the Moodle submission wrapper. The configuration plan names every private setting in words, with no address, credential, or secret value.
