# Diseño de pruebas (qa-java-automation-starter)

## Por qué este diseño (en la práctica)
Este proyecto está planteado como una red de seguridad QA:
- **Smoke**: mínimo crítico para saber si la build es “usable”.
- **Regresión**: casos extra de valor, ejecutados bajo demanda.
- Pocos tests, pero estables: prioridad a fiabilidad y reproducibilidad.

## Criterios de selección
1. **Criticidad**: login e inventario son el punto de entrada.
2. **Riesgo de cambios**: el login y locators se rompen con refactors UI.
3. **Feedback rápido**: smoke debe ser rápido en CI.
4. **Asserts deterministas**: señales estables (título, badge, status code).
5. **Diagnóstico**: reportes y artefactos para depurar rápido.

## Smoke vs Regresión
### Smoke
- Propósito: ejecutar en cada push/PR.
- Incluye:
  - UI: login OK + inventario
  - BDD: escenario `@smoke`
  - API: checks básicos (status + estructura mínima)
- Runtime: corto.

### Regresión
- Propósito: ejecutar manualmente (workflow full).
- Incluye:
  - login KO (mensaje de error)
  - badge del carrito tras añadir item
  - API data-driven (varios ids)
- Runtime: más largo que smoke, pero ligero.

## Estrategia UI
- Page Object Model para centralizar acciones y locators.
- Waits explícitos (sin Thread.sleep).
- Evidencias solo en fallo (screenshot + HTML).
- Asserts en señales estables:
  - título "Products"
  - badge "1"
  - error visible en login KO

## Estrategia BDD
- Features expresan intención (Given/When/Then).
- Tags:
  - `@smoke` siempre en CI
  - `@regression` bajo demanda
- Reportes: HTML + JSON.

## Estrategia API
- JSONPlaceholder como API demo estable.
- Smoke: status + JSON + campos mínimos.
- 1 validación de JSON Schema (estructura/contrato).
- Data-driven con CSV para múltiples ids.
