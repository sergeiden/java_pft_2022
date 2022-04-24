package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String lname;
  private final String name;
  private final String address;
  private final String phone;
  private final String email;

  public ContactData(String name, String lname, String address, String phone, String email) {
    this.id = 0;
    this.name = name;
    this.lname = lname;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  public ContactData(int id, String name, String lname, String address, String phone, String email) {
    this.id = id;
    this.name = name;
    this.lname = lname;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", lname='" + lname + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  public int getId() {
    return id;
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

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (lname != null ? lname.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}