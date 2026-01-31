# Definitions

## Severity vs Priority
- **Severity**: how serious the impact is for users/the business.
- **Priority**: how soon it should be fixed (planning/triage decision).

### Severity (example scale)
- **S1 Critical**: blocks core usage (cannot login, data loss, security issue).
- **S2 Major**: core flow impaired but some workaround exists.
- **S3 Minor**: non-blocking issue, cosmetic, small inconvenience.
- **S4 Trivial**: tiny cosmetic or wording issue.

### Priority (example scale)
- **P0 Now**: must be fixed immediately (release blocker).
- **P1 High**: fix in the current sprint/release.
- **P2 Medium**: fix soon, but not blocking.
- **P3 Low**: backlog.

## Smoke vs Regression
- **Smoke tests**: small set of critical checks run frequently (push/PR) to decide if a build is “basically usable”.
- **Regression tests**: broader set run on demand (before release, after major changes).

## Flaky test
A test that **passes and fails intermittently** without a code change that explains it.
Common causes: timing, async UI, unstable environment, race conditions.

Mitigation used in this repo:
- Explicit waits (no Thread.sleep)
- Stable locators (id / data-test)
- Small, deterministic smoke suite

## Evidence / Artifacts
Outputs used to debug failures:
- UI: screenshot + HTML source on failure
- BDD: Cucumber HTML/JSON report
- API: Newman HTML report + JUnit XML

## “Data-driven”
A test executed multiple times with different inputs (e.g., CSV with ids).

## JSON Schema validation
A check that the response matches an expected structure (“contract-like”):
- required fields exist
- types match (string/number/etc.)
