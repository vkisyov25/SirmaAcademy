package Shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Circle circle = new Circle(5.0);
        Shape circle1 = new Circle(5.0);
        System.out.println(circle1.calculateArea());
        System.out.println(circle1.calculatePerimeter());
        //Rectangle rectangle = new Rectangle(5.0, 6.0);
        Shape rectangle1 = new Rectangle(5.0,6.0);
        System.out.println(rectangle1.calculateArea());
        System.out.println(rectangle1.calculatePerimeter());
    }

}
