package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GridController {


    @FXML
    private Button closeButton;

    @FXML
    private void close() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
