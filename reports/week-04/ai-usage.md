# AI usage — Week 04

## Tools

Claude Code, driven from a terminal, attached to this repository.

## What we used it for

Reading Assignment 4 and the course requirement files it points at, at the commit the assignment was published on, and checking the repository against them.

Drafting this week's documentation set: the four quality requirements and their priority matrix, the six functional requirements and their index, the four architectural decision records and the template, the architecture document with its drivers, container view, and record index, `docs/glossary.md`, and the team's root `AGENTS.md`.

Writing the container diagram's Mermaid source and rendering it to the committed image.

Moving the six sprint due dates to the Saturdays Assignment 4 sets, in the plan and in the GitHub milestones.

Changing `SessionEngine.kt` so the spoken coach matches `DEC-011`, `DEC-012`, and `DEC-013`, and extending the unit tests to cover each.

Setting up a build toolchain on a machine that had none: a JDK 17, Gradle 8.11.1, the missing SDK platform, and the command-line tools. Building the debug APK, installing it on a phone, and launching it.

Drafting `reports/week-04/meeting-script.md`, this report, the sprint retrospective, and the scaffolds for the meeting report and transcript.

## What we did with the output

Kept: the structure of every file, written against the course rule for that artifact and checked field by field against it. The unit tests pass: `gradle :app:testDebugUnitTest`, 10 tests, 0 failures.

Corrected: the first draft of `QR-03` and `FR-001` cited `CON-02` as the constraint that makes the phone the baseline. `CON-02` is the language constraint and `CON-04` is the right one. We found it by opening the vision rather than by trusting the citation.

Discarded: the first run of a link-checking script reported fifteen broken anchors across the Week 2 and Week 3 reports. They were false, caused by the script not stripping a carriage return before matching a heading. Nothing was edited on the strength of that report; the script was fixed and re-run, and the real count is zero.

Rejected: the proposal to list the documentation site as a second container so the container view would show two. No functional requirement names the site, and the rule says a container that none names is not part of the product. The view states one container and `ADR-001` records the split we turned down.

Reversed: the tool first concluded that the off-topic reply was a new customer request needing a new decision, and wrote that into a pull request. It was already `DEC-012`, from the Week 3 meeting, and the transcript carries the quote at 09:47 — "Let's have some fun for this one." The pull request was corrected. What had gone wrong is that `DEC-012` recorded the "stay polite" half of the quote and not the "have some fun" half, so the decision log had lost it.

Reversed: the tool wrote a meeting-script question that told the `Customer` he had just heard a session start and stop with the phone in a pocket. That is not true — the volume keys are read by the activity, so they need the screen awake. We believed it twice, once from a misreading of the code and once from a team member's recollection, and settled it by watching the app's media session state through `dumpsys` while the keys were pressed: it never moved. The question was rewritten to claim only what the build does.

Owned by the team and not generated: the decisions the `Customer` made, the code already on `main` at the start of the week, and the choice of which four qualities this product is willing to be judged on.

Still to be confirmed by the team: the business importance and technical risk ratings in the priority matrix, and the judgements in the sprint retrospective.

## What was not used

No AI output was used as a research finding, and no claim about Runna, Garmin Coach, Hal Higdon, or GoldenCheetah was generated this week.

No generated text was submitted unchecked. Every requirement, record, and index was read against the course rule it answers, the Markdown check and a link check were run before each pull request, and the engine change was run as a unit test suite rather than reasoned about.

The two reversals above are in this report on purpose. Both were cases where generated output was confident and wrong, and in both the thing that caught it was a check against the repository or the device rather than a second opinion from the tool.
