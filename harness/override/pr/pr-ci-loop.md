# GalaxyAIAgent PR CI Loop Override

Changes should be focused and branch state auditable; there is no CI service
wired up while the project is dormant.

## Mechanism Data
```target-mechanism-json
{
  "schemaVersion": "1.0.0",
  "id": "pr-ci-loop",
  "status": "applicable",
  "linkedIntakeFields": [
    "target.environments"
  ],
  "profileCommandIds": [
    "android-pr-readiness"
  ],
  "notApplicable": null,
  "evidence": [
    {
      "type": "profile-command",
      "ref": "override/validation/target-validation-profile.md",
      "summary": "android-pr-readiness records the current branch for PR readiness."
    }
  ]
}
```
