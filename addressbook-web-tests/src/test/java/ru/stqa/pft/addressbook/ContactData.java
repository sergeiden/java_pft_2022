package ru.stqa.pft.addressbook;

public class ContactData {
  private final String name;
  private final String lname;
  private final String address;
  private final String phone;
  private final String email;

  public ContactData(String name, String lname, String address, String phone, String email) {
    this.name = name;
    this.lname = lname;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getLname() {
    return lname;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }
}