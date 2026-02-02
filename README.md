# qa-java-automation-starter

Java-based QA Automation starter repo (UI + BDD + API) designed for a junior QA portfolio, with reproducible local runs and CI-ready structure.

> Spanish version: [README.es.md](README.es.md)

## Targets (fixed)
- **UI / BDD target:** SauceDemo (public demo site) — baseUrl configurable.
- **API target:** JSONPlaceholder (for Postman/Newman).
- **CI default browser:** Chrome (Firefox optional via configuration).

## What’s inside (high level)
- UI automation with Selenium (JUnit) using a basic Page Object approach and explicit waits.
- BDD with Cucumber/Gherkin (tags `@smoke` and `@regression`).
- API testing with Postman + Newman (HTML report + JUnit output for CI).
- GitHub Actions workflows (smoke on push/PR + full manual run).
- QA documentation set under `docs/`.

## Requirements
- JDK **21**
- Maven **(3.9+)**
- Git

## Local run (quick)

### UI + BDD (Cucumber)
    mvn test

### Smoke only (UI)
    mvn test -Dcucumber.filter.tags="@smoke"

### API (Newman)

Install Newman (Node.js 20 recommended):
    npm install -g newman newman-reporter-htmlextra

Run the collection:
    newman run src/test/resources/postman/collection.json \
      -e src/test/resources/postman/environment.json \
      -r cli

## CI (GitHub Actions)
- **smoke** workflow runs on `push` to `main` and on `pull_request`.
- Uploads generated reports as artifacts (if applicable).

## Structure
- `src/test/java/`: UI/BDD tests (steps, runners, pages).
- `src/test/resources/`: features, configuration, and Postman.
- `docs/`: QA documentation (scope, strategy, risks, etc.).
- `.github/workflows/`: CI pipelines.

## License
MIT. See [LICENSE](LICENSE).
