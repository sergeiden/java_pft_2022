package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.testng.Assert.assertEquals;

public class GroupMultipleDeletionTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    app.goTo().groupPage();
    while (app.group().list().size() < 2) {
      app.group().create(new GroupData().withName("Test1"));
    }
  }

  @Test
  public void GroupMultipleDeletionTests() {
    Groups before = app.group().all();
    app.group().selectGroup(before.size() - 1);
    app.group().delete(before.size() - 2);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() - 2);
  }
}

