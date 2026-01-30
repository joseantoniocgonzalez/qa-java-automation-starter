# qa-java-automation-starter

Java-based QA Automation starter repo (UI + BDD + API) designed for a junior QA portfolio, with reproducible local runs and CI-ready structure.

> Spanish version: [README.es.md](README.es.md)

## Targets (fixed)
- **UI / BDD target:** SauceDemo (public demo site) — baseUrl configurable.
- **API target:** JSONPlaceholder (for Postman/Newman).
- **CI default browser:** Chrome (Firefox optional via configuration).

## What’s inside (high level)
- UI automation with Selenium (JUnit) using a basic Page Object approach and explicit waits.
- BDD with Cucumber/Gherkin (smoke + regression tags).
- API testing with Postman + Newman (HTML report + JUnit output for CI).
- GitHub Actions workflows (smoke on push/PR + full manual run).
- QA documentation set under `docs/`.

## Repository layout (top level)
- `.github/` → workflows, issue templates, dependabot, codeowners (added in later phases)
- `src/test/java/` → UI and BDD test code (added in later phases)
- `src/test/resources/` → features, Postman artifacts, and config (added in later phases)
- `docs/` → QA documentation (added in later phases)
- `reports/` → local report output folders (kept for structure; generated content is ignored by Git)

## Requirements
- JDK **21**
- Git

> Maven, dependencies, and runnable commands are introduced in the next phase when `pom.xml` is added.
