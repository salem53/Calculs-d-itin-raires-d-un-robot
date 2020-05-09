package Grid;

import Menu.DropDownMenu;
import controllers.GridController;
import controllers.StartController;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import main.Main;

import java.util.Stack;

public class GridCellEvent {

    public GridCellEvent() {
        for (GridNode gridNode : GridNode.nodesList) {
            setOnRightClick(gridNode.getPane());
        }
    }


    public void setOnRightClick(StackPane node) {
        node.setOnMousePressed((MouseEvent event) -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                new DropDownMenu(StartController.scene.getWindow(), event.getScreenX(), event.getScreenY(), node);
            }
        });
    }

}
