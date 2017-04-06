package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {
        app.goTo().homePage();
        Users before = app.user().all();
        UserData user = new UserData()
                .withFirstname("Test1").withLastname("Test2").withAddress("Ukraine").withHomenumber("+3809711110001").withEmail("test@gmail.com").withGroup("testjane");
        app.user().create(user);
      assertThat(app.user().count(), equalTo(before.size() + 1));
      Users after = app.user().all();
      assertThat(after, equalTo(
              before.withAdded(user.withId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt()))));

    }


  @Test
  public void testBadUserCreation() {
    app.goTo().homePage();
    Users before = app.user().all();
    UserData user = new UserData()
            .withFirstname("Test1'").withLastname("Test2").withAddress("Ukraine").withHomenumber("+3809711110001").withEmail("test@gmail.com").withGroup("testjane");
    app.user().create(user);
    assertThat(app.user().count(), equalTo(before.size()));
    Users after = app.user().all();
    assertThat(after, equalTo(before));
  }


}
