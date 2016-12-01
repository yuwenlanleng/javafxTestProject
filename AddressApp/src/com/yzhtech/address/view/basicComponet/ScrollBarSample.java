/*
 * ScrollBarSample.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2016-12-01 10:21:20
 */
package com.yzhtech.address.view.basicComponet;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 测试滚动条
 *
 * @author 赵洪坤 <zhaohongkun@yzhtech.com>
 */
public class ScrollBarSample extends Application {

    final ScrollBar sc = new ScrollBar();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();
    DropShadow shadow = new DropShadow();

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 180, 180);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Scrollbar");
        root.getChildren().addAll(vb, sc);

        shadow.setColor(Color.GREY);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);

        vb.setLayoutX(5);
        vb.setSpacing(10);

        sc.setLayoutX(scene.getWidth() - sc.getWidth());
        sc.setMin(0);//滚动条最小值
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(180);
        sc.setMax(360);//滚动条最大值

        for (int i = 0; i < 5; i++) {
            final Image image = images[i]
                    = new Image(ScrollBarSample.class.getResourceAsStream("/com/yzhtech/address/resources/images/dog" + (i + 1) + ".png"));
            final ImageView pic = pics[i]
                    = new ImageView(images[i]);
            pic.setEffect(shadow);//设置阴影
            vb.getChildren().add(pics[i]);
        }

        sc.valueProperty().addListener((ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) -> {
            vb.setLayoutY(-new_val.doubleValue());
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
