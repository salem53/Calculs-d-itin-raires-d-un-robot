package Grid;

import javafx.scene.image.Image;
import utils.ImageLoader;

public class GridImages {


    public static Image robotImage(){ return ImageLoader.loadImage("robot"); }

    public static Image obstacleImage(){ return ImageLoader.loadImage("security"); }

    public static Image endImage(){ return ImageLoader.loadImage("finish"); }

    public static Image pathImage() { return ImageLoader.loadImage("path"); }

    public static Image normal = ImageLoader.loadImage("normal");


}
