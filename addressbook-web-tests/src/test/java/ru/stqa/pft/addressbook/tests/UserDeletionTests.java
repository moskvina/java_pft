package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTests extends TestBase {

    @Test
    public void testUserDeletion() {
      app.getNavigationHelper().goToHomePage();
      if (! app.getUserHelper().isThereAUser()) {
        app.getUserHelper().createUser(new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com", "testjane"));
      }
      List<UserData> before = app.getUserHelper().getUserList();
      app.getUserHelper().selectUser(before.size() - 1);
      app.getUserHelper().deleteSelectedUsers();
      app.getUserHelper().closeUserDeletionAlert();
      app.getNavigationHelper().goToHomePage();
      List<UserData> after = app.getUserHelper().getUserList();
      Assert.assertEquals(after.size(), before.size() - 1);
    }



}
