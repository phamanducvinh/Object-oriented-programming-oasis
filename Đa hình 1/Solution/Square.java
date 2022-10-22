public class Square extends Rectangle {
    public Square(){
    }

    public Square(double side) {
        this.width = side;
        this.length = side;
    }

    /**
     * Constructor.
     * */
    public Square(double side, String color, boolean filled) {
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

    /**
     * Hash code.
     * */
    @Override
    public String toString() {
        return "Square[side="
                + getSide()
                + ",color="
                + color
                + ",filled="
                + filled
                + "]";
    }
}
