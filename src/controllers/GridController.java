package controllers;

import Algorithm.DisplayPath;
import Algorithm.FloydWarshall;
import Grid.GridNode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Main;

public class GridController {
    @FXML
    private Button closeButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button executeButton;

    @FXML
    private void close() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void reset() throws Exception {
        GridNode.nodesList.clear();
        Stage stage = (Stage) resetButton.getScene().getWindow();
        Main main = new Main();
        main.start(stage);
    }

    @FXML
    private void execute() {
        new FloydWarshall();
        new DisplayPath();
    }

}
