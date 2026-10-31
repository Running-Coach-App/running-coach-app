# AI usage — Week 05

## Tools

Claude Code, driven from a terminal, attached to this repository.

## What we used it for

Reading Assignment 5 at the commit the `Customer` pinned, and the requirement files it points at, and auditing the repository against its checklist line by line.

Planning `SPRINT-05`: rewriting the sprint's goal, adding the two plan milestones the week asks for, and writing the sprint backlog link.

Drafting `reports/week-05/meeting-script.md`.

Writing the quality requirement tests inside `QR-01` and `QR-02`, the quality requirement testing plan in `docs/project-plan.md`, `docs/features.md`, and the `actionlint` workflow.

Fixing four tracker defects found in the audit.

## What we did with the output

Kept: the structure of every file, written against the course rule for that artifact and checked field by field against it.

Corrected: the first draft of the `actionlint` workflow pinned a Docker action by a `sha256` digest that was invented rather than looked up, and would have failed on the first run. It was replaced with a download of a pinned actionlint release, and the release asset was fetched to confirm it exists before the workflow was committed.

Corrected: the meeting script used asterisks for emphasis where this repository's Markdown check requires underscores. The check caught it, and the fix is its own commit because the first push had already gone out.

Found rather than generated: the audit turned up four things nobody had noticed. `US-01` had been retyped from `User Story` to `Feature`, which dropped it out of the story registry. The `SPRINT-03` and `SPRINT-04` milestones were still open with one straggler each, where the rule closes a sprint's milestone once its release is cut. The `SPRINT-05` goal in the plan still described Week 4's ambition. The plan carried one milestone where the week needs at least two more.

Owned by the team and not generated: the decisions the `Customer` made, the product code, and the judgement about what the next increment is for.

Still to be confirmed by the team: the two milestones' increments, the sprint's planned velocity, and the story points behind it.

## What was not used

No AI output was used as a research finding, and no claim about an alternative was generated this week.

No generated text was submitted unchecked. The Markdown check and a link-and-anchor check were run before each pull request, and the one fabricated value that reached a file was caught by checking it against the source rather than by reading it again.
