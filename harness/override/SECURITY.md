# GalaxyAIAgent Security Override

Security boundaries:

- Do not commit provider API keys or model credentials; keep them out of tracked
  source and configuration.
- Do not commit signing material: `.gitignore` excludes `*.jks`, `*.keystore`,
  `**/keystore*`, `**/signing.properties`, and `local.properties`.
- Treat any future user conversation data as private; the current prototype
  persists no backend user data in the repo.
