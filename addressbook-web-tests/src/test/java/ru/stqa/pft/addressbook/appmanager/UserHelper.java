package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

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

  public void selectUserById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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


  public void create(UserData user) {
    initUserCreation();
    fillUserForm(user, true);
    submitUserCreation();
    userCache = null;
    goToHomePage();
  }

    public void modify(UserData user) {
      selectUserById(user.getId());
      initUserModification();
      fillUserForm(user, false);
      submitUserModification();
      userCache = null;
      goToHomePage();
    }

  public void delete(UserData user) {
    selectUserById(user.getId());
    deleteSelectedUsers();
    closeUserDeletionAlert();
    userCache = null;
    goToHomePage();
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }


  private Users userCache = null;

  public Users all() {
    if (userCache != null) {
      return new Users(userCache);
    }

    userCache = new Users();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      userCache.add(new UserData().withId(id).withFirstname(firstName).withLastname(lastName));
    }
    return new Users(userCache);
  }

}