# Exploratory Testing Charter

## Charter title
SauceDemo - Login & Inventory quick exploration

## Goal
Explore the login and inventory experience to identify usability issues, broken flows, or inconsistent behavior that automated smoke tests may not catch.

## Timebox
30 minutes

## Areas to explore
- Login form behavior (empty fields, spaces, special characters)
- Error messages clarity and consistency
- Navigation after login (inventory page load and responsiveness)
- Add-to-cart behavior (badge updates, removing items)
- Basic session behavior (refresh, back button, direct URL access)

## Data / accounts
- Valid: `standard_user` / `secret_sauce`
- Invalid variations:
  - wrong password
  - empty username/password
  - username with trailing spaces

## Oracles (how to judge problems)
- User feedback: messages are clear, consistent, and helpful
- Consistency: same action produces same result
- Error prevention: app guides user to correct input
- Visual feedback: loading states and page updates are clear

## Notes and outputs
- Capture screenshots or steps for any anomalies
- Log findings using the repository bug report template

