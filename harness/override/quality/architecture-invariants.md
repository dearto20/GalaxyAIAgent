# GalaxyAIAgent Architecture Invariants Override

The app must retain its Gradle build configuration and primary Android source
entry point so the baseline stays buildable when development resumes.

## Mechanism Data
```target-mechanism-json
{
  "schemaVersion": "1.0.0",
  "id": "architecture-invariants",
  "status": "applicable",
  "linkedIntakeFields": [
    "target.platforms",
    "domain.workflows"
  ],
  "profileCommandIds": [
    "android-build-manifest-present",
    "android-source-present"
  ],
  "notApplicable": null,
  "evidence": [
    {
      "type": "source-doc",
      "ref": "../build.gradle",
      "summary": "Root Gradle build config is the architecture anchor for the Android app."
    }
  ]
}
```
