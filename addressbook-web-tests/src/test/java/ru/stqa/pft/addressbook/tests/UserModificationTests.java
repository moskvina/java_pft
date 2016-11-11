package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by jane on 10/31/16.
 */
public class UserModificationTests extends TestBase {

  @Test
  public void testUserModification() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createUser(new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com", "testjane"));
    }
    List<UserData> before = app.getUserHelper().getUserList();
    app.getUserHelper().selectUser(before.size() - 1);
    app.getUserHelper().initUserModification();
    UserData user = new UserData(before.get(before.size() - 1).getId(), "Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com", null);
    app.getUserHelper().fillUserForm(user, false);
    app.getUserHelper().submitUserModification();
    app.getNavigationHelper().goToHomePage();
    List<UserData> after = app.getUserHelper().getUserList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
