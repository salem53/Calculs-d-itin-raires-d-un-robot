package main;

import javafx.application.Application;
import javafx.stage.Stage;
import utils.StartStage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        new StartStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

