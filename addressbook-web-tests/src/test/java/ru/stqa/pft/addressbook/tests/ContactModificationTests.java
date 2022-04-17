package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoHomePage();
    app.getContactHelper().modifyContact();
    app.getContactHelper().fillContactForm(new ContactData("IvanUpdate", "IvanovUpdated", "Lenina, 20-45Updated", "009", "newmail@mail.ru"));
    app.getContactHelper().updateContact();
  }
}