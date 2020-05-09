package Grid;

import javafx.scene.layout.StackPane;


public class GridSearch {
    public static GridNode lookForNode(StackPane pane) {
        for (GridNode gridNode : GridNode.nodesList) {
            if (gridNode.getPane() == pane) {
                return gridNode;
            }
        }
        return null;
    }
}
