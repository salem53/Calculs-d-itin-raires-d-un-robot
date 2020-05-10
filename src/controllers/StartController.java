package controllers;

import Grid.GridManager;
import Grid.SetupGridNodes;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.AlertWindow;

import java.io.IOException;


public class StartController {

    private static final int MIN_VALUE = 4;
    private static final int MAX_VALUE = 10;
    public static double CELL_SIZE = 100;
    public static Scene scene;
    public static final GridManager gridManager = new GridManager();

    @FXML
    private Button closeButton;
    @FXML
    private TextField width;
    @FXML
    private TextField height;

    @FXML
    private void close() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void confirm() throws IOException {
        if (isInputValid(width) && isInputValid(height)) {
            int widthValue = (Integer.parseInt(width.getText()));
            int heightValue = (Integer.parseInt(height.getText()));

            //make the grid
            Parent root = FXMLLoader.load(getClass().getResource("../views/grid.fxml"));
            Stage stage = new Stage();

            if (widthValue > 15 || heightValue > 7) {
                gridManager.makeGrid(CELL_SIZE - 30, heightValue, widthValue, 20);
                scene = new Scene(root,
                        (CELL_SIZE - 30) * widthValue + 40, (CELL_SIZE - 30) * heightValue + 96);
                StartController.CELL_SIZE -= 30;
            } else {
                gridManager.makeGrid(CELL_SIZE, heightValue, widthValue, 20);
                scene = new Scene(root,
                        CELL_SIZE * widthValue + 40, CELL_SIZE * heightValue + 96);
            }
            VBox vbox = (VBox) scene.lookup("#vbox");
            vbox.getChildren().add(gridManager.getGrid());
            new SetupGridNodes(gridManager);
            stage.setScene(scene);
            stage.setTitle("Robot Path Calculator");
            ((Stage) closeButton.getScene().getWindow()).close();
            stage.show();
        }
    }

    // Validates the user input.
    private boolean isInputValid(TextField t) {
        if (!(t.getText() == null || t.getText().length() == 0)) {
            try {
                int d = Integer.parseInt(t.getText());
                if (MIN_VALUE <= d && d <= MAX_VALUE) {
                    return true;
                } else {
                    new AlertWindow("Input Error", "Must be between 4 and 10");
                }
            } catch (NumberFormatException e) {
                new AlertWindow("Input Error","Must be between a number");
            }
        } else {
            new AlertWindow("Input Error", "You must choose width and height");
        }
        return false;
    }

}
