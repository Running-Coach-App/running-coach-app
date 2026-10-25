# Week 4 validation meeting report

## Metadata

- **Date:** 2026-10-23
- **Duration:** about 24 minutes
- **Attended:** Ezekiel-Gadzama, sirjaey, ObeTech1, Customer
- **Presented:** a screen-shared demonstration of the app speaking a session start, effort cues, spoken questions and replies, and a session stop. The quality requirements index, the container view, and the architectural decision records were not shown in this meeting.
- **Recording:** permitted — the `Customer` started recording at the opening of the call.
- **Transcript publication:** script question 2 was not asked separately; the team publishes a sanitized transcript in this repository from the recording the `Customer` supplied.
- **Transcript shared privately:** script question 3 was not asked separately.
- **Transcript:** [meeting-transcript.md](meeting-transcript.md)
- **Script:** [meeting-script.md](meeting-script.md)

## Previous action points

| Action | Outcome | Decision |
| --- | --- | --- |
| [`reports/week-03/meeting-report.md`](../week-03/meeting-report.md#action-points): "Land a minimum usable install the `Customer` can put on his phone" | Partial: an APK was offered; the `Customer` has not installed it and will build from the repository and install on his phone this week. Demo evidence was shown on a team screen share. Tracked in [#86](https://github.com/Running-Coach-App/running-coach-app/issues/86). | [DEC-021](../../docs/decisions.md#dec-021) |
| [`reports/week-03/meeting-report.md`](../week-03/meeting-report.md#action-points): "Apply the missing-stat "say once" rule in the stats path" | Carried out: a missing stat is named once and then left out until it returns, covered by a unit test. The demo repeated "distance is not available yet" when asked twice in quick succession; the `Customer` did not comment on that behaviour in this meeting. | None |
| [`reports/week-03/meeting-report.md`](../week-03/meeting-report.md#action-points): "Replace or wrap the off-topic refusal with a polite focus-on-running phrase" | Carried out and affirmed in the demo: food and pace off-topic replies were received positively. | [DEC-020](../../docs/decisions.md#dec-020) |
| [`reports/week-03/meeting-report.md`](../week-03/meeting-report.md#action-points): "Ask the unfinished Week 2 questions: professional runners, wearable, and whether the two presets still follow the coach" | Not asked — script questions 14 to 16 were not reached. | None |
| [`reports/week-03/meeting-report.md`](../week-03/meeting-report.md#action-points): "Commit the Week 3 transcript and record the validation outcome" | Carried out in Week 3: the transcript is published and the outcome is recorded in `DEC-010` to `DEC-016`. | None |

## Previous open questions

| Question | Answer | Decision |
| --- | --- | --- |
| [`reports/week-03/meeting-report.md`](../week-03/meeting-report.md#open-questions): "Are professional runners in scope later?" | Not asked — script question 14. | None |
| [`reports/week-03/meeting-report.md`](../week-03/meeting-report.md#open-questions): "What does a wearable add, and should any remaining week go to one?" | Not asked — script question 15. | None |
| [`reports/week-03/meeting-report.md`](../week-03/meeting-report.md#open-questions): "Do the two presets still follow this coach, or do they leave the plan?" | Not asked — script question 16. | None |

## Summary

- The team demonstrated spoken start, effort cues, stat and off-topic questions, and stop over screen share. The `Customer` had not installed the offered APK and will build from the repository before trying the app on his own phone.
- The `Customer` rated the audio acceptable for a first usable product and told the team to proceed, with on-screen stats as the more important next step than tone or phrasing polish.
- The quality requirements and the architecture were not walked through, so this meeting does not validate those artifacts against the drivers; that remains for a follow-up that follows the rest of [the script](meeting-script.md).
- Pocket use with the screen off and Bluetooth headsets were discussed as important; the team stated they had tested them, and the `Customer` will confirm when he runs his own build.
- The next live check-in was agreed for Saturday at the same time; asynchronous updates over Telegram are welcome.

## Story verdicts

| Story | Verdict | Decision |
| --- | --- | --- |
| [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) | Accepted from the demonstration; pocket volume-key control was not validated on the `Customer`'s device in this meeting. | [DEC-017](../../docs/decisions.md#dec-017) |
| [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38) | Accepted on audio for the first usable product; the same information must also appear on screen. | [DEC-018](../../docs/decisions.md#dec-018) |
| [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39) | Accepted for the first usable product from the heard effort cues. | [DEC-019](../../docs/decisions.md#dec-019) |
| [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) | Accepted for the first usable product; varied wording for repeated stat questions is desirable but not required for this cut. | [DEC-020](../../docs/decisions.md#dec-020) |

## Decisions

- [DEC-017: Affirm US-01 from the Week 4 demonstration.](../../docs/decisions.md#dec-017)
- [DEC-018: Affirm US-02 on audio and require the same stats on screen.](../../docs/decisions.md#dec-018)
- [DEC-019: Affirm US-03 for the first usable product.](../../docs/decisions.md#dec-019)
- [DEC-020: Affirm US-04 for the first usable product.](../../docs/decisions.md#dec-020)
- [DEC-021: Install only from a build the Customer makes from the repository.](../../docs/decisions.md#dec-021)
- [DEC-022: Proceed with on-screen run stats in the next increment.](../../docs/decisions.md#dec-022)

## Action points

| Action | Owner | Due |
| --- | --- | --- |
| Build the app from the repository, install it on the `Customer`'s phone, and confirm pocket and Bluetooth headset use | `Customer` (tracked under [#86](https://github.com/Running-Coach-App/running-coach-app/issues/86)) | 2026-10-31 |
| Show elapsed time, pace, and distance on screen while the coach speaks them | sirjaey | 2026-10-31 |
| Run script questions 14 to 16 and the quality-requirements and architecture sections at the next customer meeting | Ezekiel-Gadzama / [#87](https://github.com/Running-Coach-App/running-coach-app/issues/87) | 2026-10-25 |

## Open questions

| Question | What it would change | Follow-up |
| --- | --- | --- |
| Are professional runners in scope later? | Whether anything built now must generalise to faster runners | Next customer meeting — script question 14 |
| What does a wearable add, and should any remaining week go to one? | Whether heart rate or watch data enters the plan | Next customer meeting — script question 15 |
| Do the two presets still follow this coach, or do they leave the plan? | Build order after the pocket coach | Next customer meeting — script question 16 |
| Which quality requirement would the `Customer` drop or replace? | The promised quality set in `docs/quality-requirements/` | Next customer meeting — script question 9 |
| Which architectural decision is most likely wrong later? | Which ADR to revisit first | Next customer meeting — script question 13 |

## Disagreements

| Your position | Customer's position | What you changed |
| --- | --- | --- |
| A Telegram APK is enough to get an install onto the `Customer`'s phone quickly | He will only install an APK he built from the published repository | Recorded as [DEC-021](../../docs/decisions.md#dec-021); `docs/setup.md` already documents a clean-checkout build |
| Functionality first; minimal UI until the coach behaviours are stable | He wants the spoken information mirrored on screen as soon as practical | Recorded as [DEC-018](../../docs/decisions.md#dec-018) and [DEC-022](../../docs/decisions.md#dec-022) |

## Deviations

1. **Script questions 1 to 3 were not asked in the planned order.** The `Customer` began recording before the team asked permission; questions 2 and 3 about publishing or sharing the transcript were not put separately.
2. **The meeting did not follow the full Week 4 agenda.** Questions 9 to 13 and 14 to 16 were not asked, and the quality requirements and architecture pages were not shown.
3. **The install was demonstrated by screen share, not on the `Customer`'s phone.** Verdicts rest on what he heard in the demo plus his commitment to build and try his own install this week.
