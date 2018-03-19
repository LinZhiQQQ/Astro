package horoscopes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene;
        MyPane mp = new MyPane();
        scene = new Scene(mp,1150,645);
        primaryStage.setTitle("horoscopes");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
