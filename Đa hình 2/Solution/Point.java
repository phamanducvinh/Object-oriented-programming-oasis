public class Point {
    private final double exp = 0.001;
    private double pointX;
    private double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return this.pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return this.pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    private double sqr(double value) {
        return value * value;
    }

    public double distance(Point other) {
        return Math.sqrt(sqr(pointX - other.pointX) + sqr(pointY - other.pointY));
    }

    /**
     * equals.
     *
     * @param o object to compare
     * @return true if equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point oth = (Point) o;
            return Math.abs(getPointX() - oth.getPointX()) <= exp
                    && Math.abs(getPointY() - oth.getPointY()) <= exp;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "(" + pointX + "," + pointY + ")";
    }

}
