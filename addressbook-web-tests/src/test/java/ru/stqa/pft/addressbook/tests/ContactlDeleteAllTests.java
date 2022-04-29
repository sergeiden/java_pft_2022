package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class ContactlDeleteAllTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withName("Ivan").withLname("Ivanov").withAddress("Lenina, 20-45").withHomePhone("926-525-25-25").withEmail("test@test.ru"));
    }
  }

  @Test
  public void testDeleteAllContacts() {
    app.contact().deleteAll();
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertEquals(after, Collections.emptySet());
  }
}

