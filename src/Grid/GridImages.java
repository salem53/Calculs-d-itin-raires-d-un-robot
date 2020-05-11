package Grid;

import javafx.scene.image.Image;
import utils.ImageLoader;

public class GridImages {


    public void initImages() {
        robotImage = ImageLoader.loadImage("robot");
        obstacleImage = ImageLoader.loadImage("security");
        endImage = ImageLoader.loadImage("finish");
        pathImage = ImageLoader.loadImage("path");
        normal = ImageLoader.loadImage("normal");
    }

    public static Image robotImage;


    public static Image obstacleImage;


    public static Image endImage;


    public static Image pathImage;


    public static Image normal;


}
