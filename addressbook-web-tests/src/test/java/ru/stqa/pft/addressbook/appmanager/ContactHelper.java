package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToContactsPage() {
    wd.findElement(By.linkText("home page")).click();
  }

  public void submitContactForm() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());
  }

  public void gotoContactForm() {
    click(By.linkText("add new"));
  }

  public void deleteContact() {
    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  public void selectAllContacts() {
    click(By.id("MassCB"));
  }

  public void modifyContact() {
    click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
  }

  public void updateContact() {
    click(By.name("update"));
  }

  public void deleteUpdateContact() {
    click(By.xpath("//div/div[4]/form[2]/input[2]"));
  }

  public void gotoHomePage() {
    click(By.linkText("home"));
  }
}