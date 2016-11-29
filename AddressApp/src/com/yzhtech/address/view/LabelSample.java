/*
 * LabelSample.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2016-11-29 13:50:45
 */
package com.yzhtech.address.view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * label测试
 *
 * @author 赵洪坤 <zhaohongkun@yzhtech.com>
 */
public class LabelSample extends Application  {

//    @FXML
//    private Label imageLabel = new Label("Search");;

    /**
     * Initializes the controller class.
     */
     Label label3 = new Label("A label that needs to be wrapped");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("测试label的各种属性");
        stage.setWidth(420);
        stage.setHeight(180);


        HBox hbox = new HBox();
        Image image = new Image(getClass().getResourceAsStream("/com/yzhtech/address/resources/images/search-24.png"));

        Label label1 = new Label("Search");
        label1.setGraphic(new ImageView(image));//设置图片
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.web("#0076a3"));
        label1.setTextAlignment(TextAlignment.JUSTIFY);

        //旋转一个标签
        Label label2 = new Label("Values");
        label2.setFont(Font.font("Cambria", 32));
        label2.setRotate(270);//旋转270度
        label2.setTranslateY(50);//距离上边框的距离

        label3.setWrapText(true);//设置可以换行
        label3.setTranslateY(50);
        label3.setPrefWidth(100);
        
        label3.setOnMouseEntered((MouseEvent e) -> {
            label3.setScaleX(1.5);
            label3.setScaleY(1.5);
        });

        label3.setOnMouseExited((MouseEvent e) -> {
            label3.setScaleX(1);
            label3.setScaleY(1);
        });

        hbox.setSpacing(10);
        hbox.getChildren().add((label1));
        hbox.getChildren().add(label2);
        hbox.getChildren().add(label3);
        ((Group) scene.getRoot()).getChildren().add(hbox);

        stage.setScene(scene);
        stage.show();
    }
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        //一个带文本和图标的Label
//        Image image = new Image(MainApp.class.getResourceAsStream("/com/yzhtech/address/resources/images/search-24.png"));
//        FXMLLoader mainLLoaderoader = new FXMLLoader();
//        mainLLoaderoader.setLocation(MainApp.class.getResource("/com/yzhtech/address/view/Label.fxml"));
//        AnchorPane anchorPaneLayout = (AnchorPane) mainLLoaderoader.load();//加载布局
//        Scene scene = new Scene(anchorPaneLayout);
//        primaryStage.setScene(scene);
//        imageLabel.setGraphic(new ImageView(image));
//        imageLabel.setTextFill(Color.web("#0076a3"));;
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }

}
