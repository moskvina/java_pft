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

  public UserData infoFromEditForm(UserData user) {
    initUserModificationById(user.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new UserData().withId(user.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  private void initUserModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

//    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

}