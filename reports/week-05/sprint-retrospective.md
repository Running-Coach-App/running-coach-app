# SPRINT-05 retrospective

The second retrospective of the project. It covers `SPRINT-05`, 25 to 31 October 2026, whose goal was that somebody outside the team can obtain the product, install it, and finish a pocket session, and that the checks which say it works run without being asked.

## What Went Well

| What went well |
| --- |
| `REL-05` was cut as `v0.3.0` on a commit where all five workflows are green, and the release carries a customer-facing note rather than a second changelog. |
| Both High business-importance quality requirements gained a test and were run: `QR-01` and `QR-02` each read `Passes` with evidence in the testing plan. |
| `QR-02` was proved rather than assumed. A deliberate change to `SessionEngine.start` was made to confirm the suite fails on a broken decision, and the source was restored and all 18 tests rerun. |
| The debug build is published from every run, so a build no longer exists only on the machine that made it. Before this, every APK anyone had installed came off one laptop. |
| `actionlint` now checks the workflows themselves, which the repository had been changing without any check at all. |
| The story registry became real: all nine stories carry a `MoSCoW` value and seven carry `Story Points`, five are scheduled into the sprint, the planned velocity is computed, and the six labels that had been the only record of priority were retired. |
| The history screen, which had shipped in `SPRINT-04` owned by nothing, gained a story, a functional requirement, and a feature entry. |
| The Week 5 meeting produced seven decisions, `DEC-023` to `DEC-029`, including two where the `Customer` overruled the team's position and the record says so. |

## What Did Not

| Problem | Root cause |
| --- | --- |
| The documentation site was broken on `main` for three consecutive pushes, so the published site did not carry the Week 5 material during the week it was written. | `mkdocs build --strict` runs only on pushes to `main`, never on pull requests, so a link that leaves `docs_dir` merges green and fails afterwards. The Markdown check and the link check both pass on such a link, because the file really is at that path. This is the same failure `SPRINT-04` fixed once already. |
| Two documentation files reached `main` with every code span stripped and a non-breaking space in two list markers, and the damage reached lines neither pull request set out to touch. | File content was moved between machines as pasted chat text. Stripped backticks are still valid Markdown, so no repository check can see the loss, and the paste silently rewrote whatever it touched. |
| The `Customer` still has not installed the product, so no story was validated on his own phone and `US-02` was accepted from screenshots alone. `US-05` was closed during the sprint without being shown to him at all. | The install has depended on him since Week 4 and nothing in the sprint reduced that dependency: there was no build anyone could download until the sprint's last day, and the team closed a story on its own judgement rather than on the acceptance the definition of done requires. |

## Actions

| Action | Owner | Impact | Reason | Carried |
| --- | --- | --- | --- | --- |
| Run `mkdocs build --strict` on pull requests as well as on `main` | sirjaey | High | Answers the site break: the only check that sees a cross-directory link runs after the merge rather than before it, and it has now cost the site twice | Yes |
| Move file content between machines as a pushed branch or a `git` patch, never as pasted chat text | ObeTech1 | High | Answers the stripped code spans: no repository check can see formatting lost in a paste, so the transfer has to be one that cannot lose it | Yes |
| Open a task issue in the same change that records a customer decision affecting the code, and link it from the decision | Ezekiel-Gadzama | High | Carried from `SPRINT-04` unchanged. `DEC-024` to `DEC-026` were recorded this sprint with no task issue against the code, which is the same gap the action was written for | Yes |
| Cite an archived copy beside every external vendor URL in the research | ObeTech1 | Medium | Carried from `SPRINT-04`. The research still cites eight live vendor domains with one archived copy between them, so the link check still depends on third parties keeping their URLs | Yes |

## Carried Actions

The four actions in [`SPRINT-04`'s retrospective](../week-04/sprint-retrospective.md#actions) were all marked `Carried: Yes`.

| Action | Outcome |
| --- | --- |
| "Open a task issue in the same change that records a customer decision affecting the code, and link it from the decision" | Not done. `DEC-023` to `DEC-029` were recorded without a task issue against the code; the work sits in the meeting report's action points instead. Re-listed in `## Actions`. |
| "Add a check that compares each sprint's `Due:` field in `docs/project-plan.md` against its GitHub milestone, and run it in the Markdown workflow" | Dropped. The dates were corrected in `SPRINT-04` and have not drifted since, and no sprint date changed this sprint. The check is worth less than the two checks this retrospective asks for instead, and the problem it answered is no longer live. |
| "Cite an archived copy beside every external vendor URL in the research, and read the failing job's own log before explaining why a check is red" | Not done. The second half held: every red check this sprint was explained from its own log. The first half did not: the research still carries eight live vendor domains and one archived copy. Re-listed in `## Actions`, narrowed to the half that is outstanding. |
| "Add a workflow that runs `gradle :app:testDebugUnitTest` and `gradle :app:assembleDebug` on pull requests and on `main`" | Done. The Android build workflow runs both on every pull request and on `main`, and it is what `QR-02`'s test is implemented as. |
