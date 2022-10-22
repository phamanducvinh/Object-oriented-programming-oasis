public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius) {
        setRadius(radius);
    }

    public Cylinder(double radius, double height) {
        setRadius(radius);
        this.height = height;
    }

    /**
     * Constructor.
     *
     * @param radius double
     * @param height double
     * @param color String
     * */
    public Cylinder(double radius, double height, String color) {
        setRadius(radius);
        this.height = height;
        setColor(color);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ",height=" + height + "]";
    }
}
