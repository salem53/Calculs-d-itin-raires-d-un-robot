package utils;

import javafx.scene.control.Alert;

public class AlertWindow {

    public AlertWindow(Alert.AlertType alertType, String title,
                       String headerText, String contextTest, boolean showAndAwait) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contextTest);
        if (showAndAwait)
            alert.showAndWait();

    }

    public AlertWindow(Alert.AlertType alertType, String title,
                       String headerText, String contextTest) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contextTest);
        alert.showAndWait();

    }

    public AlertWindow(String headerText, String contextTest) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(headerText);
        alert.setContentText(contextTest);
        alert.showAndWait();

    }


}
