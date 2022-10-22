import java.util.List;

public class ShapeUtil {
    /**
     * Run process.
     * */
    public String printInfo(List<GeometricObject> shapes) {
        String result = "Circle:" + '\n';
        for (GeometricObject shape : shapes) {
            if (shape instanceof Circle) {
                result = result + shape.getInfo() + '\n';
            }
        }
        result = result + "Triangle:" + '\n';
        for (GeometricObject shape : shapes) {
            if (shape instanceof Triangle) {
                result = result + shape.getInfo() + '\n';
            }
        }
        return result;
    }
}
