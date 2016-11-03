package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;

/**
 * Created by jane on 10/31/16.
 */
public class UserHelper extends HelperBase {

  public UserHelper(WebDriver wd) {
    super(wd);

  }

  public void deleteSelectedUsers() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void selectUser() {
    wd.findElement(By.name("selected[]")).click();
  }

  public void submitUserCreation() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillUserForm(UserData userData, boolean creation) {
    type(By.name("firstname"), userData.getFirstname());
    type(By.name("lastname"), userData.getLastname());
    type(By.name("address"), userData.getAddress());
    type(By.name("home"), userData.getHomenumber());
    type(By.name("email"), userData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void initUserCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void initUserModification() {
    wd.findElement(By.xpath("//img[@title=\"Edit\"]")).click();
  }

  public void submitUserModification() {
    click(By.name("update"));
  }

  public void closeUserDeletionAlert() {
    wd.switchTo().alert().accept();
  }
}
