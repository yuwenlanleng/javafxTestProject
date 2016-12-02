/*
 * TestListView.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2016-12-02 11:58:11
 */
package com.yzhtech.address.view.basicComponet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 赵洪坤 <zhaohongkun@yzhtech.com>
 */
public class TestListView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("这是主要窗口");
        FXMLLoader mainLLoaderoader = new FXMLLoader();
        mainLLoaderoader.setLocation(TestListView.class.getResource("/com/yzhtech/address/view/basicComponet/ListViewFxml.fxml"));
        AnchorPane anchorPaneLayout = (AnchorPane) mainLLoaderoader.load();//加载布局

        // Show the scene containing the root layout.
        Scene scene = new Scene(anchorPaneLayout);//相当于panel，把布局设置到场景中
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
