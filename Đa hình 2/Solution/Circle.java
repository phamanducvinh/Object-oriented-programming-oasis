public class Circle extends Shape {

    private final double pi = 3.14159265;
    protected Point center;
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor.
     * radius color filled
     */
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    /**
     * Constructor.
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.filled = filled;
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
        return (this.radius * this.radius) * this.pi;
    }

    @Override
    public double getPerimeter() {
        return (this.radius * 2.0) * this.pi;
    }

    /**
     * Is duplicated.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            Circle circle = (Circle) o;
            return center.equals(circle.center)
                    && Math.abs(radius - circle.radius) <= 0.001;
        }
        return false;
    }

    @Override
    public boolean isDuplicated(Object o) {
        return this.equals(o);
    }

    public int hashCode() {
        return 0;
    }

    /**
     * To string.
     */
    @Override
    public String toString() {
        return "Circle[center="
                + center.toString()
                + ",radius="
                + radius
                + ",color="
                + color
                + ",filled="
                + filled
                + "]";
    }
}
