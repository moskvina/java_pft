package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createUser(new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com", "testjane"));
    }
  }


  @Test
    public void testUserDeletion() {
      List<UserData> before = app.getUserHelper().getUserList();
      int index = before.size() - 1;
      app.getUserHelper().deleteUser(index);
      List<UserData> after = app.getUserHelper().getUserList();
      Assert.assertEquals(after.size(), index);

      before.remove(index);
      Assert.assertEquals(before, after);
      }

}
