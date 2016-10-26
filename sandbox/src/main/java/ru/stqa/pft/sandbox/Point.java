package ru.stqa.pft.sandbox;

/**
 * Created by jane on 10/24/16.
 */
public class Point {
    public double x;
    public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p2) {
    double cat1 = this.x - p2.x;
    double cat2 = this.y - p2.y;
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
  }
}
