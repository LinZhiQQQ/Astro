package horoscopes;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.HPos;

import java.time.LocalDate;
import java.util.*;

public class CheckPane extends Pane{
    Label text = new Label();
    ImageView imgv,imgv2,imgv3;
    String star,star1,star2;
    String[] str;
    HashMap<String , Integer> map1 = new HashMap<String, Integer>(); // 星座->编号
    int arr[][];
    Text theStar,t1,t2,t3,t4,t5,num;
    Rectangle r1,r2,r3;
    Line l1,l2;
    VBox vbox,vbox2;
    Button btn,btn2;
    Image img,img2,img3;

    CheckPane() {
        //初始化初始数据
        init();
        // 画图部分
        Pane these = this;
        Image bg = new Image("horoscopes/image/a.png");
        ImageView bgv = new ImageView(bg);
        bgv.setX(0);
        bgv.setY(0);
        bgv.setFitHeight(90);
        bgv.setFitWidth(1160);

        Image title = new Image("horoscopes/image/zxdf.png");
        ImageView tv = new ImageView(title);
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

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4,0.4,0.4));

        r1.setEffect(ds);

        r2 = new Rectangle();
        r2.setX(620);
        r2.setY(100);
        r2.setWidth(420);
        r2.setHeight(500);
        r2.setFill(Color.valueOf("#FFE1FF"));
        r2.setArcHeight(20);
        r2.setArcWidth(20);

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
        t1.setFont(Font.font("null", FontWeight.BOLD,25));
        t1.setFill(Color.valueOf("#383838"));

        t2 = new Text("缘分查询");
        t2.setX(770);
        t2.setY(135);
        t2.setFont(Font.font("null", FontWeight.BOLD,25));
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
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        vbox.setLayoutX(180);
        vbox.setLayoutY(160);
        DatePicker checkInDatePicker = new DatePicker();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        Label checkInlabel = new Label("请选择你的阳历出生日期:");
        checkInlabel.setFont(Font.font("等线", FontWeight.NORMAL, 15));
        gridPane.add(checkInlabel, 0, 0);

        GridPane.setHalignment(checkInlabel, HPos.LEFT);

        checkInDatePicker.setMinWidth(250);
        checkInDatePicker.setMinHeight(30);


        gridPane.add(checkInDatePicker, 0, 1);
        vbox.getChildren().add(gridPane);

        // 缘分测试
        VBox vbox2 = new VBox(20);
        vbox2.setStyle("-fx-padding: 10;");
        vbox2.setLayoutX(685);
        vbox2.setLayoutY(160);
        DatePicker checkInDatePicker2 = new DatePicker();
        DatePicker checkInDatePicker3 = new DatePicker();
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



        Image bimg = new Image("horoscopes/image/love.png");
        btn2 = new Button();
        btn2.setStyle("-fx-base: #ee2211;");
        btn2.setGraphic(new ImageView(bimg));
        btn2.setText("缘分测试");
        btn2.setLayoutX(780);
        btn2.setLayoutY(380);
        btn2.setMinWidth(40);
        btn2.setMinHeight(35);

        img = new Image("horoscopes/image/all.gif");
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

        img2 = new Image("horoscopes/image/");
        imgv2 = new ImageView(img2);
        imgv2.setY(410);
        imgv2.setX(600);
        imgv2.setFitHeight(180);
        imgv2.setFitWidth(180);

        img3 = new Image("horoscopes/image/");
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

        this.getChildren().addAll(bgv,tv,r1,r2,r3,t1,t2,l1,l2,vbox,vbox2,btn2,imgv,text,imgv2,imgv3,t3,t4,num,t5,theStar);
        // 配对按钮监听
        btn2.setOnAction(e->{
            LocalDate date1 = checkInDatePicker2.getValue();
            LocalDate date2 = checkInDatePicker3.getValue();
            if(date1 == null || date2 == null){
                initChack();
            }else {
                star1 = getStars(date1);
                star2 = getStars(date2);
                num.setText(""+checkIt(star1,star2));
            }

        });

        // 查询监听
        checkInDatePicker.setOnAction(e->{
            LocalDate date = checkInDatePicker.getValue();
            initChange();
            if(date != null){
                star = getStars(date);
                change(star);
            }
        });

    }


    // 通过传入出生年月日 LocalDate对象 查询星座
    public String getStars(LocalDate date) {
        String str = null;
        if(check(3,21,4,20,date)){
            str = "白羊座";
        }else if(check(4,21,5,20,date)){
            str = "金牛座";
        }else if(check(5,21,6,21,date)){
            str = "双子座";
        }else if(check(6,22,7,22,date)){
            str = "巨蟹座";
        }else if(check(7,23,8,22,date)){
            str = "狮子座";
        }else if(check(8,23,9,22,date)){
            str = "室女座";
        }else if(check(9,23,10,22,date)){
            str = "天平座";
        }else if(check(10,23,11,22,date)){
            str = "天蝎座";
        }else if(check(11,23,12,21,date)){
            str = "射手座";
        }else if(check(12,22,1,19,date)){
            str = "摩羯座";
        }else if(check(1,20,2,18,date)){
            str = "水瓶座";
        }else if(check(2,19,3,20,date)){
            str = "双鱼座";
        }
        return str;
    }

    // 传入 开始日期和结束日期 和 生日 ，判断是否在这个时间段内
    public boolean check(int a,int b,int c,int d,LocalDate date){
        if(a > b){  // 交换日期顺序
            a ^= c;
            c ^= a;
            a ^= c;
            b ^= d;
            d ^= b;
            b ^= d;
        }
        if((date.getMonthValue() == a && date.getDayOfMonth() >= b) || (date.getMonthValue() == c && date.getDayOfMonth() <= d)){
            return true;
        }
        return false;
    }


    // 星座查询
    public void change(String s){
        int id = map1.get(s);
        theStar.setText(s);
        theStar.setVisible(true);
        imgv.setY(340);
        imgv.setX(110);
        imgv.setFitHeight(160);
        imgv.setFitWidth(160);
        System.out.println(id);
        imgv.setImage(new Image("horoscopes/image/" + id + ".gif"));
        text.setText(str[id]);
        text.setVisible(true);
    }
    // 星座查询初始化
    public void initChange(){
        imgv.setY(230);
        imgv.setX(150);
        imgv.setFitHeight(360);
        imgv.setFitWidth(360);
        imgv.setImage(new Image("horoscopes/image/all.gif"));
        text.setVisible(false);
        theStar.setVisible(false);
    }


    // 配对查询数据改变
    public int checkIt(String s1,String s2){
        int id1 = map1.get(s1);
        int id2 = map1.get(s2);
        int p = arr[id2][id1];
        t3.setVisible(true);
        t4.setVisible(true);
        t5.setVisible(true);
        t3.setText("男生:" + s1);
        t4.setText("女生:" + s2);
        num.setX(800);
        num.setFont(Font.font("Times New Roman", FontWeight.BOLD,50));
        imgv2.setImage(new Image("horoscopes/image/" + id1 + ".gif"));
        imgv3.setImage(new Image("horoscopes/image/" + id2 + ".gif"));
        return p;
    }

    // 初始化 配对查询
    public void initChack(){
        num.setFont(Font.font("Times New Roman", FontWeight.BOLD,15));
        num.setX(770);
        num.setText("请选择双方生日");
        t3.setVisible(false);
        t4.setVisible(false);
        t5.setVisible(false);
        imgv2.setImage(new Image("horoscopes/image/"));
        imgv3.setImage(new Image("horoscopes/image/"));

    }



    //初始化数据
    public void init(){
        str = new String[]{
                "",
                "你大方、明朗，全身充满活力。不管跟什么人，你都能很快的和他打成一片。虽然你十分热情，却缺乏协调性格，容易我行我素，因而发生争执。你做事不拘小节、好动、喜欢群居生活。而且你爱好自由，讨厌受拘束。你是富正义感、积极、果断的理想追求者。还有你爱帮助弱者，有亲切而勇敢的领导能力。你非常有朝气而且精力旺盛，只展示自己好的一面。",
                "你不但好学、知识丰富，还很会发挥你优秀的头脑。温和、顺从是你最明显的个性。你很勤奋，肯脚踏实地的努力。不过你有点消极。虽然不很出色，但你温柔而体贴的性格却十分的吸引人。你信念强、能够对抗虚伪和欺诈，持有高洁的信念。因为你富于童心，所以很乐于追求新鲜的生活。你现实而且朴素，还很守本分，勤苦地开拓前途，是个表现真实自我的类型。",
                "嗯，你善于说服别人，还是个很好的倾听者。你很会照顾朋友，不过希望你别再为小事生气哦！热情、罗曼蒂克的你，总有众多的追求者你具有双重推断的头脑及优异的口才能力。你善于临机应变，富于机智，笔墨和言辞兼备。由于你对各式各样的事都很关心，为人又很热心，所以为十二星座中双重人格最显着的类型。双子座是好奇心很强的智慧星。",
                "巨蟹座的你不但想像力丰富，而且有很强的理解力。你坦白、大方、正直、忠于朋友。还有你十分善于理财、也很会存钱。你有一种母性的防卫能力和不挑剔朋友的顺应性。你很会模仿，并能在模仿中创造出新的东西来。对人过于同情时，你会变成双重性格，因为你感情脆弱，一听到对方的不幸，心就软了下来，同情会改变你对他人的看法。",
                "你有着崇高的理想，为人慷慨、有恻隐心、具幽默感，所以会吸引很多人。只要你决定一件事，就不会接受别人的意见。择善固执虽然好，但也该有接受别人意见的雅量。谦虚一点、学习忍耐，不要太骄傲吧！你个性明朗、干脆，具有火焰般的热情。在你类似首领的领导者气质之下，有一颗浮燥，且容易感到寂寞的心。虽然你平时做事很紧张、积极，但一做错了什么，就容易垂头丧气。你对人的态度也是忽好忽坏。",
                "你生来就具有艺术家的特质。你对色彩感觉丰富、有音乐欣赏力。你是个认真而害羞、脚踏实地的人。你注重细节又手巧，从小就很会整顿事情，能用手把脑子里的构思一个一个实现出来。你做事认真、很守信用，不过有时也会任性、情绪不稳定。你害羞、不善于表达自己的感情，有着纤细的感受性。你重视秩序，对于善恶、正邪，有锐利的批判力。你是所有星座中最单纯的，不但口不出恶言，而且行为端正，但由于过于清高，有时反而会得罪人。",
                "你精力充沛、兴趣广泛、喜欢活动。你从不缺乏交往的物件，是生活在热闹中的人。你很会体贴别人、刻意追求美和正义、不喜欢争执。你公正、有理性、重视友情。虽然偶尔会任性一点，不过通常你冷静而崇尚调和，对任何事都不会狂热。你具有对人生所有经验都能理解的均衡人生观和处世态度。你是双重人格的星座。因为你迷迷糊糊的，自己都不了解自己，所以呈现双重人格，自己也不晓得。",
                "你是个热情而乐天、不喜欢欺骗、而且很专心的人。你总能积极抓住属于你的幸运。你看起来很安静，其实你头脑很棒，而且对任何事都很热心。你超有耐性的。平常给人的感觉是慎重、沉默寡言，可是事实上是怎么样的闷骚你自己知道吧？！你洞察力很锐利，无聊时就喜欢暗地里观察别人。你不会受任何阻碍所迷惑，很专情，而且你很会选择理想的伴侣。大多人都觉得你善嫉妒、有强烈的独占欲。建议你找一些适合自己的兴趣，抒发自己过于专注的个性及占有欲，才不会给别人太大的压力哦。",
                "你自尊心、适应力强，遇到困难时，会有条有理地处理。诚实、可信赖、头脑好是你的优点。你会带给人快乐！你兴趣广泛。虽然你会插手管无聊的事，不过还好啦，你会反省，找出自己该做的事，然后成为了不起的人物。此外，你具有正义感和爱捉弄人的双重性格，是个憎恨束缚，爱好自由的乐天派。你在日常生活及重视金钱的社会里得不到满足。 ",
                "你不喜欢出风头，而且很现实。你喜欢清纯的爱，即使是小小的幸福，也会使你感到很大的喜悦。你保守而驯良，崇尚整洁及秩序，而且你具有诚实的责任感及强烈的耐力。你有一种确定目的后便不离放的忍耐精神。你非常朴素、爱干净。你往往因过分坚持自己的意见而吃亏。而且，由于你为人比较沉静，常被认为是性格捉摸不定的人。",
                "你爱自由和善变，但是你的梦想无限大。你不但有很多好朋友，而且也搏得年长者得疼爱。你理想高、不喜欢受到限制。聪明而机警的你喜爱挖苦人，加上对爱慕的人忽冷忽热的，捉摸不定，所以一时较难找到理想对象。你优异的推理能力及智慧造成了敏锐的眼光和流畅的辩论能力，是个具有向未知及黑暗挑战的奋战精神的人。你是个温柔的人，即使碰见了讨厌的人，也会对他微笑。因为有点喜新厌旧、没有定性，所以有时候遭人讨厌。不过你普通蛮爆笑、挺可爱的啦！",
                "你谦逊、有同情心、又有耐心。对心理、哲理方面有敏锐观察力。你的缺点是胆小、心志不坚跟忧虑过多。你天生便能全然接受一切现状和其他人的本来面目，而且你不会想去改变别人。你将自己内心最深处的感受潜藏于心，但是若能遇上志同道合的朋友，你也会对朋友倾诉自己的感受。对于世俗的一切，你常常会感到束手无策而拙于应付，但是你有一个非常丰富的内心世界。",
        };
        map1.put("白羊座",1);
        map1.put("金牛座",2);
        map1.put("双子座",3);
        map1.put("巨蟹座",4);
        map1.put("狮子座",5);
        map1.put("室女座",6);
        map1.put("天平座",7);
        map1.put("天蝎座",8);
        map1.put("射手座",9);
        map1.put("摩羯座",10);
        map1.put("水瓶座",11);
        map1.put("双鱼座",12);

        arr = new int[][]{
                {0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,90,75,82,47,94,65,85,70,99,58,88,79},
                {0,68,88,72,75,45,97,57,78,61,93,66,81},
                {0,79,76,89,71,81,57,93,69,86,64,99,48},
                {0,52,82,78,89,61,84,66,92,70,87,74,97},
                {0,97,56,79,69,87,72,81,45,92,77,84,62},
                {0,61,91,76,88,66,89,49,81,72,95,55,84},
                {0,85,74,98,58,88,77,90,71,80,47,95,64},
                {0,60,80,68,97,65,84,73,87,47,76,57,92},
                {0,92,70,81,65,98,58,86,68,89,75,78,44},
                {0,43,97,70,80,59,92,51,85,64,88,74,77},
                {0,72,41,91,58,78,64,96,51,82,69,87,60},
                {0,71,78,46,93,61,65,74,99,54,82,69,88}
        };
    }
}
