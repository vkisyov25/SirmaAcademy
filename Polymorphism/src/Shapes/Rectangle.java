package Shapes;

public class Rectangle extends Shape{
    private  Double height;
    private  Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return (2*this.height)+(2*this.width);
    }

    @Override
    public double calculateArea() {
        return this.height*this.width;
    }
}
