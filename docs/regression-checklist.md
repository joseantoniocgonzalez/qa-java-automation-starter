# Regression Checklist (10 items)

Use this checklist before a release or after major changes.

1. Login with valid credentials works (standard_user / secret_sauce).
2. Login error message appears for invalid credentials.
3. Inventory page loads and shows title "Products".
4. Add one item to cart updates badge to "1".
5. Cart icon opens cart page without errors.
6. Refresh on inventory page keeps the app stable (no blank or error page).
7. Back/forward browser navigation does not break the session unexpectedly.
8. API: `GET /posts/1` returns 200 and expected JSON fields.
9. API: JSON Schema validation for post response passes.
10. API: data-driven posts test passes for ids 1, 2, 3.

