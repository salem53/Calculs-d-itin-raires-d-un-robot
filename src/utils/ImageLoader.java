package utils;

import controllers.StartController;
import javafx.scene.image.Image;

public class ImageLoader {

    public static Image loadImage(String name) {
        if (name.equals("path"))
            return new Image(String.format("Assets/ProjectImages/%s.png", name)
                    , StartController.CELL_SIZE - 40, StartController.CELL_SIZE - 40, false, true);
        return new Image(String.format("Assets/ProjectImages/%s.png", name)
                , StartController.CELL_SIZE - 20, StartController.CELL_SIZE - 20, false, true);
    }
}