package horoscopes;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class MyPane extends Pane {
    MyPane() {
        BgPane p1 = new BgPane();
        CheckPane p2 = new CheckPane();
        this.getChildren().addAll(p1,p2);
    }
}
