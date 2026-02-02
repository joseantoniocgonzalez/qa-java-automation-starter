# qa-java-automation-starter

Java-based QA Automation starter repo (**UI + BDD + API**) designed for a junior QA portfolio, with reproducible local runs and a CI-ready structure.

> Spanish version: **README.es.md**

---

## Targets (fixed)

- **UI / BDD target:** SauceDemo (public demo site) — `baseUrl` configurable.
- **API target:** JSONPlaceholder (Postman/Newman).
- **CI default browser:** Chrome (Firefox optional via configuration).

---

## What’s inside (high level)

- **UI automation** with Selenium (JUnit), using a basic Page Object approach and explicit waits.
- **BDD** with Cucumber/Gherkin (smoke + regression runners).
- **API testing** with Postman + Newman:
  - HTML report (`htmlextra`)
  - JUnit XML output (CI-friendly)
  - Data-driven run using `posts.csv` (full workflow)
- **GitHub Actions** workflows:
  - **smoke** on push/PR
  - **full** manual (workflow_dispatch)
- **QA documentation** under `docs/` (scope, strategy, risks, test design, templates, bugs, etc.).

---

## Requirements

- **JDK 21**
- **Maven 3.9+**
- **Git**
- **Node.js 20+** (for Newman)

---

## Local run (quick)

### UI + BDD (default run)

Runs UI tests + Cucumber smoke (regression is excluded by default in Surefire):
```bash
mvn test
```

Headless (recommended on Linux/CI):
```bash
mvn test -Dheadless=true
```

### Cucumber regression (on demand)

Regression runner:
```bash
mvn test -Dtest=bdd.runners.CucumberRegressionTest
```

### API (Newman)

Install Newman:
```bash
npm install -g newman newman-reporter-htmlextra
```

#### Smoke (API) — same folders as CI
```bash
mkdir -p reports/newman reports/junit

newman run src/test/resources/postman/collection.json \
  --folder "Smoke - GET /posts/1" \
  --folder "Smoke - GET /users" \
  -e src/test/resources/postman/environment.json \
  -r junit,htmlextra \
  --reporter-junit-export reports/junit/newman-smoke.xml \
  --reporter-htmlextra-export reports/newman/newman-smoke.html
```

#### Full (API + data-driven)
```bash
mkdir -p reports/newman reports/junit

newman run src/test/resources/postman/collection.json \
  -e src/test/resources/postman/environment.json \
  -d src/test/resources/postman/posts.csv \
  -r junit,htmlextra \
  --reporter-junit-export reports/junit/newman-full.xml \
  --reporter-htmlextra-export reports/newman/newman-full.html
```

---

## Reports & evidence (local + CI)

Generated outputs are stored under `reports/`:

- `reports/cucumber/` → Cucumber HTML/JSON reports
- `reports/newman/` → Newman HTML reports
- `reports/junit/` → JUnit XML outputs (e.g., `newman-smoke.xml`, `newman-full.xml`)

In GitHub Actions, workflows upload (if present):
- `reports/**`
- `screenshots/**`
- `html-source/**`

---

## CI (GitHub Actions)

- **smoke** workflow:
  - triggers on **push to `main`** and **pull_request**
  - runs `mvn -B test -Dheadless=true`
  - runs Newman smoke folders and uploads artifacts

- **full** workflow:
  - triggers via **workflow_dispatch**
  - runs `mvn -B test`
  - runs Cucumber regression via `-Dtest=bdd.runners.CucumberRegressionTest`
  - runs Newman full (data-driven) and uploads artifacts

---

## Structure

- `src/test/java/`
  - `ui/` → UI tests, pages, utils
  - `bdd/` → Cucumber runners + steps
  - `config/` → driver/config utilities
- `src/test/resources/`
  - `features/` → `.feature` files
  - `config/` → `test.properties`
  - `postman/` → `collection.json`, `environment.json`, `posts.csv`
- `docs/` → QA documentation + templates + tracked bugs
- `reports/` → generated reports (cucumber / newman / junit)
- `.github/workflows/` → CI pipelines

---

## Formatting / linting (Spotless)

Format test code:
```bash
mvn spotless:apply
```
