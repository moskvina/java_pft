package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.ArrayList;
import java.util.List;

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

  public void selectUser(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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

  private void goToHomePage() {
    click(By.linkText("home"));
  }


  public void createUser(UserData user) {
    initUserCreation();
    fillUserForm(user, true);
    submitUserCreation();
    goToHomePage();
  }

    public void modifyUser(int index, UserData user) {
      selectUser(index);
      initUserModification();
      fillUserForm(user, false);
      submitUserModification();
      goToHomePage();
    }

  public void deleteUser(int index) {
    selectUser(index);
    deleteSelectedUsers();
    closeUserDeletionAlert();
    goToHomePage();
  }



  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getUserCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<UserData> getUserList() {
    List<UserData> users = new ArrayList<UserData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      UserData contact = new UserData(id, firstName, lastName, null, null, null, null);
      users.add(contact);
    }
    return users;
  }
}