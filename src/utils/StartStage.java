package utils;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class StartStage extends Stage {
    private double xOffset = 0;
    private double yOffset = 0;

    public StartStage (Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/start.fxml"));
        //for a borderless window
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(new Scene(root, 762, 542));
        stage.show();

        //make the window movable
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }
}
