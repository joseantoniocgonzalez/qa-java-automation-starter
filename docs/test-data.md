# Test Data

## UI/BDD (SauceDemo)
This project uses the public demo site SauceDemo.

### Accounts used
- Valid: `standard_user` / `secret_sauce`
- Invalid example: `standard_user` / `wrong_password`

### Notes about resetting data
SauceDemo is a demo environment. For this starter:
- We keep flows minimal (login, inventory, add-to-cart badge).
- If a cart state persists unexpectedly, rerun the test from a clean session (the tests start a fresh browser session per test/scenario).

## API (JSONPlaceholder)
This project uses JSONPlaceholder as a public demo API.

### Endpoints used
- `GET /posts/1`
- `GET /users`
- `GET /posts/{{postId}}` (data-driven)

### Data-driven file
- CSV file: `src/test/resources/postman/posts.csv`
- Column: `postId`
- Values: `1, 2, 3`

### Resetting data
JSONPlaceholder is a demo API; our scope uses only GET requests:
- No reset is required.
- If network issues happen, rerun later or from a different network.
