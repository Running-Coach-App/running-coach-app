# SPRINT-04 retrospective

The first retrospective of the project. It covers `SPRINT-04`, 18 to 24 October 2026, whose goal was to give the Week 3 slice a repeatable build, tests, and an architecture the next increment can extend.

## What Went Well

| What went well |
| --- |
| `SPRINT-03` closed 17 of its 19 issues, and `REL-03` was tagged as `v0.1.0` on `main`. |
| The Week 3 validation meeting was held live on Zoom, was recorded with permission, and produced seven decisions, `DEC-010` to `DEC-016`, with a published transcript. |
| The public GitHub project was created, made public, and linked from `CONTRIBUTING.md`, which closed the Week 3 deviation that had no project to point at. |
| The documentation site publishes from `main`, and the Markdown check and the link check run on every pull request. |
| The requirements and the architecture were written as one change, so no intermediate state left a dangling link between a requirement, a record, and the container view. |
| Writing the functional requirements found three customer decisions the code had never implemented, and all three were fixed and covered by unit tests in the same sprint. |
| `v0.1.0` was built from a clean checkout on a machine with no toolchain, installed on a phone, and run end to end outdoors, which is the first time the slice has been seen working outside a test. |

## What Did Not

| Problem | Root cause |
| --- | --- |
| Three customer decisions describe behaviour the build does not have: the three-minute cadence of `DEC-013`, the focus-on-running reply of `DEC-012`, and the announce-once rule of `DEC-011`. | A decision was recorded in `docs/decisions.md` without a task issue being opened against the code in the same change, so nothing connected the decision to the work, and the divergence only surfaced when the functional requirements were written a week later. |
| The six sprint milestone due dates were each a day early, and `docs/project-plan.md` disagreed with GitHub for four days. | The dates were entered by hand in two places with no check that compared them, and GitHub shifts a due date entered at midnight back by a day, which nobody had noticed. |
| The link check has been failing on `main` on a dead third-party URL, and it blocks every pull request regardless of what that pull request changed. At the same time it passed a report that linked three files which do not exist on `main`. | The research cites live vendor pages with no archived copy, so the checks depend on third parties keeping their URLs; and the check never verified relative file links at all, so it was loud about the thing we could not control and silent about the thing we could. |

## Actions

| Action | Owner | Impact | Reason | Carried |
| --- | --- | --- | --- | --- |
| Open a task issue in the same change that records a customer decision affecting the code, and link it from the decision | Ezekiel-Gadzama | High | Answers the root cause of the three decisions that never reached the build | Yes |
| Add a check that compares each sprint's `Due:` field in `docs/project-plan.md` against its GitHub milestone, and run it in the Markdown workflow | sirjaey | Medium | Answers the hand-entered dates that disagreed for four days | Yes |
| Cite an archived copy beside every external vendor URL in the research, starting with the dead Garmin page | ObeTech1 | Medium | Answers the link check failing for a reason outside the change that triggered it | Yes |
| Make the link check verify relative file links, so a report cannot link a file that is not on `main` | sirjaey | Medium | Answers the half of the same root cause the check was silent about | Yes |
| Add a workflow that runs `gradle :app:testDebugUnitTest` and `gradle :app:assembleDebug` on pull requests and on `main` | sirjaey | High | No check covers the product code, so a Kotlin regression reaches `main` unseen | Yes |

## Carried Actions

There is no previous retrospective. `SPRINT-04` is the first sprint that ends in one, so nothing is carried into this file; the four actions above are carried into `SPRINT-05`'s retrospective.
