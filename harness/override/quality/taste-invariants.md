# GalaxyAIAgent Taste Invariants Override

The primary Android Activity remains the readable entry point for the chat
experience; source must stay present and coherently named.

## Mechanism Data
```target-mechanism-json
{
  "schemaVersion": "1.0.0",
  "id": "taste-invariants",
  "status": "applicable",
  "linkedIntakeFields": [
    "users.audiences",
    "project.successCriteria"
  ],
  "profileCommandIds": [
    "android-source-present"
  ],
  "notApplicable": null,
  "evidence": [
    {
      "type": "source-doc",
      "ref": "../app/src/main/java/com/example/galaxyaiagent/MainActivity.java",
      "summary": "MainActivity is checked for presence of the primary chat entry point."
    }
  ]
}
```
