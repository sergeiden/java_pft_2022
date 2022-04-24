package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.List;

public class GroupMultipleDeletionTests extends TestBase {

  @Test
  public void GroupMultipleDeletionTests() {
    app.getNavigationHelper().gotoGroupPage();
    while (app.getGroupHelper().getGroupCount() < 2) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().selectGroup(before.size() - 2);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 2);
  }
}
