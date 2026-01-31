# Definiciones

## Severidad vs Prioridad
- **Severidad**: impacto real del problema.
- **Prioridad**: urgencia de arreglarlo (decisión de planificación/triage).

### Severidad (ejemplo)
- **S1 Crítica**: bloquea uso básico (no se puede loguear, pérdida de datos, seguridad).
- **S2 Mayor**: afecta flujo principal, puede haber workaround.
- **S3 Menor**: no bloquea, molestia/cosmético.
- **S4 Trivial**: detalle mínimo.

### Prioridad (ejemplo)
- **P0 Ya**: bloquea release.
- **P1 Alta**: arreglar en sprint/release actual.
- **P2 Media**: arreglar pronto, no bloquea.
- **P3 Baja**: backlog.

## Smoke vs Regresión
- **Smoke**: set pequeño y crítico, se ejecuta a menudo (push/PR).
- **Regresión**: set más amplio, bajo demanda (antes de release, cambios grandes).

## Test flaky
Test que falla/pasa de forma intermitente sin cambios explicativos.
Causas típicas: timing, async UI, entorno, race conditions.

Mitigación en este repo:
- Waits explícitos (sin Thread.sleep)
- Locators estables (id / data-test)
- Smoke pequeño y determinista

## Evidencias / Artefactos
- UI: screenshot + HTML source en fallo
- BDD: reporte Cucumber HTML/JSON
- API: reporte Newman HTML + JUnit XML

## Data-driven
Ejecución repetida del mismo test con distintos datos (CSV).

## Validación JSON Schema
Chequeo de estructura/contrato:
- campos requeridos
- tipos correctos
