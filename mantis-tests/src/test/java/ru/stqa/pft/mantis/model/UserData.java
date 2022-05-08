package ru.stqa.pft.mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class UserData {

  @Id
  @Column(name = "id")
  private int id;
  @Column(name = "username")
  private String name;

  @Column(name = "email")
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public UserData withName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String toString() {
    return "UserData{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", id=" + id +
            '}';
  }

}
