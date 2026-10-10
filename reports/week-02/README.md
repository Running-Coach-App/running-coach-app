# Week 02 report

## Project

Running Coach App, team 4.

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal).

## Summary

We were wrong that fixed spoken cues are enough for the first release. On 9 October 2026 the `Customer` answered in writing: [GAP-01](../../docs/research/gap-analysis.md#gap-01) and [GAP-03](../../docs/research/gap-analysis.md#gap-03) can go, and the coach must read the available stats aloud and answer simple verbal queries. [ASM-08](../../docs/assumptions.md#asm-08) is `Refuted`.

What is still open is whether the two presets still follow the coach, whether professional runners are in scope later, and whether a wearable can be reached in the ten weeks. Those are in [the meeting report](meeting-report.md#open-questions).

## Coverage

| Deliverable | Artifact |
| --- | --- |
| Kickoff action points | [reports/week-02/meeting-report.md#previous-action-points](meeting-report.md#previous-action-points) |
| Kickoff open questions | [reports/week-02/meeting-report.md#previous-open-questions](meeting-report.md#previous-open-questions) |
| Product vision | [docs/product-vision.md](../../docs/product-vision.md) |
| System context diagram | [docs/architecture/context.svg](../../docs/architecture/context.svg), [docs/architecture/context.mmd](../../docs/architecture/context.mmd), embedded in [docs/product-vision.md#context](../../docs/product-vision.md#context) |
| Assumptions | [docs/assumptions.md](../../docs/assumptions.md) |
| Decisions | [docs/decisions.md](../../docs/decisions.md) |
| Story issues | [Story issues](https://github.com/Running-Coach-App/running-coach-app/issues?q=label%3Auser-story) |
| Issue forms | [.github/ISSUE_TEMPLATE/user-story.yml](../../.github/ISSUE_TEMPLATE/user-story.yml), [.github/ISSUE_TEMPLATE/task.yml](../../.github/ISSUE_TEMPLATE/task.yml), [.github/ISSUE_TEMPLATE/config.yml](../../.github/ISSUE_TEMPLATE/config.yml) |
| Labels | [Repository labels](https://github.com/Running-Coach-App/running-coach-app/labels): `user-story`, `task`, `moscow:must`, `moscow:should`, `moscow:could`, `moscow:won't` |
| Pull request template | [.github/pull_request_template.md](../../.github/pull_request_template.md) |
| Prototypes | [reports/week-02/prototypes.md](prototypes.md) |
| Meeting script | [reports/week-02/meeting-script.md](meeting-script.md) |
| Customer validation | [reports/week-02/meeting-report.md](meeting-report.md), [reports/week-02/meeting-transcript.md](meeting-transcript.md) |
| AI usage | [reports/week-02/ai-usage.md](ai-usage.md) |

## Minimum Usable Product Candidate

Core task: the runner puts the phone in a pocket, starts a session, and hears what to do and how the run is going until they stop.

The `Must Have` stories that complete that task are [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37), [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38), [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39), and [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40). [US-06](https://github.com/Running-Coach-App/running-coach-app/issues/42), the two presets in [VP-02](../../docs/research/value-proposition.md#vp-02), is `Should Have` and is not in the candidate.

Customer's verdict: not given. The presets were not addressed, so confirmation waits for a written reply, per [the meeting report](meeting-report.md#open-questions).

## What changed

The spoken-cue prototype was wrong about fixed cues: [ASM-08](../../docs/assumptions.md#asm-08) is `Refuted` and the first release must also answer simple verbal stats queries, per [DEC-008](../../docs/decisions.md#dec-008), and [GAP-01](../../docs/research/gap-analysis.md#gap-01) and [GAP-03](../../docs/research/gap-analysis.md#gap-03) are `Dropped`, per [DEC-007](../../docs/decisions.md#dec-007).

## Contribution

| Member | Work |
| --- | --- |
| @sirjaey | [#25](https://github.com/Running-Coach-App/running-coach-app/pull/25) context diagram, [#27](https://github.com/Running-Coach-App/running-coach-app/pull/27) AI usage (closed [#26](https://github.com/Running-Coach-App/running-coach-app/issues/26)), [#29](https://github.com/Running-Coach-App/running-coach-app/pull/29) validation outcome (closed [#28](https://github.com/Running-Coach-App/running-coach-app/issues/28)), [#33](https://github.com/Running-Coach-App/running-coach-app/pull/33) transcript (closed [#32](https://github.com/Running-Coach-App/running-coach-app/issues/32)); approved [#30](https://github.com/Running-Coach-App/running-coach-app/pull/30) |
| @JustACommonMan-OSDD | [#30](https://github.com/Running-Coach-App/running-coach-app/pull/30) prototype record, [#35](https://github.com/Running-Coach-App/running-coach-app/pull/35) meeting script; approved [#25](https://github.com/Running-Coach-App/running-coach-app/pull/25), [#27](https://github.com/Running-Coach-App/running-coach-app/pull/27), [#29](https://github.com/Running-Coach-App/running-coach-app/pull/29), [#31](https://github.com/Running-Coach-App/running-coach-app/pull/31) |
| @ObeTech1 | [#31](https://github.com/Running-Coach-App/running-coach-app/pull/31) meeting report; approved [#33](https://github.com/Running-Coach-App/running-coach-app/pull/33) |
| @Ezekiel-Gadzama | approved [#35](https://github.com/Running-Coach-App/running-coach-app/pull/35); opened [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) through [US-09](https://github.com/Running-Coach-App/running-coach-app/issues/45) |

## Repository evidence

Merged pull request that closed its task issue: [pull request #33](https://github.com/Running-Coach-App/running-coach-app/pull/33), which closed [issue #32](https://github.com/Running-Coach-App/running-coach-app/issues/32).

Latest green link check on `main`, commit `6fdfae9`: [run 38052455710](https://github.com/Running-Coach-App/running-coach-app/actions/runs/38052455710).

Latest green Markdown check on `main`, same commit: [run 38052455697](https://github.com/Running-Coach-App/running-coach-app/actions/runs/38052455697).

The links excluded in [`.lycheeignore`](../../.lycheeignore) are the five Week 1 links already justified in [the Week 1 report](../week-01/README.md#repository-evidence); none were added this week.

## Deviations

1. **The validation meeting was held in writing.**
   The `Customer` agreed to skip the live meeting. The message and the reply are [the transcript](meeting-transcript.md). There is no recording.
2. **The meeting script reached `main` after the exchange.**
   The exchange was on 9 October 2026. [Pull request #35](https://github.com/Running-Coach-App/running-coach-app/pull/35) merged the script on 10 October 2026. The script is the plan that was sent, and it is not rewritten after the meeting.
3. **The three permission questions were not asked separately.**
   The message said a text reply or a voice note would stand as the meeting note. It did not ask, one by one, to record, to publish a sanitized transcript, and to share it privately if publication was refused. The transcript was published. The meeting report's "not refused" is not an answer to each question.
4. **Merged branch names are not task numbers.**
   The rule is `<task-number>-<short-description>`. Pull requests #25 to #36 use personal branch names and `*-patch-N`.

## Privacy

No private-only material was committed to this repository.
