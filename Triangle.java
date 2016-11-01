public class Triangle extends Shape {
	private double s1, s2, s3;
	public Triangle(double s1, double s2, double s3) {
		super(getTriangleType(s1, s2, s3));
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	public double getPerimeter() {
		return s1 + s2 + s3;
	}
	public double getArea() {
		//use Heron's formula
		double h = getPerimeter() / 2;
		return Math.sqrt(h*(h-s1)*(h-s2)*(h-s3));
	}
	private static String getTriangleType(double s1, double s2, double s3) {
		if (Double.compare(s1, s2) != 0 && Double.compare(s1, s3) != 0 && Double.compare(s2, s3) != 0) {
			return "Scalene";
		} else if (Double.compare(s1, s2) != 0 || Double.compare(s1, s2) != 0 || Double.compare(s2, s3) != 0) {
			return "Isoceles";
		} return "Equilateral";
	}
}