package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.user().list().size() == 0) {
      app.user().create(new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com", "testjane"));
    }
  }


  @Test
    public void testUserDeletion() {
      List<UserData> before = app.user().list();
      int index = before.size() - 1;
      app.user().delete(index);
      List<UserData> after = app.user().list();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(index);
      Assert.assertEquals(before, after);
      }

}
