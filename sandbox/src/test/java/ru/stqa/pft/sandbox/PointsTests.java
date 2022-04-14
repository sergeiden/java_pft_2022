package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointsTests {

  @Test
  public void testDistance1() {
    Point p1 = new Point(5,7);
    Point p2 = new Point(5,6);
    Assert.assertEquals(p1.distance(p2), 1.0);
  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(1,1);
    Assert.assertEquals(p1.distance(p1), 0.0);
  }

  @Test
  public void testDistance3() {
    Point p1 = new Point(0,1);
    Point p2 = new Point(0,0);
    Assert.assertEquals(p1.distance(p2), 1.0);
  }

  @Test
  public void testDistance4() {
    Point p1 = new Point(-1,-1);
    Point p2 = new Point(3,3);
    Assert.assertEquals(p1.distance(p2), 5.656854249492381);
  }
}