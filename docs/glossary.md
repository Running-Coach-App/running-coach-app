# Glossary

The words this project uses in one way only.

## Sessions

### Session

A single run the coach speaks through, from the moment the runner starts it to the moment the runner stops it, holding nothing once it ends.

**Defined by:** [`FR-001`](functional-requirements/fr/FR-001.md).

### Interval session

A session in which the effort changes on a fixed cycle and the coach says the new effort each time it changes.

**Defined by:** [`FR-003`](functional-requirements/fr/FR-003.md).

### Steady session

A session in which the effort never changes, so the coach speaks its stats lines and no effort cue.

**Defined by:** [`FR-003`](functional-requirements/fr/FR-003.md).

## Spoken Output

### Stats line

One spoken line carrying the current session's elapsed time, pace, and distance, spoken on the cadence rather than on request.

**Defined by:** [`FR-002`](functional-requirements/fr/FR-002.md).

### Effort cue

One spoken word naming the effort the runner should now hold, said only at the moment that effort changes.

**Defined by:** [`FR-003`](functional-requirements/fr/FR-003.md).

### Missing stat

A stat the coach would have spoken but does not have, announced once and then left out of later lines until it is available again.

**Defined by:** [`FR-006`](functional-requirements/fr/FR-006.md).

## Controls

### Pocket control

A way of starting, stopping, or asking that a runner can use with the phone in a pocket and the screen off, without seeing it.

**Defined by:** [`QR-03`](quality-requirements/qr/QR-03.md).

## Analytics

### Focus metric

The one number the product's value is read from. Running Coach App's is [weekly completed coached sessions](analytics.md#weekly-completed-coached-sessions).

### Input metric

A number the team can change directly, which moves the focus metric when it moves. Each one sits below the focus metric in the tree.

### Counter-metric

The number that guards the focus metric against being bought with harm. It is watched alongside the focus metric, not optimised.

### Metric tree

The focus metric with its counter-metric and its input metrics nested beneath it, so a reader can see which number a change is supposed to move.

### Event

A named record the product writes when a step of the core task happens, with the fields the event table names.

**Defined by:** [`FR-013`](functional-requirements/fr/FR-013.md), [`docs/analytics.md`](analytics.md#the-events).

### Analytics backend

An external system that would store and query events. This product has none; events stay on the phone.

**Defined by:** [`ADR-005`](architecture/adr/ADR-005.md).

## Operation

### Signal

What the product reports about its own operation: a metric, a log, or a trace. [`docs/observability.md`](observability.md) says which of the three this product emits.

### Telemetry

The events and signals a product reports about itself, taken together. Running Coach App's telemetry never leaves the phone on its own from a release build. A debug build can upload it to the team's campus collector, which [`DEC-031`](decisions.md#dec-031) permits and [`docs/deployment.md`](deployment.md) describes.

### Observability

Being able to tell what the product did, and why, from what it reported, without reproducing the run.

### Service level indicator

A measured quality signal: what is measured, in which unit, over which window, and by which query. Abbreviated `SLI`.

### SLI

See [service level indicator](#service-level-indicator).

### Instrumentation

The code that writes [events](#event) and [signals](#signal) as the session runs.

**Defined by:** [`FR-013`](functional-requirements/fr/FR-013.md), [`FR-014`](functional-requirements/fr/FR-014.md).

### Observability backend

An external system that would store and query signals. This product has none; line records stay on the phone.

**Defined by:** [`ADR-006`](architecture/adr/ADR-006.md).

### Dashboard

A chart view of a metric or an `SLI`. This product has none, because it has no backend; the queries live on the analytics and observability pages.

## Measurement

The three words below are kept apart on purpose. A measure is the thing observed, a statistic is what is computed from several observations of it, and a metric is a number the team watches over time. Using one word for all three is how a quality requirement ends up unfalsifiable.

### Measure

A property of a single observation: what is recorded once, for one participant, one session, or one run. The main task's completion and assistance, the time on task, a `SEQ` answer, and a `SUS` score are each a measure of one session.

**Used by:** [`QR-09`](quality-requirements/qr/QR-09.md), which reads one measure and no others.

### Statistic

A number computed from a set of measures: a count, a proportion, a median, or a mean. A measure belongs to one observation; a statistic belongs to a set of them. `QR-09`'s criterion is a statistic — the proportion of counted participants whose main-task outcome was `Unaided` — of the measure it reads.

### Metric

A number the team watches over time to tell whether the product is doing its job, computed from [events](#event) by a named query. [The analytics page](analytics.md) holds this product's metric tree. A metric is not a measure: it is about the product's use in aggregate, not about one observation, and no metric is computed from usability-test traffic.

## Usability Testing

### Usability test

A planned check of whether a representative person outside the team can reach a goal in the product without help, which is the evidence the product's own [telemetry](#telemetry) cannot supply: the records say what the product did, never whether somebody understood it. A test is cited as `UT-nn`, and its record is the file a stranger runs it from.

**Defined by:** [`docs/usability-tests/README.md`](usability-tests/README.md). This project's first is [`UT-01`](usability-tests/ut-01/README.md).

### Participant

A person outside the team who attempts a usability test's tasks: 18 or older, matching the test's participant profile, and not a teammate, the `Customer`, an instructor, or course staff. A participant is known by a code — `P-01`, `P-02`, and so on, local to its test and never reused — and nothing in this repository joins a code to a person.

### Usability session

One participant's run of a test's tasks, from the welcome to the debrief. A session is **counted** when it has the required consent, was recorded, matched the profile, and ran to the end of its data; a dry run, a withdrawn session, and one stopped early are not counted, and a code that was not counted is retired.

### Consent

A participant's recorded agreement, given before their session in a durable form the team can show the instructors, covering their 18-or-older declaration, the recording, the sanitized public results, the optional anonymized quote, where the private material is kept, who can see it, the tools used, the right to withdraw, and deletion after grading. Consent to the recording and to the sanitized public results is required for a session to count; consent to a quote is optional and separate.

**Defined by:** [`consent.md`](usability-tests/ut-01/consent.md).

### Recording

The private audio record of a usability session: what the participant said and what the coach said. It is required for a session to count, it lives in the team's cloud recordings folder and never in this repository or in the private text repository, and it is deleted after the course is graded.

### SUS

The System Usability Scale: ten standard items in a standard order, each answered from strongly disagree (1) to strongly agree (5), asked once after all of a session's tasks. Its score is `2.5 × (20 + sum(odd) - sum(even))`, computed from the answers as recorded, and it runs from 0 to 100 without being a percentage. It is reported with its mean, its median, and `n=<count>`, because a sample of three to five supports no claim about a population.

**Defined by:** [`surveys.md`](usability-tests/ut-01/surveys.md#sus-after-all-the-tasks).

### SEQ

The Single Ease Question: one standard question asked immediately after each task — "Overall, how difficult or easy was the task to complete?" — on a seven-point scale where 1 is very difficult and 7 is very easy, so a higher answer means an easier task. One SEQ per task, not one per session.

**Defined by:** [`surveys.md`](usability-tests/ut-01/surveys.md#seq-after-each-task).

## Configuration

### Configuration

Everything that decides how this project is built, checked, released, and deployed, and that is not the product's own source code: the workflows, the pins, the repository settings, the deployment scripts, and the instructions an agent reads. The product is what the configuration produces.

**Defined by:** [`docs/configuration-plan.md`](configuration-plan.md).

### Configuration management

Keeping that set known and deliberate: knowing what each item is, who keeps it true, what it connects to, and what breaks without it. It is not the same as changing it — an inventory that matches the repository is the whole job most weeks.

### Configuration item

One thing in the configuration, recorded as `CFG-nn` with its status, type, purpose, owner, location, connections, and what good looks like. A set of files is one item at its index or entry point, so the nine workflow files are one item rather than nine.

**Defined by:** [`docs/configuration-plan.md`](configuration-plan.md).

### Configuration plan

The maintained inventory of the configuration items, carrying its own `**Reviewed:**` date, and updated in the same pull request as any change that alters what it records. It documents the configuration as it is; a plan that describes an older repository is a defect, not merely out of date.

**Defined by:** [`docs/configuration-plan.md`](configuration-plan.md).

### Configuration review

The act of reading the configuration against the repository and judging it. It produces the evaluation; it is not itself a document.

### Configuration evaluation

The written judgement a review produces, organised by local goal rather than by item: what achieves each goal today, a more convenient way, why the goal is still achieved, and what the change gives up. It ends with the one change the team would make first.

**Defined by:** `reports/week-08/cm-evaluation.md`.

### Baseline

The exact commit or tag a judgement was made against, named so the judgement can be repeated or disputed. Without one, a review describes a repository that no longer exists and nobody can tell which.

### Upkeep

Work that keeps an existing artifact true rather than adding anything: correcting a version a document names, bringing a branch up to date, recording a decision already taken. A task issue for upkeep says `None: repository upkeep` in its requirements, because it serves no functional requirement.

### Reproducible build

A build that produces the same artifact from the same source on a different machine and on a later day, because every input that could vary is pinned. This project pins the Gradle version and locks the dependency versions; it does not yet pin the published artifact's identity, which is why the release carries a debug build.

**Defined by:** [`CFG-08`](configuration-plan.md#cfg-08).

### Dependency pinning

Recording the exact version of every dependency rather than a range, so that resolving them again gives the same answer. Here it is the lockfile, and the pin and the tool version move together in one change: reverting one without the other leaves the two disagreeing.

**Defined by:** [`CFG-08`](configuration-plan.md#cfg-08).

### Secret

A value that grants access and must never enter version control: a deployment key, a signing credential, a collector address on a private network. A secret is named in words in public documents and lives in the repository's secret settings or in an untracked file.

**Defined by:** [`CFG-06`](configuration-plan.md#cfg-06) and [`CFG-07`](configuration-plan.md#cfg-07).

### Context window

The amount of text a coding agent can hold at once. It matters to configuration because it is finite: an agent cannot read the whole repository, so what it is pointed at first decides what it knows, and an instruction split across a committed file and an untracked one may reach it only in part.

### Agent instruction

A file written for a coding agent rather than a person, telling it this repository's conventions before it edits anything. Here the committed one is [`AGENTS.md`](https://github.com/Running-Coach-App/running-coach-app/blob/main/AGENTS.md), with per-tool files routing to it.

**Defined by:** [`CFG-10`](configuration-plan.md#cfg-10).
