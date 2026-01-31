# Test Design (qa-java-automation-starter)

## Why this design (real-life reasoning)
This project is designed like a small, real QA safety net:
- **Smoke** covers the minimum critical path to decide if a build is "basically usable".
- **Regression** covers additional but still high-value flows, executed on demand.
- Tests are intentionally few but stable: the goal is to be **reliable and reproducible**, not exhaustive.

## Selection criteria
We chose scenarios using these criteria:
1. **Business criticality**: login and inventory are entry points to most user journeys.
2. **High change risk**: UI locators and login flows often break after small UI refactors.
3. **Fast feedback**: smoke must run quickly in CI.
4. **Deterministic assertions**: assert stable elements (titles, badges, status codes) to reduce flakiness.
5. **Clear failure diagnosis**: reports + artifacts support fast debugging.

## Smoke vs Regression
### Smoke
Purpose: run on every push/PR in CI.
Includes:
- UI: successful login + inventory page loaded
- BDD: `@smoke` scenario equivalent
- API: basic health checks (status + minimal structure)

Expected runtime:
- Short, suitable for frequent execution.

### Regression
Purpose: run on demand (manual CI workflow).
Includes:
- Invalid login error handling
- Cart badge updates after adding an item
- Data-driven API tests (multiple ids)

Expected runtime:
- Longer than smoke, still lightweight.

## UI automation strategy
- **Page Object Model** keeps locators and actions centralized.
- **Explicit waits** avoid brittle timing assumptions.
- Evidence (screenshot + HTML) is collected **only on failure** to keep runs clean.
- Assertions focus on stable UI signals:
  - Inventory title "Products"
  - Cart badge count "1"
  - Presence of login error message

## BDD strategy
- Features express user intent in Given/When/Then.
- Tags:
  - `@smoke` always in CI
  - `@regression` only on demand
- Reports:
  - HTML + JSON for CI artifacts and quick review

## API testing strategy
- JSONPlaceholder is used as a stable public demo API.
- Smoke tests validate:
  - HTTP status
  - JSON response
  - minimal required fields
- One request includes **JSON Schema validation** to demonstrate contract-like checks.
- Data-driven test validates multiple ids using CSV input.

