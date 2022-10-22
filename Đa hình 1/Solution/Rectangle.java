public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {

    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }


    /**
     * Constructor.
     * param
     * */
    public Rectangle(double width, double length, String color, boolean filled) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return (length + width) * 2;
    }

    /**
     * Hash code.
     * */
    @Override
    public String toString() {
        return "Rectangle[width="
                + width
                + ",length="
                + length
                + ",color="
                + color
                + ",filled="
                + filled
                + "]";
    }
}
