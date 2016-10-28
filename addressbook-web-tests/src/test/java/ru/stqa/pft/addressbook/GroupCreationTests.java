package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("testjane", "testjane1", "testjane2"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
