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
    if (! app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createUser(new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com", "testjane"), true);
    }
    app.getUserHelper().selectUser();
    app.getUserHelper().initUserModification();
    app.getUserHelper().fillUserForm(new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com", null), false);
    app.getUserHelper().submitUserModification();
    app.getNavigationHelper().goToHomePage();
  }
}
