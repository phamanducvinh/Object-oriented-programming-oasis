public class Rectangle extends Shape {
    protected Point topLeft;
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
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    /**
     * Constructor.
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
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
     * Equals.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) o;
            return this.topLeft.equals(rectangle.topLeft)
                    && Math.abs(width - rectangle.width) <= 0.001
                    && Math.abs(length - rectangle.length) <= 0.001;
        }
        return false;
    }

    @Override
    public boolean isDuplicated(Object o) {
        return this.equals(o);
    }

    /**
     * To string.
     */
    @Override
    public String toString() {
        return "Rectangle[topLeft="
                + topLeft.toString()
                + ",width="
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
