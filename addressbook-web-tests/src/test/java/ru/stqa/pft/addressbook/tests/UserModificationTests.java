package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Set;

/**
 * Created by jane on 10/31/16.
 */
public class UserModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.user().all().size() == 0) {
      app.user().create(new UserData()
              .withFirstname("Test1").withLastname("Test2").withAddress("Ukraine").withHomenumber("+3809711110001").withEmail("test@gmail.com").withGroup("testjane"));
    }
  }

    @Test
    public void testUserModification() {
    Set<UserData> before = app.user().all();
      UserData modifiedUser = before.iterator().next();
      UserData user = new UserData().withId(modifiedUser.getId())
            .withFirstname("Test1").withLastname("Test2").withAddress("Ukraine").withHomenumber("+3809711110001").withEmail("test@gmail.com").withGroup("testjane");
      app.user().modify(user);
    Set<UserData> after = app.user().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedUser);
    before.add(user);
    Assert.assertEquals(before, after);
  }

}
