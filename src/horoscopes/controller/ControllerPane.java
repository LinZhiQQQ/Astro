package horoscopes.controller;

import horoscopes.view.DetailPane;
import horoscopes.view.Painting;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class ControllerPane extends Pane{
    Painting painting = new Painting();
    public ControllerPane() {
        //初始化初始数据
        try {
            painting.init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.getChildren().addAll(painting.bgv, painting.tv, painting.r1, painting.r2, painting.r3, painting.t1, painting.t2, painting.l1, painting.l2, painting.vbox, painting.vbox2, painting.btn, painting.btn2, painting.imgv, painting.text, painting.imgv2, painting.imgv3, painting.t3, painting.t4, painting.num, painting.t5, painting.theStar);

        // 配对按钮监听
        painting.btn2.setOnAction(e->{
            LocalDate date1 = painting.checkInDatePicker2.getValue();
            LocalDate date2 = painting.checkInDatePicker3.getValue();
            if(date1 == null || date2 == null){
                initChack();
            }else {
                painting.star1 = getStars(date1);
                painting.star2 = getStars(date2);
                painting.id1 = painting.map1.get(painting.star1);
                painting.id2 = painting.map1.get(painting.star2);
                painting.num.setText(""+checkIt(painting.star1, painting.star2));
                painting.btn.setVisible(true);
            }
        });
        painting.checkInDatePicker2.setOnAction(e->{
            LocalDate date = painting.checkInDatePicker2.getValue();
            if(date == null){
                initChack();
            }
        });
        painting.checkInDatePicker3.setOnAction(e->{
            LocalDate date = painting.checkInDatePicker3.getValue();
            if(date == null){
                initChack();
            }
        });
        painting.btn.setOnAction(e->{
            show(painting.id1, painting.id2);
        });
        // 查询监听
        painting.checkInDatePicker.setOnAction(e->{
            LocalDate date = painting.checkInDatePicker.getValue();
            initChange();
            if(date != null){
                painting.star = getStars(date);
                change(painting.star);
            }
        });
    }
    // 通过传入出生年月日 LocalDate对象 查询星座
    public String getStars(LocalDate date) {
        int tmp = date.getMonthValue() * 100 + date.getDayOfMonth();
        for(int i = 0;i < 13;i++){
            if(tmp < painting.dates[i]){
                return painting.stars[i];
            }
        }
        return null;
    }
    // 星座查询
    public void change(String s){
        int id = painting.map1.get(s);
        painting.theStar.setText(s);
        painting.theStar.setVisible(true);
        painting.imgv.setY(340);
        painting.imgv.setX(110);
        painting.imgv.setFitHeight(160);
        painting.imgv.setFitWidth(160);
        painting.imgv.setImage(new Image("horoscopes/model/image/" + id + ".gif"));
        painting.text.setText(painting.str[id]);
        painting.text.setVisible(true);
    }
    // 星座查询初始化
    public void initChange(){
        painting.imgv.setY(230);
        painting.imgv.setX(150);
        painting.imgv.setFitHeight(360);
        painting.imgv.setFitWidth(360);
        painting.imgv.setImage(new Image("horoscopes/model/image/all.gif"));
        painting.text.setVisible(false);
        painting.theStar.setVisible(false);
    }
    // 配对查询数据改变
    public int checkIt(String s1,String s2){
        int id1 = painting.map1.get(s1);
        int id2 = painting.map1.get(s2);
        int p = painting.arr[id2][id1];
        painting.t3.setVisible(true);
        painting.t4.setVisible(true);
        painting.t5.setVisible(true);
        painting.t3.setText("男生：" + s1);
        painting.t4.setText("女生：" + s2);
        painting.num.setX(800);
        painting.num.setFont(Font.font("等线", FontWeight.BOLD,50));
        painting.num.setFill(Color.rgb(255,59,48));
        painting.imgv2.setImage(new Image("horoscopes/model/image/" + id1 + ".gif"));
        painting.imgv3.setImage(new Image("horoscopes/model/image/" + id2 + ".gif"));
        return p;
    }
    // 初始化 配对查询
    public void initChack(){
        painting.num.setFont(Font.font("等线", FontWeight.BOLD,15));
        painting.num.setX(770);
        painting.num.setFill(Color.valueOf("#030303"));
        painting.num.setText("请选择双方生日");
        painting.t3.setVisible(false);
        painting.t4.setVisible(false);
        painting.t5.setVisible(false);
        painting.btn.setVisible(false);
        painting.imgv2.setImage(new Image("horoscopes/model/image/"));
        painting.imgv3.setImage(new Image("horoscopes/model/image/"));
    }
    public void show(int a,int b){
        Stage stage = new Stage();
        Scene scene;
        DetailPane detailPane = new DetailPane(a,b);
        scene = new Scene(detailPane,500,200);
        stage.setTitle("horoscopes");
        stage.setScene(scene);
        stage.show();
    }
}
