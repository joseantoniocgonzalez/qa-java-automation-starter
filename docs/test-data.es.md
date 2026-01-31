# Datos de prueba

## UI/BDD (SauceDemo)
Sitio demo público.

### Cuentas
- Válida: `standard_user` / `secret_sauce`
- Inválida (ejemplo): `standard_user` / `wrong_password`

### Reset / estado
Los tests abren una sesión de navegador nueva por test/escenario.
Si el estado del carrito persistiera de forma extraña, basta con re-ejecutar en sesión limpia.

## API (JSONPlaceholder)
API demo pública.

### Endpoints
- `GET /posts/1`
- `GET /users`
- `GET /posts/{{postId}}` (data-driven)

### Data-driven
- CSV: `src/test/resources/postman/posts.csv`
- Columna: `postId`
- Valores: `1, 2, 3`

### Reset
Usamos solo GET, por lo que no hay datos que resetear.
