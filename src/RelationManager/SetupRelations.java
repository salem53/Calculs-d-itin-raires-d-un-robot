package RelationManager;


import Grid.GridNode;

import java.util.List;
import java.util.ListIterator;

public class SetupRelations {

    public SetupRelations(List<GridNode> gridNodeList) {
        ListIterator<GridNode> listItr = gridNodeList.listIterator();
        ListIterator<GridNode> Itr = gridNodeList.listIterator();
        while (listItr.hasNext()) {
            GridNode hmm = listItr.next();
            if (!(hmm.isObstacle())) {
                while (Itr.hasNext()) {
                    GridNode yikes = Itr.next();
                    if (!(yikes.isObstacle())) {
                        if (IsNeighbor(hmm, yikes))
                            new Relation(hmm, yikes);
                    }
                }
            }
        }
        System.out.println("relation number:" + Relation.RelationsList);
    }

    public boolean IsNeighbor(GridNode s, GridNode e) {
        if ((s.getX() == e.getX()) && (s.getY() == e.getY() + 1))
            return true;
        if ((s.getX() == e.getX()) && (s.getY() == e.getY() - 1))
            return true;
        if ((s.getX() == e.getX() + 1) && (s.getY() == e.getY()))
            return true;
        if ((s.getX() == e.getX() - 1) && (s.getY() == e.getY()))
            return true;
        return false;
    }
}
