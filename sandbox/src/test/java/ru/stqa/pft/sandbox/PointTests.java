package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by jane on 10/31/16.
 */
public class PointTests {

  @Test
  public void distance(){
    Point p1 = new Point(2, 8);
    Point p2 = new Point(3, 3);
    assert p1.distance(p2) == 8.246211251235321;
  }

  @Test
  public void distance2(){
    Point p1 = new Point(2, 8);
    Point p2 = new Point(3, 3);
    Assert.assertEquals(p1.distance(p2), 8.246211251235321);
  }


  @Test
  public void tochka(){
    Point p1 = new Point(2, 8);
    Point p2 = new Point(3, 3);
    Assert.assertEquals(p1.y, 8.0);
  }
}