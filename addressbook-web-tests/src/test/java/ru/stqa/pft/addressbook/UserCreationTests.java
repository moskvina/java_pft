package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {
        app.initUserCreation();
        app.fillUserForm(new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com"));
        app.submitUserCreation();
        app.goToHomePage();
    }

}
