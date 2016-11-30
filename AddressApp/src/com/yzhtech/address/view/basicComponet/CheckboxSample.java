/*
 * CheckboxSample.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2016-11-30 16:23:25
 */
package com.yzhtech.address.view.basicComponet;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 测试CheckBox
 * @author 赵洪坤 <zhaohongkun@yzhtech.com>
 */
public class CheckboxSample extends Application {

    Rectangle rect = new Rectangle(90, 30);
    final String[] names = new String[]{"Security", "Project", "Chart"};
    final Image[] images = new Image[names.length];
    final ImageView[] icons = new ImageView[names.length];
    final CheckBox[] cbs = new CheckBox[names.length];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Checkbox Sample");
        stage.setWidth(500);
        stage.setHeight(300);

        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setFill(Color.WHITE);

        for (int i = 0; i < names.length; i++) {
            final Image image = images[i] = new Image(CheckboxSample.class.getResourceAsStream("/com/yzhtech/address/resources/images/" + names[i] + ".png"));
            final ImageView icon = icons[i] = new ImageView();
            final CheckBox cb = cbs[i] = new CheckBox(names[i]);
            cb.selectedProperty().addListener(
                    (ObservableValue<? extends Boolean> ov,
                            Boolean old_val, Boolean new_val) -> {
                        icon.setImage(new_val ? image : null);
                    });
        }
        CheckBox testCb = new CheckBox("测试三种状态");
        testCb.setIndeterminate(true);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(cbs);
        vbox.getChildren().add(testCb);
        vbox.setSpacing(5);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(icons);
        hbox.setPadding(new Insets(0, 0, 0, 5));

        StackPane stack = new StackPane();

        stack.getChildren().add(rect);
        stack.getChildren().add(hbox);
        StackPane.setAlignment(rect, Pos.TOP_CENTER);

        HBox root = new HBox();
        root.getChildren().add(vbox);
        root.getChildren().add(stack);
        root.setSpacing(40);
        root.setPadding(new Insets(20, 10, 10, 20));

        ((Group) scene.getRoot()).getChildren().add(root);

        stage.setScene(scene);
        stage.show();
    }
}
