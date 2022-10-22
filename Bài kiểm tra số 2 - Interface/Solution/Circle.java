public class Circle implements GeometricObject {
    public static final double PI = 3.14;
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (radius * radius) * PI;
    }

    @Override
    public double getPerimeter() {
        return (radius * 2.0) * PI;
    }

    private String getString(double value) {
        return String.format("%.2f", value);
    }

    /**
     * get info.
     * */
    @Override
    public String getInfo() {
        return "Circle[("
                + getString(center.getPointX())
                + ","
                + getString(center.getPointY())
                + "),"
                + "r="
                + getString(radius)
                + "]";
    }
}
