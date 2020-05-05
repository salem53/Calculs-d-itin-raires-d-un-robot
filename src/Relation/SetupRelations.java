package Relation;


import Grid.GridNode;

import java.util.ListIterator;

import static Grid.GridNode.nodesList;

public class SetupRelations {
    
    public SetupRelations() {
        ListIterator<GridNode> listItr = nodesList.listIterator();
        ListIterator<GridNode> Itr = nodesList.listIterator();
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
