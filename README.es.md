# qa-java-automation-starter (Resumen)

Repositorio base de **automatización QA en Java** (UI + BDD + API) pensado como proyecto de portafolio Junior QA, con estructura reproducible para ejecución local y CI.

> English version: [README.md](README.md)

## Targets (fijos)
- **UI / BDD:** SauceDemo (sitio demo público) con `baseUrl` configurable.
- **API:** JSONPlaceholder (para Postman/Newman).
- **Navegador por defecto en CI:** Chrome (Firefox opcional por configuración).

## Qué incluye (a alto nivel)
- UI automation con Selenium (JUnit) usando Page Object básico y waits explícitos.
- BDD con Cucumber/Gherkin (tags `@smoke` y `@regression`).
- API testing con Postman + Newman (reporte HTML + salida JUnit para CI).
- Workflows en GitHub Actions (smoke en push/PR + ejecución completa manual).
- Documentación QA en `docs/`.

## Requisitos
- JDK **21**
- Maven **(3.9+)**
- Git

## Ejecución local (rápido)

### UI + BDD (Cucumber)
    mvn test

### Solo smoke (UI)
    mvn test -Dcucumber.filter.tags="@smoke"

### API (Newman)

Instala Newman (Node.js 20 recomendado):
    npm install -g newman newman-reporter-htmlextra

Ejecuta la colección:
    newman run src/test/resources/postman/collection.json \
      -e src/test/resources/postman/environment.json \
      -r cli

## CI (GitHub Actions)
- Workflow **smoke**: se ejecuta en `push` a `main` y en `pull_request`.
- Sube como artefactos los reportes generados (si aplica).

## Estructura
- `src/test/java/`: tests UI/BDD (steps, runners, pages).
- `src/test/resources/`: features, configuración y Postman.
- `docs/`: documentación QA (scope, estrategia, riesgos, etc.).
- `.github/workflows/`: pipelines de CI.

## Licencia
MIT. Ver [LICENSE](LICENSE).
