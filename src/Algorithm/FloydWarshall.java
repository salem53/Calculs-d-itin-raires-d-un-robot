package Algorithm;

import Grid.GridNode;
import RelationManager.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FloydWarshall {

    private final int size;

    public static boolean isReachable = true;

    private HashMap<GridNode, List<Relation>> dict = new HashMap<>();

    private String[][] P;

    public String[][] getP() {
        return P;
    }

    private int[][] distance;

    public int[][] getDistance() {
        return distance;
    }

    public static List<String> preds = new ArrayList<>();

    private List<GridNode> gridNodeCopy = new ArrayList<>();

    public FloydWarshall() {
        preds.clear();
        copyToList();
        new SetupRelations(gridNodeCopy);
        System.out.println("relation list size:" + Relation.RelationsList.size());
        this.size = gridNodeCopy.size();
        P = new String[size + 1][size + 1];
        distance = new int[size][size];

        initFloyd();
    }

    private void copyToList() {
        for (GridNode gridNode : GridNode.nodesList) {
            if (!gridNode.isObstacle()) {
                gridNodeCopy.add(gridNode);
            }
        }
    }

    private void initFloyd() {
        P[0][0] = " ";
        for (int i = 1; i < size + 1; i++) {
            P[i][0] = gridNodeCopy.get(i - 1).getName();
            P[0][i] = gridNodeCopy.get(i - 1).getName();
        }
        for (Relation relation : Relation.RelationsList) {
            if (!dict.containsKey(relation.getStart())) {
                dict.put(relation.getStart(), new ArrayList<>());
            }
            dict.get(relation.getStart()).add(relation);
        }
        ConstructArray(gridNodeCopy, Relation.RelationsList);
    }

    private final int INF = Integer.MAX_VALUE;

    private void ConstructArray(List<GridNode> nodesList, List<Relation> relationsList) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                boolean verif = false;
                if (i == j) {
                    distance[i][j] = 0;
                    continue;
                }
                for (Relation relation : relationsList) {
                    if (relation.getStart() == nodesList.get(i) &&
                            relation.getEnd() == nodesList.get(j)) {
                        distance[i][j] = relation.getTransition();
                        verif = true;
                        break;
                    }
                }
                if (!verif) {
                    distance[i][j] = INF;
                }

            }
        }

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {

                if (distance[i][j] == INF) {
                    P[i + 1][j + 1] = "0";
                } else {
                    P[i + 1][j + 1] = nodesList.get(i).getName();
                }
            }
        }
        executeFloyd(nodesList, relationsList);
        ExtractPath(GridNode.getStartingNode(), GridNode.getEndingNode());
        displayPath();

    }


    private void executeFloyd(List<GridNode> nodesList, List<Relation> relationsList) {
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (distance[i][k] == INF || distance[k][j] == INF)
                        continue;
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        P[i + 1][j + 1] = P[k + 1][j + 1];
                    }
                }
            }


            /*
            For testing purposes
            printDistance();
            printP();
            System.out.print("\n\n");
            */

        }


    }

    //For testing purposes, display distance matrix
    private void printDistance() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (distance[i][j] == INF) {
                    System.out.print("INF ");
                    continue;
                }
                System.out.print(distance[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    //For testing purposes, display P matrix
    private void printP() {
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                System.out.print(P[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private int beginIndex;
    private int endIndex;

    public void ExtractPath(GridNode start, GridNode end) {
        for (int i = 0; i < size + 1; i++) {
            if (P[i][0].equals(start.getName())) {
                beginIndex = i;
                break;
            }
        }
        for (int i = 1; i < size + 1; i++) {
            if (P[0][i].equals(end.getName())) {
                endIndex = i;
                break;
            }
        }
        preds.add(end.getName());


        while (true) {
            String pred = P[beginIndex][endIndex];
            if (pred.equals("0")) {
                //TODO make a window appear that handles the error of no path existence
                System.out.println("Unreachable!");
                isReachable = false;
                return;
            }
            if (pred.equals(start.getName())) {
                preds.add(start.getName());
                return;
            }
            for (int i = 1; i < size + 1; i++) {
                if (P[0][i].equals(pred)) {
                    endIndex = i;
                    preds.add(pred);
                    break;
                }
            }


        }

    }

    //for testing purposes, display path in console
    private void displayPath() {
        for (int i = preds.size() - 1; i >= 0; i--) {
            System.out.print(preds.get(i) + " ");
        }
    }


}
