package Algorithm;


import Grid.GridNode;
import javafx.scene.paint.Color;
import utils.ProjectColors;


public class DisplayPath {

    private final Color shortestPathColor = Color.INDIGO;

    public DisplayPath() {
        if (!FloydWarshall.isReachable) {
            //TODO
            System.out.println("cant display cause unreachable");
            return;
        }
        removeStartAndEndNodes();
        resetPathColoring();
        colorShortestPath();
    }

    private void removeStartAndEndNodes() {
        try {
            FloydWarshall.preds.remove(GridNode.getStartingNode().getName());
            FloydWarshall.preds.remove(GridNode.getEndingNode().getName());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    private GridNode getNodeByName(String s) {
        for (GridNode node : GridNode.nodesList) {
            if (node.getName().equals(s)) {
                return node;
            }
        }
        return null;
    }

    private void colorShortestPath() {
        for (int i = FloydWarshall.preds.size() - 1; i >= 0; i--) {
            try {
                getNodeByName(FloydWarshall.preds.get(i)).setColor(shortestPathColor);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    private void resetPathColoring() {
        for (GridNode node : GridNode.nodesList) {
            if (node.getColor() == ProjectColors.pathColor)
                node.setColor(Color.WHITESMOKE);
        }
    }
}
