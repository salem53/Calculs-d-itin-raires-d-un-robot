package Grid;

import javafx.scene.paint.Color;

public class SetupGridNodes {

    public SetupGridNodes(GridManager gridManager) {
        for (int i = 0; i < gridManager.getM(); i++) {
            for (int j = 0; j < gridManager.getN(); j++) {
                GridNode gridNode = new GridNode(i, j, GridImages.normal);
                GridNode.nodesList.add(gridNode);
                gridManager.addtogrid(gridNode.getPane(), i, j);
            }
        }
        //Setup events
        new GridCellEvent();
    }

}
