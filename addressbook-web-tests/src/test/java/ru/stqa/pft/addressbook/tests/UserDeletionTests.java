package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class UserDeletionTests extends TestBase {

    @Test
    public void testUserDeletion() {
      app.goToHomePage();
      app.selectUser();
      app.deleteSelectedUsers();
      app.goToHomePage();
    }

}
