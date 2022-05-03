package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactAddToGroupTests extends TestBase {
  @BeforeMethod
  public void insurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Test1"));
    }

    Contacts contacts = app.db().contacts();
    ContactData contactToAdd = new ContactData();
    for (ContactData contact : contacts) {
      if (contact.getGroups().size() == 0) {
        contactToAdd = contact;
      }
    }
    if (contactToAdd.getId() == 0) {
      ContactData contact = new ContactData().withName("Add").withLname("ToGroup");
      app.goTo().homePage();
      app.contact().create(contact);
    }
  }

  @Test
  public void testContactAddToGroup() {
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    ContactData contactToAdd = new ContactData();
    for (ContactData contact : contacts) {
      if (contact.getGroups().size() == 0) {
        contactToAdd = contact;
      }
    }
    GroupData groupToAddTo = groups.iterator().next();
    Groups groupsBefore = contactToAdd.getGroups();
    app.goTo().homePage();
    app.contact().addContactToGroup(contactToAdd.getId(), groupToAddTo.getName());

    Groups groupsAfter = new Groups();
    contacts = app.db().contacts();
    for (ContactData contact : contacts){
      if (contact.getId() == contactToAdd.getId()){
        groupsAfter = contact.getGroups();
      }
    }
    assertThat(groupsAfter, equalTo(groupsBefore.withAdded(groupToAddTo)));
  }
}