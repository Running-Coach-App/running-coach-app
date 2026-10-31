# Assumptions

## ASM-01

The first audience is beginner to intermediate, and marathon runners are out of the first release.

- **Status:** Confirmed
- **How to check:** ask the `Customer` who the first release is for.
- **Outcome:** he named beginner to intermediate and said marathon runners may have requirements he does not know, per [`DEC-001`](decisions.md#dec-001), in [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions).

## ASM-02

The product works from the phone alone, and a wearable only adds signals such as heart rate.

- **Status:** Confirmed
- **How to check:** ask the `Customer` whether a watch is required.
- **Outcome:** phone-only is the baseline and a wearable is worth exploring rather than required, per [`DEC-002`](decisions.md#dec-002), in [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions).

## ASM-03

Runners will not upload medical documents or type extra health data in.

- **Status:** Confirmed
- **How to check:** ask the `Customer` whether users will upload health or medical documents.
- **Outcome:** they will not — users are either too lazy or treat it as a security problem — so there is no perceived-effort step in the first release, per [`DEC-003`](decisions.md#dec-003), in [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions).

## ASM-04

Processing stays on the phone where possible.

- **Status:** Confirmed
- **How to check:** ask the `Customer` whether the run may be sent to a server.
- **Outcome:** he would rather it were processed on the phone, per [`DEC-004`](decisions.md#dec-004), in [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions).

## ASM-05

Sharing stats with a friend is out of scope for these ten weeks.

- **Status:** Confirmed
- **How to check:** propose live sharing with a running partner and see whether it is accepted.
- **Outcome:** refused on effort grounds and left open as a later paid tier, per [`DEC-005`](decisions.md#dec-005), in [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions).

## ASM-06

The first release is Android and English.

- **Status:** Confirmed
- **How to check:** ask the `Customer` which platform and language the first version should use.
- **Outcome:** Android, not iOS, because he has no iOS device to test, and English, per [`DEC-006`](decisions.md#dec-006), in [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#decisions).

## ASM-07

The base product is the in-run voice coach, and a preset session comes only after it.

- **Status:** Confirmed
- **How to check:** ask the `Customer` at the Week 2 validation meeting whether an adaptive training plan is wanted at all, per action point A2 in [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#action-points).
- **Outcome:** no adaptive plan is wanted: the in-run coach is the whole product, per [`DEC-007`](decisions.md#dec-007) and [`DEC-008`](decisions.md#dec-008), in [the Week 2 validation exchange](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-02/meeting-report.md#decisions).
- **Still open:** whether the two presets still follow the coach, which awaits the candidate verdict in [the Week 2 report](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-02/README.md#minimum-usable-product-candidate).

## ASM-08

Fixed spoken cues are acceptable for the first release, and a conversational coach is not required to ship.

- **Status:** Refuted
- **How to check:** ask the `Customer` directly at the Week 2 validation meeting, per action point A4 in [the kickoff meeting](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#action-points).
- **Outcome:** fixed cues alone are not enough: the first release must also answer simple verbal stats queries, per [`DEC-008`](decisions.md#dec-008), in [the Week 2 validation exchange](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-02/meeting-report.md#decisions).

## ASM-09

A small on-device model (Gemma, as the `Customer` suggested) can answer simple spoken stats queries within the ten weeks.

- **Status:** Open
- **How to check:** complete the on-device text-to-speech and small-model feasibility spike in Week 3, per [the Week 2 action points](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-02/meeting-report.md#action-points), and record its findings in the [on-device feasibility assessment](research/on-device-feasibility.md).
- **Note:** Week 3 preferred trying an on-device model first with keywords as backup ([DEC-016](decisions.md#dec-016)); feasibility on a device is still unproven.

## ASM-10

Android `SpeechRecognizer.createSpeechRecognizer` may send spoken audio off the device.

- **Status:** Open
- **How to check:** read whether the platform recogniser used in `CoachService.kt` is on-device or a network service, then ask the `Customer` whether that is acceptable under [`DEC-004`](decisions.md#dec-004).
- **Note:** [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) answers spoken questions through that recogniser. If audio leaves the phone, the "on the phone" constraint is weaker than the story currently assumes. The Week 5 meeting did not ask this.
