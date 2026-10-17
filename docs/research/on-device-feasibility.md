# On-Device Feasibility

## Verdict

Android platform text-to-speech fits the minimum usable product for speaking fixed cues, run statistics, and a short answer to a spoken query. The Android `TextToSpeech` API synthesizes text for immediate playback, but the app must wait for engine initialization and verify that an English voice is available. The API does not by itself guarantee that every installed voice works offline, so the chosen engine and voice must be checked on the target phone.

Gemma is a plausible on-device candidate, but its suitability for this app is not yet demonstrated. Google documents Gemma 3n as designed for everyday devices and documents an Android deployment path through MediaPipe LLM Inference. Those documents establish that mobile deployment is supported; they do not establish response latency, memory use, battery cost, or answer quality on the team's target phone. The ten-week schedule is feasible only if a small-model spike confirms those constraints early. Keep a phrase-matching fallback for the limited time, pace, and distance questions if Gemma does not pass that check.

## Findings

- **Platform text-to-speech:** Android's `TextToSpeech` API can synthesize application text for playback. This covers fixed coaching cues and spoken statistic responses without requiring a generative model. Test initialization, English voice availability, interruptions, and offline behavior on the device selected for the demonstration.
- **Gemma:** Google's model overview describes Gemma 3n as optimized for everyday devices, and its mobile deployment guide lists Android support through MediaPipe LLM Inference. This makes Gemma worth testing for simple query responses. The guides do not report performance for this app's prompts or the team's hardware.
- **Project decision:** Use Android text-to-speech for speech output. Keep Gemma as a candidate for understanding and composing answers until the spike measures it on a target phone; do not make the minimum usable product depend on an unverified model download or performance assumption.

## Spike to Close the Remaining Question

On the target Android phone, test one small Gemma model with questions about elapsed time, pace, and distance. Record model and runtime versions, whether the model runs without network access, first-response and follow-up latency, peak memory, battery change over a representative session, and whether answers stay within the requested statistic. Decide whether Gemma fits the release based on those observations; otherwise use a bounded phrase matcher and retain the open question for a later milestone.

## Sources

- [Android `TextToSpeech` API reference](https://developer.android.com/reference/android/speech/tts/TextToSpeech)
- [Gemma 3n model overview](https://ai.google.dev/gemma/docs/gemma-3n)
- [Deploy Gemma on mobile devices](https://ai.google.dev/gemma/docs/integrations/mobile)
- [Gemma 3n model card](https://ai.google.dev/gemma/docs/gemma-3n/model_card)
