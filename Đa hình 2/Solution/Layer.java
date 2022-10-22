import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Remove circle.
     */
    public void removeCircles() {
        List<Shape> newShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (!(shape instanceof Circle)) {
                newShapes.add(shape);
            }
        }
        shapes = newShapes;
    }

    /**
     * Get info.
     */
    public String getInfo() {
        String result = "Layer of crazy shapes:";
        result = result + "\n";
        for (Shape shape : shapes) {
            result = result + shape.toString();
            result = result + "\n";
        }
        return result;
    }

    /**
     * Factory.
     * remove duplicates
     */
    public void removeDuplicates() {
        List<Shape> newShapes = new ArrayList<>();
        boolean[] isDuplicated = new boolean[shapes.size()];
        for (int i = 0; i < shapes.size(); ++i) {
            isDuplicated[i] = false;
        }
        for (int i = 0; i < shapes.size(); ++i) {
            for (int j = i + 1; j < shapes.size(); ++j) {

                if (shapes.get(i).isDuplicated(shapes.get(j))) {
                    isDuplicated[j] = true;
                }
            }
        }

        for (int i = 0; i < shapes.size(); ++i) {
            if (!isDuplicated[i]) {
                newShapes.add(shapes.get(i));
            }
        }
        shapes = newShapes;
    }
}
