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
