package RelationManager;

import Grid.GridNode;

import java.util.List;
import java.util.ListIterator;

public class SetupRelations {

    public SetupRelations(List<GridNode> gridNodeList) {
        Relation.RelationsList.clear();
        for (GridNode node1 : gridNodeList) {
            if (!node1.isObstacle()) {
                for (GridNode node2 : gridNodeList) {
                    if (!(node2.isObstacle())) {
                        if (IsNeighbor(node1, node2))
                            new Relation(node1, node2);
                    }
                }
            }
        }
    }

    public boolean IsNeighbor(GridNode s, GridNode e) {
        boolean b = false;
        if (((int) s.getX() == (int) e.getX()) && ((int) s.getY() == (int) e.getY() + 1)) {
            b = true;
        }

        if (((int) s.getX() == (int) e.getX()) && ((int) s.getY() == (int) e.getY() - 1)) {
            b = true;
        }

        if (((int) s.getX() == (int) e.getX() + 1) && ((int) s.getY() == e.getY())) {
            b = true;
        }

        if (((int) s.getX() == (int) e.getX() - 1) && ((int) s.getY() == (int) e.getY())) {
            b = true;
        }
        return b;

    }
}
