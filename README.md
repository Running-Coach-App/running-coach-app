# Running Coach App

**Team 4**, ITPD course, Innopolis University, autumn 2026.

A running coach for recreational runners training for 5K to half-marathon races, with a plan that adapts to the runs they actually did and explains why it changed.

> [!NOTE]
> This project is a work in progress for the ITPD course.
> How to build and run the Android app is in [the setup page](docs/setup.md).

## Where to start

- Setup and run: [docs/setup.md](docs/setup.md)
- Current week's report: [reports/week-06/README.md](reports/week-06/README.md)
- Maintained documentation: [docs/](docs/)
  - [Alternatives](docs/research/alternatives.md)
  - [Comparison](docs/research/comparison.md)
  - [Gap analysis](docs/research/gap-analysis.md)
  - [Value proposition](docs/research/value-proposition.md)
  - [Play Store quality](docs/research/play-store-quality.md)

## Check it yourself

This app keeps every run on your phone and sends nothing anywhere. You do not have to take
our word for it. From a clean checkout:

```sh
./scripts/scan.sh
```

It needs `bash`, `curl`, and `python3`, and no Android toolchain. It reports whether the app
declares any permission that would let it reach the network, whether any of its code
references a networking type, whether any dependency it ships has a known vulnerability, and
whether anything resembling a credential has been committed. It exits non-zero if any of
those checks fails, and it runs on every pull request.

The requirement behind it is [`QR-08`](docs/quality-requirements/qr/QR-08.md), and the
research behind what it checks is [`docs/research/play-store-quality.md`](docs/research/play-store-quality.md).

## Documentation site

[https://running-coach-app.github.io/running-coach-app/](https://running-coach-app.github.io/running-coach-app/)

## Licence

[MIT](LICENSE)
