public class Circle extends Shape {
    private final double pi = 3.14159;
    protected double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor.
     * @param radius double
     * @param color String
     * @param filled boolean
     * */
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
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
     * Hash code.
     * */
    @Override
    public String toString() {
        return "Circle[radius="
                + radius
                + ",color="
                + color
                + ",filled="
                + filled
                + "]";
    }
}
