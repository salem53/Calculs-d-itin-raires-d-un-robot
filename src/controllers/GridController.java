package controllers;

import Algorithm.DisplayPath;
import Algorithm.FloydWarshall;
import Grid.GridNode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import utils.AlertWindow;
import utils.StartStage;

public class GridController {
    @FXML
    private Button resetButton;

    @FXML
    private void reset() throws Exception {
        GridNode.nodesList.clear();
        GridNode.pathExist=false;
        ((Stage) resetButton.getScene().getWindow()).close();
        new StartStage(new Stage());

    }

    @FXML
    private void execute() {
        if (GridNode.getStartingNode() == null ||
                GridNode.getEndingNode() == null) {
            new AlertWindow("Algorithm Error",
                    "You must specify the start or/and end of the path");
            return;
        }
        new FloydWarshall();
        new DisplayPath();
    }

    @FXML
    private void clearPath() {
        GridNode.resetAllPane();
        GridNode.pathExist=false;
    }

}
