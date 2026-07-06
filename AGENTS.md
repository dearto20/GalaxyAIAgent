# DevelopmentHarness

Cross-agent root entrypoint. The single normative contract is `harness/AGENTS.md` — read it first; everything else loads on demand from its reference map.

- Harness process is default operating law for all agent work: `HARNESS_PROCESS_CONTRACT: default-for-all-agent-work`. Ordinary silence does not disable harness obligations.
- Tier is computed from touched paths (`node harness/scripts/harness.mjs tier`); non-trivial work records an execution ledger before edits and top-level dual-role governance (primary performer + independent critic) until terminal, pushback-free critic evidence exists. Sub-agents are internal decomposition and do not replace the top-level critic.
- Plan Mode still performs harness planning obligations but does not mutate tracked files. Mutation-capable mode creates or updates execution ledgers before non-trivial edits.
- Open every response with the `[harness]` tier line; narrate tool/skill/doc transitions on governed work.
- In this source repository, source-maintenance state lives under root `development/`; installed targets use `harness/override/`.
- Whole-repo fetches follow root `BOOTSTRAP.md`: `BOOTSTRAP_LAYOUT_CONTRACT: manifest-distributable-only`, `BOOTSTRAP_LAYOUT_CONTRACT: no-target-development-root`, `BOOTSTRAP_LAYOUT_CONTRACT: target-override-owned`, `BOOTSTRAP_LAYOUT_CONTRACT: preserve-target-owned-harness-state`.
- Before any completion claim: `node harness/scripts/validate-all.mjs` (or `harness check`).
