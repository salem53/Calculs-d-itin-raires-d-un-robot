package Algorithm;

import Grid.GridNode;
import RelationManager.Relation;
import javafx.scene.paint.Color;

public class TestAlgorithm {

    public TestAlgorithm() {
        GridNode node1 = new GridNode(0, 0, 3, Color.ALICEBLUE);
        GridNode node2 = new GridNode(0, 0, 3, Color.ALICEBLUE);
        GridNode node3 = new GridNode(0, 0, 3, Color.ALICEBLUE);
        GridNode node4 = new GridNode(0, 0, 3, Color.ALICEBLUE);

        node1.setStart(true);
        node4.setEnd(true);
        GridNode.nodesList.add(node1);
        GridNode.nodesList.add(node2);
        GridNode.nodesList.add(node3);
        GridNode.nodesList.add(node4);

        new Relation(GridNode.nodesList.get(0),
                GridNode.nodesList.get(1));
        new Relation(GridNode.nodesList.get(0),
                GridNode.nodesList.get(2));
        new Relation(GridNode.nodesList.get(2),
                GridNode.nodesList.get(1));
        new Relation(GridNode.nodesList.get(2),
                GridNode.nodesList.get(3));


        new FloydWarshall();
        new DisplayPath();
    }

}
