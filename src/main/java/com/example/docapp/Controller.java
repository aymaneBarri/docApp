package com.example.docapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.EventListener;
import java.util.ResourceBundle;

public class Controller implements Initializable {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    @FXML
    private Label connectLabel;

    public void connectButton(ActionEvent event){
        DataBaseConnection db = new DataBaseConnection();
        Connection connection = db.getConnection();

        String query = "Select * from user";

        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(query);

            while (queryOutput.next()) {
                connectLabel.setText(queryOutput.getString("username"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private TableColumn<?, ?> columnBrand;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnImage;

    @FXML
    private TableColumn<?, ?> columnName;

    @FXML
    private TableColumn<?, ?> columnPrice;

    @FXML
    private TableColumn<?, ?> columnRegister;

    @FXML
    private TableView table;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DataBaseConnection db = new DataBaseConnection();
        Connection connection = db.getConnection();

        String query = "Select * from product";

        ObservableList<Product> data = FXCollections.observableArrayList();

        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(query);

            while (queryOutput.next()) {
//                connectLabel.setText(queryOutput.getString("username"));

                data.add(new Product((Integer) queryOutput.getObject(1), queryOutput.getObject(2).toString(), queryOutput.getObject(3).toString(), (Double) queryOutput.getObject(4), queryOutput.getObject(5).toString(), (LocalDateTime) queryOutput.getObject(6)));
            }

            columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            columnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
            columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
            columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            columnImage.setCellValueFactory(new PropertyValueFactory<>("image"));
            columnRegister.setCellValueFactory(new PropertyValueFactory<>("register"));
            table.setItems(data);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}