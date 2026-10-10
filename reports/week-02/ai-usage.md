# AI usage — Week 02

## Tools

Claude Code, driven from a terminal, attached to this repository.

## What we used it for

Reading the course requirements in the `itpd` submodule and converting the Week 1 artifacts to the format those
requirements specify: cutting the `ALT-nn`, `GAP-nn`, and `VP-nn` headings down to their identifiers, writing
their fields as bulleted lists, adding `**Status:**`, and repointing the links that those headings broke.

Writing the two artifacts Week 1 did not have, `docs/decisions.md` and `docs/assumptions.md`, from the kickoff
report and `meeting-notes.md`.

Drafting the product vision, the context diagram source, the Week 2 meeting script, and the story and task issue
bodies. Running the Markdown check and an internal link check locally, and rendering the diagram and the
prototype screenshot. Those story bodies were not opened as issues in that pass. `US-01` to `US-09` were
opened afterwards, and the statements and criteria were checked against the issue form before filing.

## What we did with the output

Kept: the structural conversions, the field ordering, and the two logs.
The decisions log was checked line by line against the `## Decisions` table in
[`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#decisions) — six rows in, six entries out, with
the `Made by` column and each `Why:` written from `meeting-notes.md`.

Rejected: a seventh decision.
The tool proposed logging the pivot to the voice coach as `DEC-007`, but the kickoff report carries that question
as open question 1 and action point A2 rather than as something settled.
We kept it open instead, which is what the report says.

Rejected: marking `GAP-01` and `GAP-03` `Dropped`.
Whether they go is A2's question for the customer, and dropping them before he answers would record a finding we
have not earned.

Owned by the team and not generated: every judgement about priority, which gaps survived the kickoff, the
boundary list, the choice of what to prototype, and every sentence in the meeting script's questions.

## What was not used

No AI output was used as a research finding.
No claim about Runna, Garmin Coach, Hal Higdon, or GoldenCheetah was generated; all of them were read in Week 1
and are cited to their sources in [`docs/research/`](../../docs/research/alternatives.md).

No generated text was submitted unchecked.

The prototype mock was written as HTML by the tool and screenshotted; the content of its three screens is the
team's, and the note at the bottom stating what it does not do was added by us.
