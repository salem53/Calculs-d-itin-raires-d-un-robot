package Grid;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class GridNode {

    public static List<GridNode> nodesList = new ArrayList<>();
    public static int startNodeCount =0;
    public static int  endNodeCount =0 ;

    public static int nodeCount = 1;

    protected boolean isObstacle;
    protected boolean isStart;
    protected boolean isEnd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String name;

    protected double x, y, shapeSize;
    protected Circle shape;


    public GridNode(double x, double y,
                    double radius, Color color) { //used only this
        this.x = x;
        this.y = y;
        this.isObstacle = isObstacle;
        this.isStart = isStart;
        this.isEnd = isEnd;
        this.name = String.valueOf(nodeCount++);
        constructShape(radius, color);
        

    }

    public void constructShape(double radius, Color color) {
        shape = new Circle();
        shapeSize = radius;
        shape.setRadius(shapeSize);
        shape.setFill(color);
    }


    public void setSize(int size) {
        shapeSize = size;
        shape.setRadius(shapeSize);
    }

    public void setColor(int red, int green, int blue) {
        shape.setFill(Color.rgb(red, green, blue));

    }
    
    public void setColor(Color color) {
        shape.setFill(color);

    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        shape.setCenterX(x);
    }

    public double getY() {
        return y;

    }

    public void setY(int y) {
        this.y = y;
        shape.setCenterY(y);
    }

    public Circle getShape() {
        return shape;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public void setObstacle(boolean obstacle) {
        isObstacle = obstacle;
    }

    public static GridNode getStartingNode() {
        for (GridNode node : nodesList) {
            if (node.isStart) {
                return node;
            }
        }
        return null;
    }

    public static GridNode getEndingNode() {
        for (GridNode node : nodesList) {
            if (node.isEnd) {
                return node;
            }
        }
        return null;
    }
    public static GridNode getGridNodeByXY(double x , double y ){
        for (GridNode node : nodesList) {
            if (node.getX()==x && node.getY()==y) {
                return node;
            }
        }
        return null;


    }

}








