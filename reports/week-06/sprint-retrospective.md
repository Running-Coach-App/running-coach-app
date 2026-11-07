# SPRINT-06 retrospective

The third retrospective of the project. It covers `SPRINT-06`, 1 to 8 November 2026, whose goal was that the product records what it did during a session, so the team can tell how the coach was used and why a run went wrong, without asking the runner.

## What Went Well

| What went well |
| --- |
| The product records itself for the first time. Nine of the ten registered events are emitted from a real session, written to the phone, and read back in a unit test. |
| The recording was built behind a sink interface with a no-op default, so the emissions live in the pure-Kotlin engine `QR-02` already covers, rather than behind an Android class no test can reach. |
| A unit test asserts the privacy rule rather than trusting it: it runs a spoken question through the engine and fails if any recorded field contains a word the runner used. |
| The analytics plan and the observability plan were written against a product that has no backend, and both say so plainly instead of describing a pipeline that does not exist. |
| The course confirmed that this product needs no university virtual machine, which removed four parts' worth of work that could not have been honestly done, and [`DEC-033`](../../docs/decisions.md#dec-033) records the `Customer` agreeing. |
| Every Dependabot upgrade recommended this sprint was built locally against the real toolchain before it was recommended, and one of them overturned advice the team had given twice. |
| `TOS-02` was recorded as missed rather than quietly revised, and the reason is in the goal itself. |

## What Did Not

| Problem | Root cause |
| --- | --- |
| No story completed, for the second sprint running. The sprint planned 27 points and finished none, and four stories have now been carried unaccepted through two sprints. | 19 of the 27 planned points cannot be finished by the team: [the definition of done](../../docs/definition-of-done.md#story) closes a story only on the `Customer`'s acceptance, and he has not installed the product. The team planned those points anyway, as though they were work it controlled. The rule also has no provision for a story whose user is internal, so [`US-12`](https://github.com/Running-Coach-App/running-coach-app/issues/167) stayed open although it was built and its criteria pass on `main`. |
| A finished deliverable was merged into a branch that `main` had already absorbed, so Part 8's two feature entries and five glossary terms never reached `main`, and every check on `main` stayed green while a deliverable was missing from it. | A pull request's base branch is chosen by hand in a dropdown that defaults to the last branch used, and nothing in the repository checks that it points at `main`. [`#182`](https://github.com/Running-Coach-App/running-coach-app/pull/182) targeted `178-record-the-telemetry-adrs`, which [`#181`](https://github.com/Running-Coach-App/running-coach-app/pull/181) had already merged. No check can see this, because the pull request is green and the merge succeeds. |
| The event table and the code disagreed on one event: `spoken_line_dropped` has a row and is not emitted, because the product queues a line that falls due mid-speech rather than dropping it. | The event table was written from the metric tree before the speech queue was read. The metric that needs it was defined before anyone checked that the product could produce it. |

## Actions

| Action | Owner | Impact | Reason | Carried |
| --- | --- | --- | --- | --- |
| Run `mkdocs build --strict` on pull requests as well as on `main` | sirjaey | High | Carried from `SPRINT-05`, `Not done`. It nearly cost the site a third time this sprint: [`#185`](https://github.com/Running-Coach-App/running-coach-app/pull/185) carried a testing-plan link leaving `docs_dir`, passed every check, and was caught only because somebody ran the strict build by hand on a local merge | Yes |
| Plan only the points the team can finish on its own, and leave a story blocked on somebody outside the team unscheduled until the block clears | sirjaey | High | Answers two sprints of zero velocity. A planned velocity of 27 points, 19 of them waiting on an install the team cannot perform, is not a forecast; it is a list of hopes, and it makes the sprint's number say nothing about the team | No |
| Open a task issue in the same change that records a customer decision affecting the code, and link it from the decision | Ezekiel-Gadzama | High | Carried from `SPRINT-04` and `SPRINT-05`, both times `Not done`. Three sprints of customer decisions now sit in meeting reports with nothing in the tracker against them, and `DEC-030` to `DEC-033` have just added four more | Yes |
| Cite an archived copy beside every external vendor URL in the research | ObeTech1 | Medium | Carried from `SPRINT-04` and `SPRINT-05`, both times `Not done`. The research still cites eight live vendor domains with one archived copy between them, so the link check still depends on third parties keeping their URLs | Yes |

Two problems this retrospective records are not answered by an action, because the course's retrospective rule allows four and three of these are carried from earlier sprints that did not do them. Making a pull request's base branch checked rather than chosen, and making `[Unreleased]` a thing a check reads, both go to `SPRINT-07`'s retrospective with this sprint named as where they came from.

## Carried Actions

The four actions in [`SPRINT-05`'s retrospective](../week-05/sprint-retrospective.md#actions) were all marked `Carried: Yes`.

| Action | Outcome |
| --- | --- |
| "Run `mkdocs build --strict` on pull requests as well as on `main`" | Not done. The strict build is still run by hand before a push and by the Pages workflow after a merge, and no pull request runs it. Re-listed in `## Actions`, with the near miss this sprint as its reason. |
| "Move file content between machines as a pushed branch or a `git` patch, never as pasted chat text" | Done. No file content moved by paste this sprint. The one hand-off that needed it was sent as a `git` patch, and the formatting that was stripped twice in `SPRINT-05` survived. |
| "Open a task issue in the same change that records a customer decision affecting the code, and link it from the decision" | Not done, for the third sprint. `DEC-024` to `DEC-026` still have no task issue, and the four decisions this sprint recorded have none either. Re-listed in `## Actions`. |
| "Cite an archived copy beside every external vendor URL in the research" | Not done. The research still carries eight live vendor domains and one archived copy. Re-listed in `## Actions`. |
