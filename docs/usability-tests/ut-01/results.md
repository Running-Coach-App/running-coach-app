# UT-01 Results

**No session has run, and this file claims no result.**

`UT-01` is designed in [`SPRINT-07`](../../project-plan.md#sprint-07) and its counted sessions are planned for [`SPRINT-08`](../../project-plan.md#sprint-08), with the results due with Submission 8 on 2026-11-21. The design is [the record](README.md); the headings below are the ones the run week fills, in the order [the analysis plan](README.md#analysis-plan) sets, so that nothing about what is reported is chosen after the data.

Until then: the sessions that have run is none, the findings are none, and [the testing plan](../../project-plan.md#quality-requirement-testing-plan) carries [`QR-09 QRT-01`](../../quality-requirements/qr/QR-09.md#qrt-01) as `Not verified`.

## The Results

<!-- Run week: one row per counted participant, linked to its sanitized note. -->

| Participant | Main task | Main time | Main SEQ | Secondary 1 | Sec 1 time | Sec 1 SEQ | Secondary 2 | Sec 2 time | Sec 2 SEQ | SUS | Hints | Pocket exits |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |

The run week also reports, below that table:

- the main task's aggregate completion: the count and the proportion who reached the end state, and the count and the proportion who reached it `Unaided`;
- the main task's median time on task;
- the median SEQ for the main task and for each secondary task;
- the SUS mean and median, each with `n=<count>`;
- the pocket exit count per participant and its median, the additional measure [the analysis plan](README.md#analysis-plan) named before the first session;
- the instrumentation comparison, reading each session's exported events against the observer's sheet, and naming what the instrumentation could not cover;
- any code that was retired, and why.

## Findings

No finding exists yet. Each one is a section of its own in the run week, with these fields, so it can be cited by its anchor as `docs/usability-tests/ut-01/results.md#finding-1`:

```markdown
### Finding 1

<One sentence saying what is wrong, in terms of what the participant was trying to do.>

- **Severity:** Critical, Major, or Minor, with the reason for that rating.
- **Tasks:** the task, and the participant codes it came from, such as `UT-01 P-01, UT-01 P-03`.
- **Evidence:** what was observed or measured, linked to the session notes or to the table above.
- **Recommendation:** what the team would change.
- **Task issue:** a link to the task issue that carries the work, or `None` when no issue was opened.
```

## The Triage Plan

Written before the sessions, so that what happens to a finding is not decided by how inconvenient it is.

1. **Every finding is triaged.** Each one gets its severity, a decision on whether it becomes a task issue, and the sprint the work is scheduled in. A finding the team decides not to act on is still recorded, with the reason.
2. **A significant finding becomes work.** If any finding is `Critical` or `Major`, at least one of them becomes a task issue scheduled in [`SPRINT-08`](../../project-plan.md#sprint-08). If the sessions find nothing significant, no issue is forced and the results say so.
3. **A behaviour change or a defect names what it serves.** Such a task issue links the user story and the `AC-nn` it belongs to and names the `FR-nnn` or the `ADR-nnn` in its `### Requirements` section. A defect names one and never says `None`. A task that is not product work says `None: repository upkeep`.
4. **The citation goes both ways.** The task issue cites the finding by its path and anchor, and the finding's `**Task issue:**` field links the issue.
5. **A fix that lands in `SPRINT-08` is in `REL-08`.** One that lands later moves to `SPRINT-09`, and the Week 8 report says so.
6. **The verdict is not recorded here.** [The testing plan](../../project-plan.md#quality-requirement-testing-plan) records `QR-09 QRT-01` as `Passes` or `Fails` with its `Checked` sprint and this file as its evidence. This file states what was found; the plan states what it settled.

## Limitations

The run week states the sample size, the participants' relation to the target user, the build and the environment the sessions ran in, and what the team could not measure — including the two secondary tasks and the pocket question, which [the record](README.md#what-the-instrumentation-cannot-cover) says the instrumentation cannot cover.

## Conclusion

The run week writes it. It says what the sessions showed about the research questions, and it states the `QR-09` measure against the bar the team set before the first session, pointing at the testing plan for the verdict.
