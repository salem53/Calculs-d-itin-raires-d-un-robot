package Algorithm;


import Grid.GridNode;
import javafx.scene.paint.Color;
import utils.ProjectColors;


public class DisplayPath {

    public DisplayPath() {
        if (!FloydWarshall.isReachable) {
            //TODO
            System.out.println("cant display cause unreachable");
            return;
        }
        GridNode.pathExist=true;
        removeStartAndEndNodes();
        resetPathColoring();
        colorShortestPath(ProjectColors.pathColor);
    }

    public void removeStartAndEndNodes() {
        try {
            FloydWarshall.preds.remove(GridNode.getStartingNode().getName());
            FloydWarshall.preds.remove(GridNode.getEndingNode().getName());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static GridNode getNodeByName(String s) {
        for (GridNode node : GridNode.nodesList) {
            if (node.getName().equals(s)) {
                return node;
            }
        }
        return null;
    }

    public static void colorShortestPath(Color color) {
        for (int i = FloydWarshall.preds.size() - 1; i >= 0; i--) {
            try {
                getNodeByName(FloydWarshall.preds.get(i)).setColor(color);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public static void resetPathColoring() {
        colorShortestPath(ProjectColors.emptyColor);
    }
}
