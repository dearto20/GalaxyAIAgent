# GalaxyAIAgent Target Validation Profile

This dormant Android/Gradle app runs cheap, real structural checks only. Gradle
build and unit-test command groups are deliberately not enabled here: the
toolchain is stale and gradle builds require an Android SDK setup that is not
guaranteed on this host. Those groups carry reviewer-gated not-applicable
decisions in the runtime/observability/browser mechanism overrides and are
revisited when development resumes.

## Data
```target-validation-json
{
  "schemaVersion": "1.0.0",
  "profileId": "galaxyaiagent-target-validation",
  "intakeRef": "override/intake/project-intake.md",
  "commands": [
    {
      "id": "android-build-manifest-present",
      "group": "architecture",
      "cwd": ".",
      "command": [
        "test",
        "-s",
        "build.gradle"
      ],
      "enabled": true,
      "timeoutSeconds": 30,
      "evidence": "harness/artifacts/validation/latest-report.json",
      "writesTo": "none",
      "artifactPolicy": "none",
      "approvalRisk": "none"
    },
    {
      "id": "android-source-present",
      "group": "architecture",
      "cwd": ".",
      "command": [
        "rg",
        "-n",
        "class MainActivity",
        "app/src/main/java/com/example/galaxyaiagent/MainActivity.java"
      ],
      "enabled": true,
      "timeoutSeconds": 30,
      "evidence": "harness/artifacts/validation/latest-report.json",
      "writesTo": "none",
      "artifactPolicy": "none",
      "approvalRisk": "none"
    },
    {
      "id": "android-build-artifacts-ignored",
      "group": "cleanup",
      "cwd": ".",
      "command": [
        "git",
        "check-ignore",
        "-q",
        "app/build"
      ],
      "enabled": true,
      "timeoutSeconds": 30,
      "evidence": "harness/artifacts/validation/latest-report.json",
      "writesTo": "none",
      "artifactPolicy": "none",
      "approvalRisk": "none"
    },
    {
      "id": "android-pr-readiness",
      "group": "pr-ci",
      "cwd": ".",
      "command": [
        "git",
        "branch",
        "--show-current"
      ],
      "enabled": true,
      "timeoutSeconds": 30,
      "evidence": "harness/artifacts/validation/latest-report.json",
      "writesTo": "none",
      "artifactPolicy": "none",
      "approvalRisk": "none"
    }
  ],
  "infraBlockers": []
}
```
