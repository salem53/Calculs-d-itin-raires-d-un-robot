package Grid;

import javafx.scene.shape.Circle;

public class GridSearch {
    public static GridNode lookForNode(javafx.scene.Node shape) {
        if (!(shape instanceof Circle)) return null;
        for (GridNode gridNode : GridNode.nodesList) {
            if (gridNode.getShape().equals(shape)) {
                return gridNode;
            }
        }
        return null;
    }
}
