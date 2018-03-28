package horoscopes.view;

import horoscopes.controller.ControllerPane;
import javafx.scene.layout.Pane;

public class MyPane extends Pane {
    public MyPane() {
        BgPane p1 = new BgPane();
        ControllerPane p2 = new ControllerPane();
        this.getChildren().addAll(p1,p2);
    }
}
