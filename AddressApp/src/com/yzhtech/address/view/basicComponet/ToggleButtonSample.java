/*
 * ToggleButtonSample.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2016-11-30 15:52:08
 */
package com.yzhtech.address.view.basicComponet;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 测试ToggleButton
 *
 * @author 赵洪坤 <zhaohongkun@yzhtech.com>
 */
public class ToggleButtonSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Toggle Button Sample");
        stage.setWidth(250);
        stage.setHeight(180);

        HBox hbox = new HBox();
        VBox vbox = new VBox();

        Scene scene = new Scene(new Group(vbox));
        stage.setScene(scene);
        scene.getStylesheets().add("/com/yzhtech/address/view/basicComponet/globalStyle.css");

        Rectangle rect = new Rectangle();
        rect.setHeight(50);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.DARKGRAY);
        rect.setStrokeWidth(16);//边框宽度

        //圆角弧度
        rect.setArcHeight(40);
        rect.setArcWidth(40);

        final ToggleGroup group = new ToggleGroup();

        group.selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle> ov,
                        Toggle toggle, Toggle new_toggle) -> {
                    if (new_toggle == null) {
                        rect.setFill(Color.WHITE);
                    } else {
                        rect.setFill((Color) group.getSelectedToggle().getUserData());
                    }
                });

        ToggleButton tb1 = new ToggleButton("Minor");
        tb1.setToggleGroup(group);
        tb1.setUserData(Color.LIGHTGREEN);
        tb1.setSelected(true);
        tb1.getStyleClass().add("toggle-button1");

        ToggleButton tb2 = new ToggleButton("Major");
        tb2.setToggleGroup(group);
        tb2.setUserData(Color.LIGHTBLUE);
        tb2.getStyleClass().add("toggle-button2");

        ToggleButton tb3 = new ToggleButton("Critical");
        tb3.setToggleGroup(group);
        tb3.setUserData(Color.SALMON);
        tb3.getStyleClass().add("toggle-button3");

        hbox.getChildren().addAll(tb1, tb2, tb3);

        vbox.getChildren().add(new Label("Priority:"));
        vbox.getChildren().add(hbox);
        vbox.getChildren().add(rect);
        vbox.setPadding(new Insets(20, 10, 10, 20));

        stage.show();
        rect.setWidth(hbox.getWidth());
    }
}
