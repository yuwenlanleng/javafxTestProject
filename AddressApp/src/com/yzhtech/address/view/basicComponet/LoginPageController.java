/*
 * LoginPageController.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2016-11-28 11:43:57
 */
package com.yzhtech.address.view.basicComponet;

import com.yzhtech.address.controler.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 赵洪坤 <zhaohongkun@yzhtech.com>
 */
public class LoginPageController extends Application implements Initializable {

    @FXML
    private TextField userNameTexField;

    @FXML
    private TextField passWordTexField;

    @FXML
    private Button loginInButton;

    @FXML
    private Label hintLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("这是主要窗口");
        FXMLLoader mainLLoaderoader = new FXMLLoader();
        mainLLoaderoader.setLocation(MainApp.class.getResource("/com/yzhtech/address/view/LoginPage.fxml"));
        AnchorPane anchorPaneLayout = (AnchorPane) mainLLoaderoader.load();//加载布局

        // Show the scene containing the root layout.
        Scene scene = new Scene(anchorPaneLayout);//相当于panel，把布局设置到场景中
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void loginInBtn() {
        loginInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hintLabel.setTextFill(Color.FIREBRICK);//将文字颜色变成 firebrick red
                hintLabel.setText("Sign in button pressed");
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
