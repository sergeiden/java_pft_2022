package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {
  @Expose
  @Column(name = "group_name")
  private String name;
  @Expose
  @Column(name = "group_header")
  @Type(type = "text")
  private String header;
  @Expose
  @Column(name = "group_footer")
  @Type(type = "text")
  private String footer;
  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id;

  @ManyToMany (fetch = FetchType.EAGER, mappedBy = "groups")
  private Set<ContactData> contacts = new HashSet<ContactData>();

  public Contacts getContacts() {
    return new Contacts(contacts);
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  public int getId() {
    return id;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + id;
    return result;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}