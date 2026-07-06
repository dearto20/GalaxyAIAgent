# GalaxyAIAgent Worktree Runtime Override

This app is dormant and has no unattended runtime the harness can drive. Building
or launching it requires an Android SDK/emulator setup and a gradle toolchain that
is stale on this host, so runtime execution is not validated here.

## Mechanism Data
```target-mechanism-json
{
  "schemaVersion": "1.0.0",
  "id": "worktree-runtime",
  "status": "not-applicable",
  "linkedIntakeFields": [
    "validation.runtimeRequired",
    "target.runtimeSurfaces"
  ],
  "profileCommandIds": [],
  "notApplicable": {
    "rationale": "Stale Android toolchain; gradle builds require Android SDK setup — revisit when development resumes. No unattended app runtime to drive.",
    "reviewerRole": "architect",
    "approvedAt": "2026-07-06T00:00:00Z",
    "linkedIntakeField": "validation.runtimeRequired",
    "highRisk": false,
    "crossAgentReviewRef": "",
    "replacementEvidence": [
      {
        "type": "intake",
        "ref": "override/intake/project-intake.md",
        "summary": "runtimeRequired is false; app is dormant with no unattended runtime."
      }
    ]
  },
  "evidence": []
}
```
