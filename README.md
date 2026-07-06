# DevelopmentHarness

A portable governance harness for software projects. Drop the `harness/` subtree into any project and get a gated requirement lifecycle, ADR enforcement, traceability tests, and a discovery-driven validation pipeline — all running on Node's built-in test runner.

## What's in here

- `AGENTS.md` — root cross-agent entrypoint for Codex and other agents; delegates to `harness/AGENTS.md`
- `CLAUDE.md` — Claude Code compatibility shim; delegates to the same harness rules
- `harness/` — the harness subtree (this is what you copy into your own project)
  - `AGENTS.md` — governance entrypoint (reading order, work rules, completion criteria, framework-vs-override boundary rule)
  - `framework/` — project-agnostic process, checklists, templates (lifecycle, execution plans, agentic loop, sub-agent coordination, cross-agent review, runtime/observability contracts, harness-engineering alignment, external reference hardening, tier definitions, ADR governance, OWASP/Nielsen review checklists)
  - `exec-plans/` — execution-plan template plus seed README anchors for target-owned active/completed/tech-debt ledgers
  - `tests/contracts/` — register and ADR traceability tests
  - `harness/scripts/validate-all.mjs` — discovery-driven validator
  - `artifacts/validation/` — generated reports (gitignored, README anchor committed)
- `development/` — DevelopmentHarness source-maintenance state; not copied to installed targets
- `BOOTSTRAP.md` — how to install the harness in your own project
- `.github/workflows/validate.yml` — CI workflow (runs `node harness/scripts/validate-all.mjs`)

## Source Checkout vs Installed Target

If a bootstrap process fetches the whole DevelopmentHarness repository, treat that checkout as a source archive, not as the final target layout. Materialize only the manifest-approved distributable surface into the target project.

The source marker `development/developmentharness-source.json` is intentionally present only in this repository. Target bootstrap rules, exact source-marker behavior, and path ownership are canonical in [`BOOTSTRAP.md`](./BOOTSTRAP.md).

Stable bootstrap layout contract:
- `BOOTSTRAP_LAYOUT_CONTRACT: manifest-distributable-only`
- `BOOTSTRAP_LAYOUT_CONTRACT: no-target-development-root`
- `BOOTSTRAP_LAYOUT_CONTRACT: target-override-owned`

The canonical path ownership table is in [`BOOTSTRAP.md`](./BOOTSTRAP.md#directory-ownership-at-a-glance). Keep detailed path ownership there to avoid duplicated tables drifting apart.

When bootstrapping by agent instruction, use the agent-facing flow in [`BOOTSTRAP.md`](./BOOTSTRAP.md#agent-bootstrap-contract). It tells Codex or Claude Code to fetch this repo as a source archive, ask target intake questions first, materialize only the distributable harness, create target-owned `harness/override/`, and run validation.

## Quick start

To use this in a new project, see [`BOOTSTRAP.md`](./BOOTSTRAP.md). The short version:

Use the manifest-approved distributable surface described in [`BOOTSTRAP.md`](./BOOTSTRAP.md); do not copy root `development/` or DevelopmentHarness source history into target projects.

Then read `harness/AGENTS.md` ("Framework vs Override — Boundary Rule" section), fill the bootstrap intake under `harness/override/intake/`, configure the executable target validation profile under `harness/override/validation/`, create target-project override mechanism docs, add requirements to `harness/override/requirements/requirement-register.json`, and follow the 10-step lifecycle plus runtime-mode, harness-engineering-alignment, external-reference-hardening, execution-plan, and sub-agent process docs for every non-trivial change.

## Status

This repository is the canonical template source. DevelopmentHarness source-maintenance state lives under `development/`; installed projects create their own target-owned `harness/override/` state after bootstrap.
