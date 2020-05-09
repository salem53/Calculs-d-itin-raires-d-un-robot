package controllers;

import Algorithm.DisplayPath;
import Algorithm.FloydWarshall;
import Grid.GridNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.AlertWindow;

public class GridController {
    @FXML
    private Button resetButton;

    @FXML
    private void reset() throws Exception {
        GridNode.nodesList.clear();
        GridNode.pathExist=false;
        Stage startstage = new Stage();
        startstage.initStyle(StageStyle.TRANSPARENT);
        startstage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/start.fxml")), 762, 542));
        ((Stage) resetButton.getScene().getWindow()).close();
        startstage.show();

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
