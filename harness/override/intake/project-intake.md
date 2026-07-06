# GalaxyAIAgent Project Intake

## Data
```intake-json
{
  "schemaVersion": "1.0.0",
  "state": "ready",
  "project": {
    "name": "GalaxyAIAgent",
    "summary": "Android application prototype for an on-device AI agent chat experience (chat UI, message adapter, canned response generator). Currently dormant; last committed 2025-09-14.",
    "primaryGoal": "Preserve the existing Android AI-agent app prototype under harness governance so future development resumes from an auditable, validated baseline.",
    "successCriteria": [
      "Harness validation passes via node harness/scripts/validate-all.mjs.",
      "Android build configuration and primary source files remain present and structurally intact.",
      "Generated build outputs stay git-ignored and branch state is auditable."
    ],
    "nonGoals": [
      "Run gradle builds or Android unit/instrumentation tests on this host.",
      "Ship, sign, or deploy an APK.",
      "Add features while the project is dormant."
    ]
  },
  "target": {
    "platforms": [
      "Android",
      "local validation"
    ],
    "deploymentModel": "installable Android app (APK); not currently built or released",
    "runtimeSurfaces": [
      "Android Activity (MainActivity)",
      "chat RecyclerView UI",
      "local response generator"
    ],
    "environments": [
      "local development"
    ]
  },
  "users": {
    "audiences": [
      "developer operator",
      "app end user (future)"
    ],
    "roles": [
      "developer",
      "reviewer"
    ],
    "primaryUser": "developer operator"
  },
  "domain": {
    "verticals": [
      "mobile AI agent",
      "conversational UI"
    ],
    "workflows": [
      "chat interaction",
      "message rendering",
      "response generation"
    ],
    "criticality": "prototype; defects affect only local experimentation while the project is dormant"
  },
  "risk": {
    "dataSensitivity": "Low: prototype chat app with no configured backend or persisted user data in the repo.",
    "securityPosture": "No provider API keys or signing secrets committed; .gitignore excludes keystores and local.properties.",
    "regulatoryPosture": "Private prototype with no regulated compliance claim.",
    "operationalImpact": "None currently deployed; impact is limited to the local development baseline."
  },
  "validation": {
    "expectedCommandGroups": [
      "architecture",
      "cleanup",
      "pr-ci"
    ],
    "browserRequired": false,
    "observabilityRequired": false,
    "runtimeRequired": false
  },
  "constraints": [
    "Do not run gradle builds during harness validation (stale Android toolchain; requires Android SDK setup).",
    "No provider API keys or signing secrets in tracked files.",
    "Harness must never edit harness/framework or harness/scripts."
  ],
  "deferredNoncriticalFields": []
}
```
