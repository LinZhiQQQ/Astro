package horoscopes.view;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Painting {
    public Label text = new Label();
    public ImageView imgv,imgv2,imgv3,bgv,tv;
    public String star,star1,star2,Line;
    public String[] str,stars;
    public HashMap<String , Integer> map1 = new HashMap<String, Integer>(); // 星座->编号
    public int arr[][],dates[],id1,id2;
    public Text theStar,t1,t2,t3,t4,t5,num;
    public Rectangle r1,r2,r3;
    public javafx.scene.shape.Line l1,l2;
    public VBox vbox,vbox2;
    public Button btn;
    public Button btn2;
    public Image img,img2,img3,bg,title;
    public DatePicker checkInDatePicker,checkInDatePicker2,checkInDatePicker3;

    public Painting(){
        bg = new Image("horoscopes/model/image/a.png");
        bgv = new ImageView(bg);
        bgv.setX(0);
        bgv.setY(0);
        bgv.setFitHeight(90);
        bgv.setFitWidth(1160);
        title = new Image("horoscopes/model/image/zxdf.png");
        tv = new ImageView(title);
        tv.setY(0);
        tv.setX(460);
        tv.setFitWidth(200);
        tv.setFitHeight(100);
        r1 = new Rectangle();
        r1.setX(100);
        r1.setY(100);
        r1.setWidth(420);
        r1.setHeight(500);
        r1.setFill(Color.valueOf("#B0E2FF"));
        r1.setArcHeight(20);
        r1.setArcWidth(20);
        r1.setOpacity(0.8);
        r2 = new Rectangle();
        r2.setX(620);
        r2.setY(100);
        r2.setWidth(420);
        r2.setHeight(500);
        r2.setFill(Color.valueOf("#FFE1FF"));
        r2.setArcHeight(20);
        r2.setArcWidth(20);
        r2.setOpacity(0.8);
        r3 = new Rectangle();
        r3.setX(955);
        r3.setY(100);
        r3.setWidth(180);
        r3.setHeight(500);
        r3.setFill(Color.valueOf("#CAE1FF"));
        r3.setArcHeight(20);
        r3.setArcWidth(20);
        r3.setVisible(false);
        t1 = new Text("星座查询");
        t1.setX(250);
        t1.setY(135);
        t1.setFont(Font.font("微软雅黑", FontWeight.BOLD,25));
        t1.setFill(Color.valueOf("#383838"));
        t2 = new Text("缘分查询");
        t2.setX(770);
        t2.setY(135);
        t2.setFont(Font.font("微软雅黑", FontWeight.BOLD,25));
        t2.setFill(Color.valueOf("#383838"));
        l1 = new Line();
        l1.setStartX(100);
        l1.setStartY(150);
        l1.setEndX(520);
        l1.setEndY(150);
        l2 = new Line();
        l2.setStartX(620);
        l2.setStartY(150);
        l2.setEndX(1040);
        l2.setEndY(150);
        // 星座查询
        vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        vbox.setLayoutX(180);
        vbox.setLayoutY(160);
        checkInDatePicker = new DatePicker();
        String pattern = "yyyy-MM-dd";
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        Label checkInlabel = new Label("请选择你的阳历出生日期:");
        checkInlabel.setFont(Font.font("等线", FontWeight.NORMAL, 15));
        gridPane.add(checkInlabel, 0, 0);
        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        checkInDatePicker.setMinWidth(250);
        checkInDatePicker.setMinHeight(30);
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        checkInDatePicker.setConverter(converter);
        checkInDatePicker.setPromptText(pattern.toLowerCase());
        gridPane.add(checkInDatePicker, 0, 1);
        vbox.getChildren().add(gridPane);
        // 缘分测试
        vbox2 = new VBox(20);
        vbox2.setStyle("-fx-padding: 10;");
        vbox2.setLayoutX(685);
        vbox2.setLayoutY(160);
        checkInDatePicker2 = new DatePicker();
        checkInDatePicker3 = new DatePicker();
        GridPane gridPane2 = new GridPane();
        gridPane2.setHgap(20);
        gridPane2.setVgap(20);
        Label checkInlabel2 = new Label("请选择男方的阳历出生日期:");
        Label checkInlabel3 = new Label("请选择女方的阳历出生日期:");
        checkInlabel2.setFont(Font.font("等线", FontWeight.NORMAL, 15));
        checkInlabel3.setFont(Font.font("等线", FontWeight.NORMAL, 15));
        gridPane2.add(checkInlabel2, 0, 0);
        gridPane2.add(checkInlabel3, 0, 2);
        gridPane2.add(checkInDatePicker2,0,1);
        gridPane2.add(checkInDatePicker3,0,3);
        checkInDatePicker2.setMinWidth(250);
        checkInDatePicker2.setMinHeight(30);
        checkInDatePicker3.setMinWidth(250);
        checkInDatePicker3.setMinHeight(30);
        vbox2.getChildren().add(gridPane2);
        checkInDatePicker2.setConverter(converter);
        checkInDatePicker2.setPromptText(pattern.toLowerCase());
        checkInDatePicker3.setConverter(converter);
        checkInDatePicker3.setPromptText(pattern.toLowerCase());
        Image bimg = new Image("horoscopes/model/image/love.png");
        btn2 = new Button();
        btn2.setStyle("-fx-base: #ee2211;");
        btn2.setGraphic(new ImageView(bimg));
        btn2.setText("缘分测试");
        btn2.setLayoutX(780);
        btn2.setLayoutY(380);
        btn2.setMinWidth(40);
        btn2.setMinHeight(35);
        btn = new Button();
        btn.setText("查看详情");
        btn.setVisible(false);
        btn.setStyle("-fx-base: #ee2211;");
        btn.setLayoutX(798);
        btn.setLayoutY(560);
        btn.setMinWidth(40);
        btn.setMinHeight(35);
        img = new Image("horoscopes/model/image/all.gif");
        imgv = new ImageView(img);
        imgv.setY(235);
        imgv.setX(130);
        imgv.setFitHeight(370);
        imgv.setFitWidth(370);
        text.setLayoutX(285);
        text.setLayoutY(330);
        text.setMaxWidth(200);
        text.setWrapText(true);
        text.setFont(Font.font("等线", FontWeight.NORMAL,13));
        text.setTextFill(Color.BLACK);
        img2 = new Image("horoscopes/model/image/");
        imgv2 = new ImageView(img2);
        imgv2.setY(410);
        imgv2.setX(600);
        imgv2.setFitHeight(180);
        imgv2.setFitWidth(180);
        img3 = new Image("horoscopes/model/image/");
        imgv3 = new ImageView(img2);
        imgv3.setY(410);
        imgv3.setX(870);
        imgv3.setFitHeight(180);
        imgv3.setFitWidth(180);
        theStar = new Text("");
        theStar.setX(340);
        theStar.setY(300);
        theStar.setFont(Font.font("等线", FontWeight.BOLD,25));
        theStar.setFill(Color.valueOf("#030303"));
        theStar.setVisible(false);
        t3 = new Text("");
        t3.setX(670);
        t3.setY(400);
        t3.setFont(Font.font("等线", FontWeight.BOLD,14));
        t3.setFill(Color.valueOf("#030303"));
        t3.setVisible(false);
        t4 = new Text("");
        t4.setX(920);
        t4.setY(400);
        t4.setFont(Font.font("等线", FontWeight.BOLD,14));
        t4.setFill(Color.valueOf("#030303"));
        t4.setVisible(false);
        t5 = new Text("配对指数");
        t5.setX(780);
        t5.setY(550);
        t5.setFont(Font.font("等线", FontWeight.BOLD,25));
        t5.setFill(Color.valueOf("#030303"));
        t5.setVisible(false);
        num = new Text("");
        num.setX(770);
        num.setY(500);
        num.setFont(Font.font("等线", FontWeight.BOLD,50));
    }
    //初始化数据
    public void init() throws FileNotFoundException {
        str = new String[13];
        stars = new String[13];
        arr = new int[13][13];
        dates = new int[13];
        String record = null;
        int recCount = 0;
        try {
            FileReader fr = new FileReader("src/horoscopes/model/data/stars_t.txt");
            BufferedReader br = new BufferedReader(fr);
            record = new String();
            while ((record = br.readLine()) != null) {
                if(recCount < 13){
                    str[recCount++] = new String(record);
                }else if (recCount < 26){
                    stars[recCount - 13] = new String(record);
                    recCount++;
                }else{
                    dates[recCount - 26] = Integer.valueOf(record);
                    recCount++;
                }
            }
            br.close();
            fr.close();
            fr = new FileReader("src/horoscopes/model/data/stars_p.txt");
            br = new BufferedReader(fr);
            recCount = 0;
            while ((record = br.readLine()) != null) {
                String[] dictionary =  record.split("[\\t \\n]+");
                for(int i=0;i<dictionary.length;i++){
                    arr[recCount ][i] = Integer.valueOf(dictionary[i]);
                }
                recCount++;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Uh oh, got an IOException error!");
            e.printStackTrace();
        }
        for(int i = 1;i <= 12;i++){
            map1.put(stars[(i + 2) % 12],i);
        }
    }
}
