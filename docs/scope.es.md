# Alcance (qa-java-automation-starter)

## Para qué sirve (uso real)
Este repo actúa como una **red de seguridad pequeña pero realista**:
- Detecta rápido si una entrega rompe lo básico (login, inventario, carrito).
- Aporta **evidencias** cuando falla (reportes y artefactos).
- Separa **smoke** (siempre) de **regresión** (bajo demanda).
- Combina UI + BDD + API de forma reproducible (local + CI).

## Objetivo
Starter reproducible de automatización QA para portafolio:
- UI automation (Selenium + JUnit) sobre SauceDemo
- BDD (Cucumber) con tags smoke/regresión
- API testing (Postman/Newman) sobre JSONPlaceholder
- CI (GitHub Actions) para smoke y full

## Dentro de alcance (qué se prueba)
### UI (SauceDemo)
- Login correcto
- Login incorrecto muestra error
- Carga de inventario y título esperado
- Añadir 1 item actualiza el badge del carrito

### BDD (SauceDemo)
- Smoke: login correcto lleva a inventario
- Regresión:
  - login inválido muestra error
  - añadir 1 item actualiza badge

### API (JSONPlaceholder)
- Smoke:
  - `GET /posts/1` estado + campos + validación de schema
  - `GET /users` estado + array + campos básicos
- Data-driven:
  - `GET /posts/{{postId}}` con CSV y validación del id devuelto

## Fuera de alcance (qué NO se prueba)
- Rendimiento/carga
- Seguridad (OWASP/pentest)
- Accesibilidad (WCAG)
- Matriz completa de navegadores (más allá de Chrome por defecto)
- Regresión visual (pixel)
- Navegación móvil/responsive
- Flujos E2E completos tipo checkout (sitio demo; mantenemos flujos mínimos)

## Criterio de Done (para este repo)
Un cambio se considera “Done” cuando:
1. `mvn test` pasa en local (UI + BDD smoke)
2. Newman smoke pasa en local (collection + environment)
3. El workflow `smoke` pasa en push/PR
4. Si se toca regresión o API full, el workflow `full` pasa en ejecución manual
5. Se generan reportes sin errores:
   - `reports/cucumber/*`
   - `reports/newman/*`
   - `reports/junit/*`
