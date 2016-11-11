package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {
        app.getNavigationHelper().goToHomePage();
        List<UserData> before = app.getUserHelper().getUserList();
        UserData user = new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com", "testjane");
        app.getUserHelper().createUser(user);
        List<UserData> after = app.getUserHelper().getUserList();
        Assert.assertEquals(after.size(), before.size() + 1);

      before.add(user);
      Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }
}
