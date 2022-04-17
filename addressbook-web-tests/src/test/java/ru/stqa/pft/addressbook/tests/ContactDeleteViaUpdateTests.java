package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeleteViaUpdateTests extends TestBase {

  @Test
  public void testContactDeleteViaUpdate() {
    app.getContactHelper().gotoHomePage();
    app.getContactHelper().modifyContact();
    app.getContactHelper().deleteUpdateContact();
  }
}