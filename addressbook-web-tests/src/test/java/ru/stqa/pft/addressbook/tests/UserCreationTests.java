package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
<<<<<<< HEAD:addressbook-web-tests/src/test/java/ru/stqa/pft/addressbook/tests/UserCreationTests.java
<<<<<<< HEAD:addressbook-web-tests/src/test/java/ru/stqa/pft/addressbook/tests/UserCreationTests.java
import ru.stqa.pft.addressbook.model.UserData;
=======
import static org.openqa.selenium.OutputType.*;
>>>>>>> parent of d722a60... UserCreationTests - refactoring:addressbook-web-tests/src/test/java/ru/stqa/pft/addressbook/UserCreationTests.java
=======
import static org.openqa.selenium.OutputType.*;
>>>>>>> parent of d722a60... UserCreationTests - refactoring:addressbook-web-tests/src/test/java/ru/stqa/pft/addressbook/UserCreationTests.java

public class UserCreationTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/index.php");
        login();
    }

    private void login() {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @Test
    public void testUserCreation() {
        initUserCreation();
        fillUserForm();
        submitUserCreation();
        returnToHomePage();
    }

    private void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void submitUserCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillUserForm() {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("Test1");
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).sendKeys("\\9");
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("Test2");
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys("Ukraine");
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys("+3809711110001");
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("test@gmail.com");
    }

    private void initUserCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
