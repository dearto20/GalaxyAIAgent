# GalaxyAIAgent Reliability Override

## Completion Criteria
- `node harness/scripts/validate-all.mjs` exits successfully.
- Target validation commands in `override/validation/target-validation-profile.md`
  pass or carry audited infra blockers.

## Infra Blocker Classification
- Gradle build, unit-test, and instrumentation checks require an Android SDK and
  a current toolchain that are not guaranteed on this host. They are recorded as
  reviewer-gated not-applicable decisions (runtime/observability/browser
  mechanisms) rather than run, and are revisited when development resumes.
- Any check that needs a device, emulator, or SDK the local repo cannot run
  unattended must be recorded as an infra blocker or a reviewer-gated
  not-applicable decision.
