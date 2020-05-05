package Grid;

import Menu.DropDownMenu;
import controllers.GridController;
import controllers.StartController;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import main.Main;

public class GridCellEvent {

    public GridCellEvent() {
        for (Node node : StartController.gridManager.getGrid().getChildren()) {
            setOnRightClick(node);
        }
    }



    public void setOnRightClick(Node node) {
        node.setOnMousePressed((MouseEvent event) -> {
            if (event.getButton() == MouseButton.SECONDARY) {

                try {
                    new DropDownMenu(StartController.scene.getWindow(), event.getScreenX(), event.getScreenY(),node);
                }catch (Exception e)
                {System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");}
            }
        });
    }

}
