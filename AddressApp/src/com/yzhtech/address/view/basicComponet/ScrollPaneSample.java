/*
 * ScrollPaneSample.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2016-12-01 11:39:07
 */
package com.yzhtech.address.view.basicComponet;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 赵洪坤 <zhaohongkun@yzhtech.com>
 */
public class ScrollPaneSample extends Application {

    final ScrollPane sp = new ScrollPane();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();
    final Label fileName = new Label();
    final String[] imageNames = new String[]{"dog1.png", "dog2.png",
        "dog3.png", "dog4.png", "dog5.png"};

    @Override
    public void start(Stage stage) {
        VBox box = new VBox();
        Scene scene = new Scene(box, 180, 180);
        stage.setScene(scene);
        stage.setTitle("ScrollPaneSample");
        box.getChildren().addAll(sp, fileName);
        VBox.setVgrow(sp, Priority.ALWAYS);

        fileName.setLayoutX(30);
        fileName.setLayoutY(160);

        Image roses = new Image(ScrollPaneSample.class.getResourceAsStream("/com/yzhtech/address/resources/images/roses.png"));
        sp.setContent(new ImageView(roses));
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        for (int i = 0; i < 5; i++) {
            images[i] = new Image(ScrollPaneSample.class.getResourceAsStream("/com/yzhtech/address/resources/images/"+imageNames[i]));
            pics[i] = new ImageView(images[i]);
            pics[i].setFitWidth(100);
            pics[i].setPreserveRatio(true);
            vb.getChildren().add(pics[i]);
        }

        sp.setVmax(440);
        sp.setPrefSize(115, 150);
        sp.setContent(vb);
        sp.vvalueProperty().addListener((ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) -> {
            fileName.setText(imageNames[(new_val.intValue() - 1) / 100]);
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
