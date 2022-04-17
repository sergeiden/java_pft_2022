package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactlDeleteAllTests extends TestBase {

  @Test
  public void testDeleteAllContacts() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "Lenina, 20-45", "926-525-25-25", "test@test.ru"));
    }
    app.getContactHelper().selectAllContacts();
    app.getContactHelper().deleteContact();
    app.getContactHelper().acceptAlert();
  }
}

