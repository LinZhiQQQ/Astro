package horoscopes;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DetailPane extends Pane {
    public static String detail[][][];
    DetailPane(int a,int b){
        Image bg = new Image("horoscopes/image/bg2.jpg");
        ImageView bgv = new ImageView(bg);
        bgv.setX(0);
        bgv.setY(0);
        Label text1 = new Label(detail[a][b][0]);
        Label text2 = new Label(detail[a][b][1]);
        text1.setLayoutX(180);
        text1.setLayoutY(20);
        text1.setFont(Font.font("等线", FontWeight.BOLD,18));
        text1.setTextFill(Color.valueOf("#FFFFFF"));
        text2.setLayoutX(25);
        text2.setLayoutY(60);
        text2.setMaxWidth(450);
        text2.setWrapText(true);
        text2.setFont(Font.font("等线", FontWeight.BOLD,14));
        text2.setTextFill(Color.valueOf("#FFFFFF"));
        this.getChildren().addAll(bgv,text1,text2);
    }

    static {
        detail = new String[13][13][2];
        try {
            for(int i = 1;i <= 12;i++){
                FileReader fr = new FileReader("src/horoscopes/source/" + i + ".txt");
                BufferedReader br = new BufferedReader(fr);
                String record = new String();
                int recCount = 1;
                int flag = 0;
                while ((record = br.readLine()) != null) {
                    detail[i][recCount][flag] = record;
                    if(flag == 1){
                        recCount++;
                        flag = 0;
                    }else{
                        flag = 1;
                    }
                }
                br.close();
                fr.close();
            }
        } catch (IOException e) {
            System.out.println("Uh oh, got an IOException error!");
            e.printStackTrace();
        }
    }
}
