package Relation;

import Grid.GridNode;

import java.util.ArrayList;
import java.util.List;

public class Relation {

    public static List<Relation> RelationsList = new ArrayList<>();

    protected GridNode start;


    protected GridNode end;

    protected int transition;


    public Relation(GridNode s, GridNode e) {
        start = s;
        end = e;
        transition = 1;
        RelationsList.add(this);
    }


    public GridNode getStart() {
        return start;
    }

    public void setStart(GridNode start) {
        this.start = start;
    }

    public int getTransition() {
        return transition;
    }

    public void setTransition(int transition) {
        this.transition = transition;
    }

    public GridNode getEnd() {
        return end;
    }

    public void setEnd(GridNode end) {
        this.end = end;
    }


}
