package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.UserData;

/**
 * Created by jane on 10/31/16.
 */
public class UserHelper extends HelperBase {

  public UserHelper(FirefoxDriver wd) {
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

  public void fillUserForm(UserData userData) {
    type(By.name("firstname"), userData.getFirstname());
    type(By.name("lastname"), userData.getLastname());
    type(By.name("address"), userData.getAddress());
    type(By.name("home"), userData.getHomenumber());
    type(By.name("email"), userData.getEmail());
  }

  public void initUserCreation() {
      wd.findElement(By.linkText("add new")).click();
  }
}