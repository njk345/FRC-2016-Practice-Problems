// Correct. Nice use of abstract classes
// Maybe space this file a bit better.
// Should be a newline between your methods and you member vars.
public abstract class Shape {
  public abstract double getPerimeter();
  public abstract double getArea();
  private String name;
  public Shape(String name) {
    this.name = name;
  }
  @Override
  public String toString() {
    return this.name + " || Perimeter = "
         + this.getPerimeter() + " || Area = "
         + this.getArea();
  }
}
