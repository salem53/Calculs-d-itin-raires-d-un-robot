package Algorithm;


import Grid.GridNode;
import javafx.scene.paint.Color;


public class DisplayPath {

    private final Color shortestPathColor = Color.BLUE;

    public DisplayPath() {
        resetPathColoring();
        colorShortestPath();
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
            node.setColor(Color.WHITESMOKE);
        }
    }
}
