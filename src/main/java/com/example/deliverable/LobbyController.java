package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LobbyController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setLogoutButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login_view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setAccountViewButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("AccountView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setCheckScheduleButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("checkviewschedule.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setViewFareButton (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewfare.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setIssueTicketButton(ActionEvent event) throws IOException{

    }

    public void setCancelTicketButton(ActionEvent event) throws IOException{

    }

    public void setBookingsButton(ActionEvent event) throws IOException{

    }



}
