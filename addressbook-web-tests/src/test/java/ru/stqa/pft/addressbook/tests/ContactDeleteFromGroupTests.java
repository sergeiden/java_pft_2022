package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteFromGroupTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Test1"));
    }
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    ContactData contactToRemove = new ContactData();
    for (ContactData contact : contacts) {
      if (contact.getGroups().size() > 0) {
        contactToRemove = contact;
      }
    }
    if (contactToRemove.getGroups().size() == 0) {
      ContactData contact = new ContactData().withName("Test").withLname("Testov").inGroup(groups.iterator().next());
      app.goTo().homePage();
      app.contact().create(contact);
    }
  }

  @Test
  public void testContactDeleteFromGroup() {
    Contacts contacts = app.db().contacts();
    ContactData contactToRemove = new ContactData();
    for (ContactData contact : contacts) {
      if (contact.getGroups().size() > 0) {
        contactToRemove = contact;
      }
    }
    GroupData groupToRemoveFrom = contactToRemove.getGroups().iterator().next();
    Contacts contactsBefore = groupToRemoveFrom.getContacts();
    app.goTo().homePage();
    app.contact().removeContactFromGroup(contactToRemove.getId(), groupToRemoveFrom.getName());

    Contacts contactsAfter = new Contacts();
    Groups groups = app.db().groups();
    for (GroupData group : groups){
      if (group.getId() == groupToRemoveFrom.getId()){
        contactsAfter = group.getContacts();
      }
    }
    assertThat(contactsAfter, equalTo(contactsBefore.without(contactToRemove)));
  }
}