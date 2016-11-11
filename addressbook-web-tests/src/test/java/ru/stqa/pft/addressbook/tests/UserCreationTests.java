package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

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
        int max = 0;
        for (UserData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        user.setId(max);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
