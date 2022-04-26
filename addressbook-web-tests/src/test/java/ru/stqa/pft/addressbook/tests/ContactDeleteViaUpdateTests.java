package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeleteViaUpdateTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withName("Ivan").withLname("Ivanov").withAddress("Lenina, 20-45").withPhone("926-525-25-25").withEmail("test@test.ru"));
    }
  }

  @Test
  public void testContactDeleteViaUpdate() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().modifyContactById(deletedContact.getId());
    app.contact().deleteUpdateContact();
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size()-1);

    assertThat(after, equalTo(before.without(deletedContact)));
  }
}

