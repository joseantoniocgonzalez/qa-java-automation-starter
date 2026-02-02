# qa-java-automation-starter

Repositorio base de **automatización QA en Java** (**UI + BDD + API**) pensado como proyecto de portafolio Junior QA, con estructura reproducible para ejecución local y lista para CI.

> Versión en inglés: **README.md**

---

## Objetivos (fijos)

- **UI / BDD:** SauceDemo (sitio demo público) — `baseUrl` configurable.
- **API:** JSONPlaceholder (Postman/Newman).
- **Navegador por defecto en CI:** Chrome (Firefox opcional vía configuración).

---

## Qué incluye (alto nivel)

- **Automatización UI** con Selenium (JUnit), usando un enfoque básico de Page Object y esperas explícitas.
- **BDD** con Cucumber/Gherkin (runners de smoke y regresión).
- **Testing de API** con Postman + Newman:
  - Reporte HTML (`htmlextra`)
  - Salida JUnit XML (compatible con CI)
  - Ejecución data-driven usando `posts.csv` (workflow full)
- **Workflows de GitHub Actions**:
  - **smoke** en push/PR
  - **full** manual (workflow_dispatch)
- **Documentación QA** en `docs/` (scope, estrategia, riesgos, diseño de pruebas, plantillas, bugs, etc.).

---

## Requisitos

- **JDK 21**
- **Maven 3.9+**
- **Git**
- **Node.js 20+** (para Newman)

---

## Ejecución local (rápido)

### UI + BDD (ejecución por defecto)

Ejecuta tests UI + Cucumber smoke (la regresión se excluye por defecto en Surefire):
```bash
mvn test
```

Headless (recomendado en Linux/CI):
```bash
mvn test -Dheadless=true
```

### Cucumber regresión (bajo demanda)

Runner de regresión:
```bash
mvn test -Dtest=bdd.runners.CucumberRegressionTest
```

### API (Newman)

Instalar Newman:
```bash
npm install -g newman newman-reporter-htmlextra
```

#### Smoke (API) — mismas carpetas que CI
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

## Informes y evidencias (local + CI)

Las salidas generadas se guardan en `reports/`:

- `reports/cucumber/` → informes Cucumber HTML/JSON
- `reports/newman/` → informes Newman HTML
- `reports/junit/` → salidas JUnit XML (p. ej., `newman-smoke.xml`, `newman-full.xml`)

En GitHub Actions, los workflows suben (si existen):
- `reports/**`
- `screenshots/**`
- `html-source/**`

---

## CI (GitHub Actions)

- Workflow **smoke**:
  - se ejecuta en **push a `main`** y en **pull_request**
  - corre `mvn -B test -Dheadless=true`
  - ejecuta Newman smoke y sube artifacts

- Workflow **full**:
  - se ejecuta con **workflow_dispatch**
  - corre `mvn -B test`
  - corre regresión Cucumber con `-Dtest=bdd.runners.CucumberRegressionTest`
  - ejecuta Newman full (data-driven) y sube artifacts

---

## Estructura

- `src/test/java/`
  - `ui/` → tests UI, pages, utils
  - `bdd/` → runners Cucumber + steps
  - `config/` → utilidades de driver/config
- `src/test/resources/`
  - `features/` → ficheros `.feature`
  - `config/` → `test.properties`
  - `postman/` → `collection.json`, `environment.json`, `posts.csv`
- `docs/` → documentación QA + plantillas + bugs
- `reports/` → informes generados (cucumber / newman / junit)
- `.github/workflows/` → pipelines de CI

---

## Formateo / linting (Spotless)

Formatear el código de tests:
```bash
mvn spotless:apply
```
