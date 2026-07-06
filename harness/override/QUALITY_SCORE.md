# GalaxyAIAgent Quality Override

Local quality gates:

- `test -s build.gradle` (build configuration present)
- `rg -n "class MainActivity" app/src/main/java/com/example/galaxyaiagent/MainActivity.java`
  (primary Android entry point present)
- `git check-ignore -q app/build` (generated build outputs stay git-ignored — fails if the ignore rule breaks)
- `node harness/scripts/validate-all.mjs`

Gradle build and unit-test scoring is deferred while the toolchain is stale;
revisit when development resumes.
