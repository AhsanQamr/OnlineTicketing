package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label agelabel;

    @FXML
    private Label cniclabel;

    @FXML
    private Label emaillabel;

    @FXML
    private Label fullnamelabel;

    @FXML
    private Label passwordlabel;

    @FXML
    private Label usernamelabel;

    Passenger P = Passenger.getInstance();

    @FXML
    public void initialize(){
        displayPassengerInformation();
    }

    public void displayPassengerInformation(){
        fullnamelabel.setText(P.getFullName());
        usernamelabel.setText(P.getUserName());
        emaillabel.setText(P.getEmail());
        passwordlabel.setText(P.getPassword());
        cniclabel.setText(P.getCnicNo());
        agelabel.setText(P.getAge());
    }



    public void setBackButtonViewAccount(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setUpdateAccountButton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error!");
        alert.setHeaderText("Can't Proceed at the moment");
        alert.setContentText("Please try again later");

        alert.showAndWait();
    }
}
