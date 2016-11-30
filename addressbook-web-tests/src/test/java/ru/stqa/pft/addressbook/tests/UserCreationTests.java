package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {
        app.goTo().homePage();
        List<UserData> before = app.user().list();
        UserData user = new UserData()
                .withFirstname("Test1").withLastname("Test2").withAddress("Ukraine").withHomenumber("+3809711110001").withEmail("test@gmail.com").withGroup("testjane");
        app.user().create(user);
        List<UserData> after = app.user().list();
        Assert.assertEquals(after.size(), before.size() + 1);

      before.add(user);
      Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }
}
