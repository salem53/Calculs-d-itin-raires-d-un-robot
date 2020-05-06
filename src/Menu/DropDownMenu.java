package Menu;

import Algorithm.DisplayPath;
import Algorithm.FloydWarshall;
import Grid.GridNode;
import Grid.GridSearch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Window;
import utils.AlertWindow;
import utils.ProjectColors;


public class DropDownMenu {


    private final ContextMenu menu;
    /*private final String[] menuList = {"Set as obstacle", "Set as start", "Set as end", "delete node"};*/

    public DropDownMenu(Window window, double x, double y, Node node) {

        menu = new ContextMenu();
        menu.setAutoHide(true);
        GridNode gridNode = GridSearch.lookForNode(node);
        //add menuItem "set as obstacle" to the menu and handle it's event
        MenuItem menuItem1 = new MenuItem("Set as obstacle");
        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (GridNode.pathExist) {
                    new AlertWindow("GridEditing Error",
                            "You must clear the shortest path first because editing!");
                    return;
                }
                if (gridNode != null) {
                    if (!gridNode.isObstacle() && !gridNode.isStart() && !gridNode.isEnd()) {
                        gridNode.setColor(ProjectColors.obstacleColor);
                        gridNode.setObstacle(true);
                    } else
                        new AlertWindow("GridNode error", "Node isn't empty");

                } else {
                    new AlertWindow("error", "Unknown error");
                }

            }


        });
        //add menuItem "set as start" to the menu and handle it's event
        MenuItem menuItem2 = new MenuItem("Set as start");
        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (GridNode.pathExist) {
                    new AlertWindow("GridEditing Error",
                            "You must clear the shortest path first because editing!");
                    return;
                }
                if (gridNode != null) {
                    if (GridNode.getStartingNode() == null && !gridNode.isObstacle() && !gridNode.isEnd()) {
                        gridNode.setColor(ProjectColors.startColor);
                        gridNode.setStart(true);
                    } else if (GridNode.getStartingNode() != null) {
                        new AlertWindow("GridNode error", "Start node already exists");
                    } else
                        new AlertWindow("GridNode error", "Node isn't empty");

                } else {
                    new AlertWindow("error", "Unknown error");
                }

            }
        });
        //add menuItem "set as end" to the menu and handle it's event
        MenuItem menuItem3 = new MenuItem("Set as end");
        menuItem3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (GridNode.pathExist) {
                    new AlertWindow("GridEditing Error",
                            "The shortest path must be cleared");
                    return;
                }
                if (gridNode != null) {
                    if (GridNode.getEndingNode() == null && !gridNode.isObstacle() && !gridNode.isStart()) {
                        gridNode.setColor(ProjectColors.endColor);
                        gridNode.setEnd(true);
                    } else if (GridNode.getEndingNode() != null) {
                        new AlertWindow("GridNode error", "End node already exists");
                    } else
                        new AlertWindow("GridNode error", "Node isn't empty");
                } else {
                    new AlertWindow("error", "Unknown error");
                }

            }
        });
        //add menuItem "delete node" to the menu and handle it's event
        MenuItem menuItem4 = new MenuItem("delete node");
        menuItem4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (gridNode != null) {
                    if (!GridNode.pathExist) {
                        if (gridNode.isStart() || gridNode.isObstacle() || gridNode.isEnd()) {
                            gridNode.setColor(Color.WHITESMOKE);
                            gridNode.setStart(false);
                            gridNode.setEnd(false);
                            gridNode.setObstacle(false);

                        } else
                            new AlertWindow("GridNode error", "Node is already empty");

                    } else {
                        new AlertWindow("GridEditing error",
                                "The shortest path must be cleared");
                    }
                } else {
                    new AlertWindow("error", "Unknown error");
                }

            }
        });

        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        menu.getItems().add(menuItem3);
        menu.getItems().add(menuItem4);


        /*for (String text : menuList) {
            MenuItem menuItem = new MenuItem(text);
            menu.getItems().add(menuItem);
        }*/
        //show
        menu.show(window, x, y);
    }

    public ContextMenu getMenu() {
        return menu;
    }
}
