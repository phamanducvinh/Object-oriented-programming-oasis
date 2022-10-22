public class Square extends Rectangle {
    public Square() {

    }

    public Square(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     * Constructor.
     */
    public Square(double side, String color, boolean filled) {
        this.length = side;
        this.width = side;
        this.color = color;
        this.filled = filled;
    }

    /**
     * Constructor.
     *
     * @param topLeft Point
     * @param side    double
     * @param color   String
     * @param filled  boolean
     */
    public Square(Point topLeft, double side, String color, boolean filled) {
        this.topLeft = topLeft;
        this.length = side;
        this.width = side;
        this.color = color;
        this.filled = filled;
    }

    public double getSide() {
        return this.length;
    }

    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    @Override
    public void setWidth(double side) {
        this.setSide(side);
    }

    @Override
    public void setLength(double side) {
        this.setSide(side);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Square) {
            Square square = (Square) o;
            return this.topLeft.equals(square.topLeft)
                    && Math.abs(getSide() - square.getSide()) <= 0.001;
        }
        return false;
    }

    @Override
    public boolean isDuplicated(Object o) {
        return this.equals(o);
    }

    /**
     * Get to string.
     * */
    @Override
    public String toString() {
        return "Square[topLeft="
                + topLeft.toString()
                + ",side="
                + width
                + ",color="
                + color
                + ",filled="
                + filled
                + "]";
    }
}
