package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withName("Ivan").withLname("Ivanov").withAddress("Lenina, 20-45").withHomePhone("926-525-25-25").withEmail("test@test.ru"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    app.goTo().homePage();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withName("Ivan").withLname("Petrov").withAddress("Lenina, 20-45").withHomePhone("009").withEmail("newmail@mail.ru");
    app.contact().modify(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}

