package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

/**
 * Created by jane on 10/31/16.
 */
public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification() {
    app.getNavigationHelper().goToHomePage();
    app.getUserHelper().selectUser();
    app.getUserHelper().initUserModification();
    app.getUserHelper().fillUserForm(new UserData("Test1", null, null, null, null));
    app.getUserHelper().submitUserModification();
    app.getNavigationHelper().goToHomePage();
  }
}
