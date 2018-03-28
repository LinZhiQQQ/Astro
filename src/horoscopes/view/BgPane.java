package horoscopes.view;

import javafx.geometry.Orientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class BgPane extends FlowPane{
    BgPane(){
        this.setOrientation(Orientation.VERTICAL);
        Image image = new Image("horoscopes/model/image/bg.jpg");
        this.getChildren().add(new ImageView("horoscopes/model/image/bg.jpg"));
    }
}
