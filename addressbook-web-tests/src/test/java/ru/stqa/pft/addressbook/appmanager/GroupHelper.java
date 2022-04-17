package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void initGroupModificationFooter() {
    click(By.xpath("//div/div[4]/form/input[6]"));
  }

  public void deleteSelectedGroupsFooter() {
    click(By.xpath("//div/div[4]/form/input[5]"));
  }

  public void initGroupCreationFooter() {
    click(By.xpath("//div/div[4]/form/input[4]"));
  }

  public void selectSeveralGroups() {
    click(By.xpath("//div/div[4]/form/span[1]/input"));
    click(By.xpath("//div/div[4]/form/span[2]/input"));
    click(By.xpath("//div/div[4]/form/span[3]/input"));
  }
}