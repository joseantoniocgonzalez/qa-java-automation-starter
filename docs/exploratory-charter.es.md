# Charter de testing exploratorio

## Título
SauceDemo — Exploración rápida de Login e Inventario

## Objetivo
Explorar login e inventario para detectar problemas de usabilidad, flujos rotos o comportamientos inconsistentes que el smoke automático no cubre.

## Timebox
30 minutos

## Áreas a explorar
- Formulario de login (vacíos, espacios, caracteres especiales)
- Mensajes de error (claridad y consistencia)
- Navegación tras login (carga y respuesta)
- Add-to-cart (badge, quitar items)
- Sesión básica (refresh, botón atrás, acceso directo por URL)

## Datos / cuentas
- Válida: `standard_user` / `secret_sauce`
- Variantes inválidas:
  - password incorrecta
  - username/password vacíos
  - username con espacios al final

## Oráculos (cómo juzgar problemas)
- Claridad del feedback al usuario
- Consistencia (misma acción → mismo resultado)
- Prevención de errores
- Feedback visual (cargas/actualizaciones)

## Salidas
- Capturas y pasos de reproducción para anomalías
- Registrar hallazgos con la plantilla de bugs del repo
