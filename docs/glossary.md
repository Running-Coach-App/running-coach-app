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

The events and signals a product reports about itself, taken together. Running Coach App's telemetry never leaves the phone on its own.

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
