package Algorithm;

import Grid.GridNode;
import Relation.Relation;
import javafx.scene.paint.Color;

public class TestAlgorithm {

    public TestAlgorithm() {
        GridNode node1 = new GridNode(0, 0, false, false
                , true, 3, Color.ALICEBLUE);
        GridNode node2 = new GridNode(0, 0, false, false
                , false, 3, Color.ALICEBLUE);
        GridNode node3 = new GridNode(0, 0, false, false
                , false, 3, Color.ALICEBLUE);
        GridNode node4 = new GridNode(0, 0, false, true
                , false, 3, Color.ALICEBLUE);


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
