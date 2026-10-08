# Week 01 report

## Project

Running Coach App, team 4.

The comparison used this problem-space sentence: a recreational runner training for a 5K to half-marathon race, often without a sports watch, needs a training plan that changes when their real runs differ from the plan and tells them why it changed, so they can trust it enough to keep following it.

The 2 October kickoff changed the product. The customer asked for a voice coach during the run. That is [VP-01](../../docs/research/value-proposition.md#vp-01). Re-scoring the gap analysis against that coach is still action point A1 in [the meeting report](meeting-report.md#action-points), due Monday 5 October 2026.

## What we did

We searched 17 candidate products and kept four alternatives: Runna (`ALT-01`, direct competitor), Garmin Coach (`ALT-02`, direct competitor bound to Garmin hardware), Hal Higdon plans (`ALT-03`, adjacent substitute), and GoldenCheetah (`ALT-04`, open source).
We compared them on seven properties fixed before the evaluation, found three gaps (`GAP-01` to `GAP-03`), and recorded five candidates we chose not to pursue.
We held a 29-minute kickoff with the `Customer` on Friday 2 October 2026, then rewrote the value proposition around the voice coach.

## Findings

**From the research.**
Runna is the product we could lose to: it works from a phone alone and is the only alternative that shows why a change happened, but only for pace changes from speed sessions (`GAP-01`).
The alternatives that adapt to how a run went need a Garmin watch or exclude walk/run sessions, so a phone-only beginner gets no adaptation (`GAP-02`).
Where training load is measured, in Garmin and GoldenCheetah, it is not documented as changing the plan (`GAP-03`).

**From the kickoff.**
The `Customer` described a different product from the one our research built toward: a real-time voice coach that varies intensity during the run and reads pace, distance, and heart rate aloud, so the runner never looks at the phone.
He did not mention training plans or plan changes.
Two premises from our research survived: the target runner is a beginner to intermediate runner, and the product must work from the phone alone (decisions D1 and D2 in [the meeting report](meeting-report.md#decisions)).
`GAP-01`, a plan that explains its changes, was not confirmed. The current [value proposition](../../docs/research/value-proposition.md) leads with the voice coach.

What is still open is listed in [the meeting report](meeting-report.md#open-questions).

## Coverage

| Deliverable | Artifact |
| --- | --- |
| Candidate list | [candidate-list.md](candidate-list.md) |
| Alternatives search | [docs/research/alternatives.md](../../docs/research/alternatives.md) |
| Compare the alternatives | [docs/research/comparison.md](../../docs/research/comparison.md) |
| Gap analysis | [docs/research/gap-analysis.md](../../docs/research/gap-analysis.md) |
| Value proposition | [docs/research/value-proposition.md](../../docs/research/value-proposition.md) |
| Research board | Not created. See Deviations. |
| Meeting script | [meeting-script.md](meeting-script.md) |
| Customer kickoff | [meeting-report.md](meeting-report.md), [meeting-notes.md](meeting-notes.md) |
| AI usage | [ai-usage.md](ai-usage.md) |

The repository is licensed under the [MIT License](../../LICENSE).

## Repository evidence

Branch protection on `main`, requiring a pull request and one approval, with no self-approval:

![Branch protection settings for main](images/branch-protection.png)

Merged pull request approved by another member: [pull request #21](https://github.com/Running-Coach-App/running-coach-app/pull/21), the value proposition by @Ezekiel-Gadzama, approved by @sirjaey.

Latest link check on `main`: [green run on commit 6103f00](https://github.com/Running-Coach-App/running-coach-app/actions/runs/37047395772).

Links excluded from the link check in [`.lycheeignore`](../../.lycheeignore):

- `https://www.halhigdon.com/training-programs/half-marathon-training/novice-1-half-marathon/`, the Hal Higdon plan page for `ALT-03`. The link check timed out. A direct request on 2026-10-02 returned the page.
- `https://www.halhigdon.com/wp-content/uploads/2018/04/Novice-1-Half-Marathon-Printable.pdf`, the printable plan. A direct request on 2026-10-02 returned the file. The same host has answered the checker with 202.
- Three Run With Hal help-center articles cited in [the alternatives](../../docs/research/alternatives.md). The checker receives 403. The articles were read for that file on 2026-09-29.

## Contribution

Every member authored at least one merged pull request and approved at least one pull request by another member.

| Member | Merged pull requests authored | Pull requests approved |
| --- | --- | --- |
| @JustACommonMan-OSDD | [#1](https://github.com/Running-Coach-App/running-coach-app/pull/1) root README, [#4](https://github.com/Running-Coach-App/running-coach-app/pull/4) comparison, [#6](https://github.com/Running-Coach-App/running-coach-app/pull/6) and [#19](https://github.com/Running-Coach-App/running-coach-app/pull/19) meeting script, [#8](https://github.com/Running-Coach-App/running-coach-app/pull/8) gap analysis, [#10](https://github.com/Running-Coach-App/running-coach-app/pull/10) `.lycheeignore`, [#16](https://github.com/Running-Coach-App/running-coach-app/pull/16) meeting report, [#17](https://github.com/Running-Coach-App/running-coach-app/pull/17) meeting notes | [#2](https://github.com/Running-Coach-App/running-coach-app/pull/2), [#5](https://github.com/Running-Coach-App/running-coach-app/pull/5), [#15](https://github.com/Running-Coach-App/running-coach-app/pull/15) |
| @sirjaey | [#2](https://github.com/Running-Coach-App/running-coach-app/pull/2) licence, [#5](https://github.com/Running-Coach-App/running-coach-app/pull/5) Dependabot and link check, [#15](https://github.com/Running-Coach-App/running-coach-app/pull/15) candidate list and AI usage | [#3](https://github.com/Running-Coach-App/running-coach-app/pull/3), [#6](https://github.com/Running-Coach-App/running-coach-app/pull/6), [#16](https://github.com/Running-Coach-App/running-coach-app/pull/16), [#17](https://github.com/Running-Coach-App/running-coach-app/pull/17), [#19](https://github.com/Running-Coach-App/running-coach-app/pull/19), [#21](https://github.com/Running-Coach-App/running-coach-app/pull/21), [#22](https://github.com/Running-Coach-App/running-coach-app/pull/22) |
| @ObeTech1 | [#3](https://github.com/Running-Coach-App/running-coach-app/pull/3) `.gitignore`. The alternatives observations were drafted in [#18](https://github.com/Running-Coach-App/running-coach-app/pull/18). | [#4](https://github.com/Running-Coach-App/running-coach-app/pull/4), [#7](https://github.com/Running-Coach-App/running-coach-app/pull/7), [#10](https://github.com/Running-Coach-App/running-coach-app/pull/10) |
| @Ezekiel-Gadzama | [#7](https://github.com/Running-Coach-App/running-coach-app/pull/7) research outline and branch-protection screenshot, [#21](https://github.com/Running-Coach-App/running-coach-app/pull/21) value proposition, [#22](https://github.com/Running-Coach-App/running-coach-app/pull/22) meeting script opening; interviewer at the kickoff | [#8](https://github.com/Running-Coach-App/running-coach-app/pull/8); requested changes on [#11](https://github.com/Running-Coach-App/running-coach-app/pull/11) |

## Deviations

1. **The three permission questions were not asked, and we published notes instead of a transcript.**
   We did not ask the `Customer` at the start of the kickoff whether we could record, publish a sanitized transcript, or share it privately with instructors.
   The meeting was recorded on Zoom, which produced an automatic transcript.
   Because publication was never agreed, we committed [meeting-notes.md](meeting-notes.md) rather than the transcript.
   The recording stays out of the repository.
2. **Our direction was not presented at the kickoff.**
   The `Customer` opened by describing the product himself, and the meeting became a question-and-answer session, so our gaps and value propositions were not put to him.
   Action points A2 and A6 in [the meeting report](meeting-report.md#action-points) put them to him at the next meeting, on Tuesday 6 October 2026.
3. **Pull request #1 was merged without an approval.**
   [Pull request #1](https://github.com/Running-Coach-App/running-coach-app/pull/1), the root README, has no review.
   Every pull request merged after it carries an approval from another member.
4. **There is no research board.**
   The alternatives were read from help pages and release notes. We did not install the apps or take the two screenshots per alternative, so there is no view-only board to link.

## Privacy

No private-only material was committed to this repository.
