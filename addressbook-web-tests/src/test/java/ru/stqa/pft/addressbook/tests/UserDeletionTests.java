package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;
import java.util.Set;

public class UserDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.user().all().size() == 0) {
      app.user().create(new UserData()
              .withFirstname("Test1").withLastname("Test2").withAddress("Ukraine").withHomenumber("+3809711110001").withEmail("test@gmail.com").withGroup("testjane"));
    }
  }


  @Test
    public void testUserDeletion() {
      Set<UserData> before = app.user().all();
      UserData deletedUser = before.iterator().next();
      app.user().delete(deletedUser);
      Set<UserData> after = app.user().all();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(deletedUser);
      Assert.assertEquals(before, after);
      }

}
