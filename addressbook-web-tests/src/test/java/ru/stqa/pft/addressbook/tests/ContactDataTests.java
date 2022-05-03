package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDataTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      ContactData contact = new ContactData().withName("Ivan").withLname("Ivanov").withHomePhone("111 55 78")
              .withMobilePhone("22002").withWorkPhone("333-00-11").withAddress("Moscow,\nLenina, 20-45")
              .withPhoto(new File("src/test/resources/Test.jpg"))
              .withEmail("test@test.ru").withEmail2("test2@bk.ru").withEmail3("test3@bk.ru");
      app.contact().create(contact);
    }
  }

  @Test
  public void testContactData() {
    app.goTo().homePage();
    ContactData contact = app.contact().allInfo().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return  Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactDataTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned (String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}