package Algorithm;


import Grid.GridImages;
import Grid.GridNode;
import javafx.scene.control.Alert;
import utils.AlertWindow;


public class DisplayPath {

    public DisplayPath() {
        if (!FloydWarshall.isReachable) {
            new AlertWindow(Alert.AlertType.INFORMATION, "Information",
                    "Shortest Path Error",
                    "The end node is unreachable!");
            return;
        }
        GridNode.pathExist = true;
        removeStartAndEndNodes();
        GridNode.resetAllPane();
        colorShortestPath();
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

    public static void colorShortestPath() {
        for (int i = FloydWarshall.preds.size() - 1; i >= 0; i--) {
            try {
                getNodeByName(FloydWarshall.preds.get(i)).setPaneChild(GridImages.pathImage());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

}
