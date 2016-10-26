package ru.stqa.pft.sandbox;

public class MyFirstProgram {


  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Jane");


    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p1 = new Point(1, 6);
    Point p2 = new Point(4, 3);
    System.out.println("Расстояние между двумя точками:" + "(" + p1.x + "," + p1.y + ")" + " и " + "(" + p2.x + "," + p2.y + ")" + " = " + p2.distance(p1));



  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");

  }

  public static double area(Rectangle r){
    return  r.a * r.b;
  }


  public static double distance(Point p1, Point p2) {
    double x = p1.x - p2.x;
    double y = p1.y - p2.y;
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
  }
}