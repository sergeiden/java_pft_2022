package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().gotoContactForm();
        app.getContactHelper().fillContactForm(new ContactData("Ivan", "Ivanov", "Lenina, 20-45", "926-525-25-25", "testmail@mail.ru"));
        app.getContactHelper().submitContactForm();
        app.getContactHelper().returnToContactsPage();
    }
}