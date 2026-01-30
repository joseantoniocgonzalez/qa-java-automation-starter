package ui.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.pages.LoginPage;

class UiLoginNegativeTest extends BaseUiTest {

  @Test
  void secondary_login_invalid_shows_error_message() {
    try {
      LoginPage login = new LoginPage(driver).open();
      login.typeUsername("standard_user")
          .typePassword("wrong_password")
          .submit();

      String error = login.readError();
      Assertions.assertTrue(error != null && !error.trim().isEmpty(), "Error message should be shown");
      Assertions.assertTrue(error.toLowerCase().contains("username and password"),
          "Error message should mention username and password");

    } catch (Exception e) {
      saveEvidenceOnFailure("secondary_login_invalid_shows_error_message", e);
    }
  }
}
