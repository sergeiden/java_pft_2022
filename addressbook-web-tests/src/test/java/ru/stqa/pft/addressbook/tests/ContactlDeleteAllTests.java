package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactlDeleteAllTests extends TestBase {

  @Test
  public void testDeleteAllContacts() {
    app.getContactHelper().gotoHomePage();
    app.getContactHelper().selectAllContacts();
    app.getContactHelper().deleteContact();
    app.getContactHelper().acceptAlert();
  }
}