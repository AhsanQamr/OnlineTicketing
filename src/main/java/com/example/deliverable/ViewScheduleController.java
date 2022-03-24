package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewScheduleController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void onBackToLobbyButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onBackButtonViewSchedule(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("checkviewschedule.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
