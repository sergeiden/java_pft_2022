package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTestsFooter extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("Test1"));
    }
  }

  @Test
  public void testGroupDeletionFooter() {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().deleteFooter(deletedGroup);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size()-1);

    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}
