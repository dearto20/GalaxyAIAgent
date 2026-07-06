# GalaxyAIAgent Architecture Override

GalaxyAIAgent is a single-module Android application prototype.

- `app/` is the sole Gradle module (`com.example.galaxyaiagent`).
- `MainActivity.java` hosts the chat screen; `ChatAdapter.java` renders messages
  in a RecyclerView; `Message.java` is the model; `ResponseGenerator.java`
  produces canned agent replies.
- UI is native Android (layouts, drawables, themes under `app/src/main/res/`).
- `harness/` provides governance, validation, intake, and traceability.

The project is currently dormant (last commit 2025-09-14). There is no backend,
no configured AI provider, and no CI. Harness governance preserves an auditable
baseline for when development resumes.
