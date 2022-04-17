package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeleteViaUpdateTests extends TestBase {

  @Test
  public void testContactDeleteViaUpdate() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Ivan", "Ivanov", "Lenina, 20-45", "926-525-25-25", "test@test.ru"));
    }
    app.getContactHelper().modifyContact();
    app.getContactHelper().deleteUpdateContact();
  }
}

