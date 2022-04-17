package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupMultipleDeletionTests extends TestBase {

  @Test
  public void testGroupMultipleDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getNavigationHelper().isElementPresent(By.xpath("//div/div[4]/form/span[1]/input"))) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    if (! app.getNavigationHelper().isElementPresent(By.xpath("//div/div[4]/form/span[2]/input"))) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectSeveralGroups();
    app.getGroupHelper().deleteSelectedGroups();
  }
}