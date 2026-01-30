# qa-java-automation-starter (Resumen)

Repositorio base de **automatización QA en Java** (UI + BDD + API) pensado como proyecto de portafolio Junior QA y con estructura reproducible para ejecución local y CI.

> English version: [README.md](README.md)

## Targets (fijos)
- **UI / BDD:** SauceDemo (sitio demo público) con `baseUrl` configurable.
- **API:** JSONPlaceholder (para Postman/Newman).
- **Navegador por defecto en CI:** Chrome (Firefox opcional por configuración).

## Qué incluye (a alto nivel)
- UI automation con Selenium (JUnit) usando Page Object básico y waits explícitos.
- BDD con Cucumber/Gherkin (tags smoke y regression).
- API testing con Postman + Newman (reporte HTML + salida JUnit para CI).
- Workflows en GitHub Actions (smoke en push/PR + ejecución completa manual).
- Documentación QA en `docs/`.

## Requisitos
- JDK **21**
- Git

> Maven, dependencias y comandos ejecutables se añaden en la siguiente fase al crear `pom.xml`.
