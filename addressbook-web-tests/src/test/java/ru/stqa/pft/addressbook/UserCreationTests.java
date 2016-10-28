package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {
        initUserCreation();
        fillUserForm(new UserData("Test1", "Test2", "Ukraine", "+3809711110001", "test@gmail.com"));
        submitUserCreation();
        goToHomePage();
    }

}
