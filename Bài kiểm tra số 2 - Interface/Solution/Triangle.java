public class Triangle implements GeometricObject {
    private final Point p1;
    private final Point p2;
    private final Point p3;

    /**
     * Constructor.
     */
    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        if (this.getArea() == 0) {
            throw new RuntimeException();
        }
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }


    /**
     * Get area.
     * */
    @Override
    public double getArea() {
        return Math.abs((p2.getPointX() - p1.getPointX()) * (p2.getPointY() + p1.getPointY())
                + (p3.getPointX() - p2.getPointX()) * (p3.getPointY() + p2.getPointY())
                + (p1.getPointX() - p3.getPointX()) * (p3.getPointY() + p1.getPointY())) / 2.0;
    }

    @Override
    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    private String getString(double value) {
        return String.format("%.2f", value);
    }

    /**
     * get info.
     * */
    @Override
    public String getInfo() {
        return "Triangle[("
                + getString(p1.getPointX())
                + ","
                + getString(p1.getPointY())
                + "),"
                + "("
                + getString(p2.getPointX())
                + ","
                + getString(p2.getPointY())
                + "),"
                + "("
                + getString(p3.getPointX())
                + ","
                + getString(p3.getPointY())
                + ")]";
    }
}
