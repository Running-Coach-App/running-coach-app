# Quality requirements

The priority matrix for the product's quality requirements. Each row finds its requirement; the requirement's file carries its scenario.

The rows are sorted active first, then by business importance from `High` to `Low`, then by technical risk from `High` to `Low`, with `QR-nn` order breaking a tie.

What each test last found is in [the quality requirement testing plan](../project-plan.md#quality-requirement-testing-plan).

| QR | Outcome | Business importance | Technical risk | Characteristic | Sub-characteristic | Status |
| --- | --- | --- | --- | --- | --- | --- |
| [QR-01](qr/QR-01.md) | A stats line that falls due during a session starts playing within two seconds of the moment it is due. | High | Medium | Performance Efficiency | Time Behaviour | Active |
| [QR-02](qr/QR-02.md) | A developer can run the checks that cover the coach's spoken decisions from a clean checkout, and a change that breaks one of those decisions fails them. | High | Medium | Maintainability | Testability | Active |
| [QR-03](qr/QR-03.md) | A runner starts a session, hears it through, and stops it without taking the phone out or looking at the screen. | Medium | High | Interaction Capability | Operability | Active |
| [QR-04](qr/QR-04.md) | A session keeps speaking the stats it still has when the phone loses its location fix, instead of stopping or going silent. | Medium | Low | Reliability | Fault Tolerance | Active |
