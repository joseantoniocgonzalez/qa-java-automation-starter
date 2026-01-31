# Matriz de riesgos

Escala:
- Probabilidad: Baja / Media / Alta
- Impacto: Bajo / Medio / Alto

## Riesgos y mitigaciones

### R1 — Se rompe el login tras cambios de UI
- Probabilidad: Alta
- Impacto: Alto
- Mitigación:
  - Smoke UI/BDD cubre login OK + inventario
  - Locators estables (id/data-test) + waits explícitos
  - Evidencias en fallo (screenshot + HTML)

### R2 — El badge del carrito no se actualiza
- Probabilidad: Media
- Impacto: Medio
- Mitigación:
  - Escenario UI secundario valida badge “1”
  - Escenario BDD de regresión valida lo mismo

### R3 — Tests UI flaky por timing (async / CI)
- Probabilidad: Media
- Impacto: Alto
- Mitigación:
  - Waits explícitos (sin sleeps)
  - Asserts deterministas
  - Smoke pequeño y estable

### R4 — Cambios en contrato/estructura de API
- Probabilidad: Baja (demo) / Media (real)
- Impacto: Medio
- Mitigación:
  - Validación de JSON Schema
  - Chequeo de campos mínimos
  - Data-driven con varios ids

### R5 — Diferencias de entorno en CI (headless/navegador)
- Probabilidad: Media
- Impacto: Medio
- Mitigación:
  - Config headless soportada
  - Artefactos subidos para depurar en CI
