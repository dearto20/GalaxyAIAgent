# GalaxyAIAgent Recurring Cleanup Override

Cleanup hygiene asserts that generated build outputs stay out of version control,
so the dormant baseline never accretes tracked build artifacts.

## Mechanism Data
```target-mechanism-json
{
  "schemaVersion": "1.0.0",
  "id": "recurring-cleanup",
  "status": "applicable",
  "linkedIntakeFields": [
    "project.successCriteria"
  ],
  "profileCommandIds": [
    "android-build-artifacts-ignored"
  ],
  "notApplicable": null,
  "evidence": [
    {
      "type": "profile-command",
      "ref": "override/validation/target-validation-profile.md",
      "summary": "android-build-artifacts-ignored fails (git check-ignore) if generated build outputs stop being git-ignored."
    }
  ]
}
```
