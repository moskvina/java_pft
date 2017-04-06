package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by jane on 4/6/17.
 */

public class UserPhoneTests extends TestBase {

  @Test
  public void testUserPhones() {
    app.goTo().homePage();
    UserData user = app.user().all().iterator().next();
    UserData userInfoFromEditForm = app.user().infoFromEditForm(user);

    assertThat(user.getHomePhone(), equalTo(userInfoFromEditForm.getHomePhone()));
    assertThat(user.getMobilePhone(), equalTo(userInfoFromEditForm.getMobilePhone()));
    assertThat(user.getWorkPhone(), equalTo(userInfoFromEditForm.getWorkPhone()));
  }

}
