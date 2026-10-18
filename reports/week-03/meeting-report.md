# Week 3 validation meeting report

## Metadata

- **Date:** 2026-10-17
- **Duration:** about 29 minutes
- **Attended:** Ezekiel-Gadzama, sirjaey, Obetech1, Customer
- **Presented:** the intended Week 3 pocket-coach behaviours in speech (no working binary was shown)
- **Recording:** Zoom recording exists. Share link held for Moodle and the team channel; the passcode is not published in this repository.
- **Transcript publication:** permitted; the `Customer` offered the transcript and the video, see [the transcript](meeting-transcript.md)
- **Transcript shared privately:** not applicable
- **Transcript:** [meeting-transcript.md](meeting-transcript.md)
- **Script:** [meeting-script.md](meeting-script.md)

## Previous action points

| Action | Outcome | Decision |
| --- | --- | --- |
| [`reports/week-02/meeting-report.md`](../week-02/meeting-report.md#action-points): complete the on-device TTS and small-model feasibility spike | Carried as research in the Week 3 docs tree; the meeting preferred an on-device LLM when it fits, with keywords as backup | [DEC-016](../../docs/decisions.md#dec-016) |
| [`reports/week-02/meeting-report.md`](../week-02/meeting-report.md#action-points): ask the remaining script questions (Q7, Q10) at Week 3 | Q7 (spoken questions / off-topic) was asked. Q10 (professional runners) was not asked | None for Q10 |
| [`reports/week-02/meeting-report.md`](../week-02/meeting-report.md#action-points): restate VP-01 and VP-02 for the query-response scope | Restatement work is tracked as task issues; the meeting did not re-open VP-02 presets order | None |
| [`reports/week-02/meeting-report.md`](../week-02/meeting-report.md#action-points): arrange the Week 3 validation | Held live on Zoom on 2026-10-17 | None |

## Previous open questions

| Question | Answer | Decision |
| --- | --- | --- |
| [`reports/week-02/meeting-report.md`](../week-02/meeting-report.md#open-questions): are professional runners in scope later? | Not asked in this meeting | None |
| [`reports/week-02/meeting-report.md`](../week-02/meeting-report.md#open-questions): what does a wearable add, and can we reach one in ten weeks? | Not asked in this meeting | None |
| [`reports/week-02/meeting-report.md`](../week-02/meeting-report.md#open-questions): has the `Customer` accepted the MUP candidate, and do the two presets still follow the coach? | Behaviours for US-01 through US-04 were affirmed in description, not demonstrated. The two-presets order was not asked | [DEC-010](../../docs/decisions.md#dec-010) through [DEC-016](../../docs/decisions.md#dec-016) |

## Summary

- No working app was shown. The team described what they are implementing so the `Customer` could correct the direction before more work lands.
- A three-minute stats cadence is fine for the MUP; configurable cadence is a later nice-to-have.
- Missing stats must be spoken once, then omitted until they become available again.
- Navigation (changing course mid-run) stays outside the remaining weeks.
- Off-topic questions get a polite "focus on running" style reply, not an invented answer.
- Prefer an on-device small model for intent when it fits; keyword matching is an acceptable backup.
- Interval effort cues (jog / harder / easier) with silence on steady are the coaching the `Customer` wants; stats may still speak during steady.
- Pocket start/stop via volume keys (not motion) is acceptable; a spoken "start the session" would also be welcome later.
- Unexpected plan-change behaviour is outside this small app's scope while programmes stay simple and user-picked.
- Next bar: a minimum usable install he can try on his phone, then grow value in later updates.

## Decisions

- [DEC-010: Keep navigation outside the remaining course weeks.](../../docs/decisions.md#dec-010)
- [DEC-011: Speak a missing stat once, then omit it until it is available again.](../../docs/decisions.md#dec-011)
- [DEC-012: Answer off-topic questions with a polite focus-on-running reply.](../../docs/decisions.md#dec-012)
- [DEC-013: Keep a three-minute spoken stats cadence for the MUP.](../../docs/decisions.md#dec-013)
- [DEC-014: Affirm interval effort cues and silence on steady.](../../docs/decisions.md#dec-014)
- [DEC-015: Affirm pocket start and stop without motion detection.](../../docs/decisions.md#dec-015)
- [DEC-016: Prefer an on-device model for spoken intent; keywords are the backup.](../../docs/decisions.md#dec-016)

## Action points

| Action | Owner | Due |
| --- | --- | --- |
| Land a minimum usable install the `Customer` can put on his phone | Team / [#86](https://github.com/Running-Coach-App/running-coach-app/issues/86) | End of Week 4 |
| Apply the missing-stat "say once" rule in the stats path | Responsible for US-02 / [#58](https://github.com/Running-Coach-App/running-coach-app/issues/58) (AC-03) | With the stats task |
| Replace or wrap the off-topic refusal with a polite focus-on-running phrase | [#85](https://github.com/Running-Coach-App/running-coach-app/issues/85) (follows closed [#60](https://github.com/Running-Coach-App/running-coach-app/issues/60)) | With the spoken-question follow-up |
| Ask the unfinished Week 2 questions: professional runners, wearable, and whether the two presets still follow the coach | Ezekiel-Gadzama / [#87](https://github.com/Running-Coach-App/running-coach-app/issues/87) | Next customer meeting |
| Commit the Week 3 transcript and record the validation outcome | Team / [#83](https://github.com/Running-Coach-App/running-coach-app/issues/83), [#84](https://github.com/Running-Coach-App/running-coach-app/issues/84) | With the Week 3 report |

## Open questions

| Question | What it would change | Follow-up |
| --- | --- | --- |
| Are professional runners in scope later? | Whether anything built now must generalise to them | Next validation |
| What does a wearable add, and should any remaining week go to one? | Whether heart rate is an input at all | Next validation |
| Do the two presets still follow this coach, or do they leave the plan? | Build order after the pocket coach | Next validation |

## Disagreements

| Your position | Customer's position | What you changed |
| --- | --- | --- |
| Keyword-only phrase matching is enough for Week 3 spoken questions | Prefer an on-device LLM for intent when it fits; keywords only if the model path fails | Recorded as [DEC-016](../../docs/decisions.md#dec-016); Week 3 binary may still ship keywords as the backup |
| Missing distance can be repeated every stats cycle | Say missing once, then stay quiet until it returns | Recorded as [DEC-011](../../docs/decisions.md#dec-011) |

## Deviations

1. **No working app was demonstrated.**
   Direction was corrected from description only. Device acceptance of the slice still waits on an installable build.
2. **The three scripted permission questions were not asked one by one.**
   The `Customer` offered the transcript and the recording himself at the start, so publication was taken as permitted.
3. **Professional runners, wearable value, and the two-presets order were not asked.**
   They remain in [open questions](#open-questions) for the next validation.
4. **Script question 12 (plan-change vs phone-only adaptation) was not re-asked.**
   Question 9 covered unexpected plan change; he placed it outside this small app's scope.
