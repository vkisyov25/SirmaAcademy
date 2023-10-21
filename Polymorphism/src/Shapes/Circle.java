package Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 *Math.PI * this.radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius,2);
    }
}
