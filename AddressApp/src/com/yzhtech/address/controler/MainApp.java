/*
 * MainApp.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2016-11-18 11:32:49
 */
package com.yzhtech.address.controler;

import com.yzhtech.address.model.Person;
import com.yzhtech.address.view.PersonOverviewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author 赵洪坤 <zhaohongkun@yzhtech.com>
 */
public class MainApp extends Application {

    private Stage primaryStage;//相当于window主窗口
    private BorderPane rootLayout;//最外层border布局
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    AnchorPane personOverview;
    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        personData.add(new Person("张", "张三","1",2,"3"));
        personData.add(new Person("李", "李四","4",5,"6"));
        personData.add(new Person("王", "王五","7",8,"9"));
        personData.add(new Person("赵", "赵六","10",11,"12"));
        personData.add(new Person("孙", "孙七","13",14,"15"));
        personData.add(new Person("周", "周八","16",17,"18"));
        personData.add(new Person("吴", "吴九","19",20,"21"));
        personData.add(new Person("郑", "郑十","22",23,"24"));
    }

    /**
     * Returns the data as an observable list of Persons.
     *
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("这是主要窗口");

        initRootLayout();

        showPersonOverview();
        //加载border布局
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/com/yzhtech/address/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/com/yzhtech/address/view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
