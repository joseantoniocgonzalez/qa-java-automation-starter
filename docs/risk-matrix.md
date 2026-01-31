# Risk Matrix

This is a lightweight risk view for the demo scope (SauceDemo + JSONPlaceholder).
Scale:
- Likelihood: Low / Medium / High
- Impact: Low / Medium / High

## Risks and mitigations

### R1 — Login flow breaks after UI changes
- Likelihood: High
- Impact: High
- Mitigation:
  - Smoke UI/BDD covers valid login and inventory load
  - Explicit waits + stable locators (ids/data-test)
  - Evidence on failure (screenshot + HTML)

### R2 — Cart badge does not update reliably
- Likelihood: Medium
- Impact: Medium
- Mitigation:
  - Secondary UI scenario checks badge after add-to-cart
  - Regression BDD scenario checks the same behavior

### R3 — Flaky UI tests due to timing (async UI / slow CI)
- Likelihood: Medium
- Impact: High
- Mitigation:
  - Explicit waits (no Thread.sleep)
  - Assertions on stable elements
  - Keep smoke small and deterministic

### R4 — API contract changes / unexpected payload shape
- Likelihood: Low (demo API) / Medium (real systems)
- Impact: Medium
- Mitigation:
  - Schema validation on at least one endpoint
  - Basic field presence checks
  - Data-driven checks for multiple ids

### R5 — CI environment differences (browser/headless)
- Likelihood: Medium
- Impact: Medium
- Mitigation:
  - Headless config supported
  - CI uses a fixed browser version from runner
  - Upload artifacts for debugging in CI

