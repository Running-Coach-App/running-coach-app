# Week 03 report

## Project

Running Coach App, team 4.

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal). The bar for it is [the threshold of success](../../docs/threshold-of-success.md).

## Summary

The Week 3 validation meeting was held live on Zoom on 2026-10-17. No working binary was shown. The `Customer` affirmed the intended pocket-coach behaviours for [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) through [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) from description, with refinements recorded as [DEC-010](../../docs/decisions.md#dec-010) through [DEC-016](../../docs/decisions.md#dec-016). `REL-03` is still not cut.

## Customer meeting

- Script: [meeting-script.md](meeting-script.md)
- Report: [meeting-report.md](meeting-report.md)
- Transcript: [meeting-transcript.md](meeting-transcript.md)

## Coverage

| Deliverable | Artifact |
| --- | --- |
| Threshold of success | [docs/threshold-of-success.md](../../docs/threshold-of-success.md) |
| Customer validation | [meeting-report.md](meeting-report.md), [meeting-transcript.md](meeting-transcript.md) |
| Meeting script | [meeting-script.md](meeting-script.md) |
| Week 3 decisions | [DEC-010](../../docs/decisions.md#dec-010) through [DEC-016](../../docs/decisions.md#dec-016) |
| AI usage | [ai-usage.md](ai-usage.md) when present |

## Deviations

1. **No working app was demonstrated.**
   The meeting corrected direction from description only. Device acceptance of the slice still waits on an installable build.
2. **The three scripted permission questions were not asked one by one.**
   The `Customer` offered the transcript and the recording himself, so publication was taken as permitted. That shortcut is recorded here.
3. **Professional runners, wearable value, and the two-presets order were not asked.**
   They remain open for the next validation.
4. **`REL-03` is not cut.**
   The release tag still waits on a merged usable slice on `main`.

## Privacy

The Zoom passcode is not in this repository. The recording file is not committed. The sanitized transcript is [meeting-transcript.md](meeting-transcript.md).
