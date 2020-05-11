package Grid;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class GridNode {

    public static List<GridNode> nodesList = new ArrayList<>();
    public static boolean pathExist = false;

    public static int nodeCount = 1;

    protected boolean isObstacle;
    protected boolean isStart;
    protected boolean isEnd;

    public StackPane getPane() {
        return pane;
    }

    public void setPane(StackPane pane) {
        this.pane = pane;
    }

    public Image getImage() {
        return this.imageView.getImage();
    }

    protected StackPane pane;


    public String getName() {
        return name;
    }

    protected String name;

    protected double x, y;
    protected ImageView imageView;

    public GridNode(double x, double y, Image image) { //used only this
        this.x = x;
        this.y = y;
        pane = new StackPane();
        imageView = new ImageView();
        this.name = String.valueOf(nodeCount++);
        setPaneChild(image);
    }

    public void setPaneChild(Image image) {
        imageView.setImage(image);
        imageView.setVisible(image != GridImages.normal);
        pane.getChildren().clear();
        pane.getChildren().add(imageView);
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;

    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        if (start)
            setPaneChild(GridImages.robotImage());
        else
            setPaneChild(GridImages.normal);
        isStart = start;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        if (end)
            setPaneChild(GridImages.endImage());
        else
            setPaneChild(GridImages.normal);
        isEnd = end;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public void setObstacle(boolean obstacle) {
        if (obstacle)
            setPaneChild(GridImages.obstacleImage());
        else
            setPaneChild(GridImages.normal);
        isObstacle = obstacle;
    }

    public void setPathImage() {
        setPaneChild(GridImages.pathImage());
    }

    public static void resetAllPane() {
        for (GridNode gridNode : nodesList)
            if (gridNode.getImage() == GridImages.pathImage())
                gridNode.setPaneChild(GridImages.normal);
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

    public static GridNode getGridNodeByXY(double x, double y) {
        for (GridNode node : nodesList) {
            if (node.getX() == x && node.getY() == y) {
                return node;
            }
        }
        return null;


    }

}








