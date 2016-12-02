package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {
        app.goTo().homePage();
        Set<UserData> before = app.user().all();
        UserData user = new UserData()
                .withFirstname("Test1").withLastname("Test2").withAddress("Ukraine").withHomenumber("+3809711110001").withEmail("test@gmail.com").withGroup("testjane");
        app.user().create(user);
        Set<UserData> after = app.user().all();
        Assert.assertEquals(after.size(), before.size() + 1);

      user.withId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt());
      before.add(user);
      Assert.assertEquals(before, after);
    }
}
