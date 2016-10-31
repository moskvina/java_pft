package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {
        app.getUserHelper().initUserCreation();
        app.getUserHelper().fillUserForm(new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com"));
        app.getUserHelper().submitUserCreation();
        app.getNavigationHelper().goToHomePage();
    }

}
