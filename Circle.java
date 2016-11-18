// Correct. Nice work.
public class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
