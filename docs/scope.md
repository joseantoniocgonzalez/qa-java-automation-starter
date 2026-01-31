# Scope (qa-java-automation-starter)

## Why this exists (real-life purpose)
This repo is a **small but realistic safety net**:
- It detects quickly if a basic release is broken (login, inventory, cart badge).
- It provides **evidence** when failures happen (reports/artifacts).
- It shows a practical split between **smoke** (always) and **regression** (on demand).
- It combines UI + BDD + API in a reproducible way (local + CI).

## Objective
A **reproducible QA automation starter** for a junior portfolio:
- UI automation (Selenium + JUnit) against SauceDemo
- BDD (Cucumber) with smoke and regression tags
- API testing (Postman/Newman) against JSONPlaceholder
- CI pipelines (GitHub Actions) for smoke and full runs

## In scope (what we test)
### UI (SauceDemo)
- Login (valid credentials)
- Login (invalid credentials shows an error)
- Inventory page loads and shows expected title
- Add one item to cart updates cart badge

### BDD (SauceDemo)
- Smoke scenario: successful login leads to inventory page
- Regression scenarios:
  - invalid login shows error message
  - add one item updates cart badge

### API (JSONPlaceholder)
- Smoke:
  - `GET /posts/1` status + basic fields + schema validation
  - `GET /users` status + array shape + basic fields
- Data-driven:
  - `GET /posts/{{postId}}` using CSV data (`posts.csv`) and validation of returned id

## Out of scope (what we do NOT test)
- Performance / load testing
- Security testing (auth, OWASP, pentesting)
- Accessibility (WCAG) checks
- Cross-browser matrix (beyond basic Chrome default; Firefox is optional via config)
- Visual regression testing (pixel-based)
- Mobile browsers / responsive layouts
- Full end-to-end checkout (SauceDemo is a demo site; we keep flows minimal)

## Done criteria (Definition of Done for this repo)
A change is considered "Done" when:
1. `mvn test` passes locally (UI + BDD smoke)
2. Newman smoke run passes locally (collection + environment)
3. CI smoke workflow passes on push/PR
4. If regression or full API is modified, the `full` workflow passes on manual run
5. Reports are generated without errors:
   - `reports/cucumber/*`
   - `reports/newman/*`
   - `reports/junit/*`
