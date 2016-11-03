package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by jane on 10/31/16.
 */
public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    getElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = getElement(locator).getAttribute("value");
      if (! text.equals(existingText)) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
      }
      }
    }

  private WebElement getElement(By locator) {
    return wd.findElement(locator);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
