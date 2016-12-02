/*
 * ListViewController.java
 * 
 * Copyright(c) 2007-2016 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2016-12-02 10:57:43
 */
package com.yzhtech.address.view.basicComponet;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 * 测试ListView
 *
 * @author 赵洪坤 <zhaohongkun@yzhtech.com>
 */
public class ListViewController {

    @FXML
    private ListView<String> listView;

    @FXML
    private Label label;

    @FXML
    private void initialize() {
        listView.setPrefWidth(150);//改变ListView的宽高
        listView.setPrefHeight(370);
        //listView.setOrientation(Orientation.HORIZONTAL);//将列表形式改成横向的
        //listView.getSelectionModel().getSelectedIndex();//返回在单选（single - selection）模式下当前被选中的列表项索引号
        //listView.getSelectionModel().getSelectedItem();//返回当前被选中的列表项。
        //listView.getFocusModel().getFocusedIndex();//返回当前获得焦点的列表项索引号。
        //listView.getFocusModel().getFocusedItem();//返回当前获得焦点的列表项。
        //listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);//启用多选
//         listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);//启用单选
        listView.setEditable(true);//设置listview可编辑
        setListViewContent();
    }

    private void setListViewContent() {
        ObservableList<String> names
                = FXCollections.observableArrayList();
        ObservableList<String> data = FXCollections.observableArrayList();
        data.add("chocolate");
        data.add("salmon");
        data.add("gold");
        data.add("coral");
        data.add("darkgoldenrod");
        data.add("lightsalmon");
        data.add("black");
        data.add("blue");
        data.add("blueviolet");
        data.add("brown");
        names.addAll(
                "Adam", "Alex", "Alfred", "Albert",
                "Brenda", "Connie", "Derek", "Donny",
                "Lynne", "Myrtle", "Rose", "Rudolph",
                "Tony", "Trudy", "Williams", "Zach"
        );
        //通过两种方式，setItems设置数据，或者setCellFactory来设置数据
        listView.setItems(data);

        listView.setCellFactory(ComboBoxListCell.forListView(names));
        //重新定义列表的外观
        listView.setCellFactory((ListView<String> l) -> new ColorRectCell());
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val,
                        String new_val) -> {
                    label.setText(new_val);
                });
    }

    static class ColorRectCell extends ListCell<String> {

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                setTextFill(Color.web(item));
                setText(item);
                setFont(new Font("Arial", 20));
//                setGraphic(rect);
            }
        }
    }
}
