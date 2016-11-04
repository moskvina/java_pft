package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserDeletionTests extends TestBase {

    @Test
    public void testUserDeletion() {
      app.getNavigationHelper().goToHomePage();
      if (! app.getUserHelper().isThereAUser()) {
        app.getUserHelper().createUser(new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com", "testjane"), true);
      }
      app.getUserHelper().selectUser();
      app.getUserHelper().deleteSelectedUsers();
      app.getUserHelper().closeUserDeletionAlert();
      app.getNavigationHelper().goToHomePage();
    }



}
