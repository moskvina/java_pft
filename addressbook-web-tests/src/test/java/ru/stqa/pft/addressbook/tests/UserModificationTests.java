package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by jane on 10/31/16.
 */
public class UserModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.user().list().size() == 0) {
      app.user().create(new UserData()
              .withFirstname("Test1").withLastname("Test2").withAddress("Ukraine").withHomenumber("+3809711110001").withEmail("test@gmail.com").withGroup("testjane"));
    }
  }

    @Test
    public void testUserModification() {
    List<UserData> before = app.user().list();
      int index = before.size() - 1;
    UserData user = new UserData().withId(before.get(index).getId())
            .withFirstname("Test1").withLastname("Test2").withAddress("Ukraine").withHomenumber("+3809711110001").withEmail("test@gmail.com").withGroup("testjane");
      app.user().modify(index, user);
    List<UserData> after = app.user().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
