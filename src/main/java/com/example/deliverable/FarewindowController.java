package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class FarewindowController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label arrnamelabel;

    @FXML
    private Label depamelabel;

    @FXML
    private Label farelabel;

    @FXML
    private Label idlabel;

    @FXML
    private Label namelabel;

    @FXML
    private Label typelabel;

    AirplaneDescription airplaneDescription = AirplaneDescription.getInstance();
    FlightDescription flightDescription = FlightDescription.getInstance();

    public void showInformation(){
        idlabel.setText(airplaneDescription.getAirplane_id());
        namelabel.setText(airplaneDescription.getAirplane_company());
        typelabel.setText(airplaneDescription.getAirplane_type());
        depamelabel.setText(flightDescription.getDep_airport_name());
        arrnamelabel.setText(flightDescription.getArr_airport_name());
        farelabel.setText(flightDescription.getFare());
    }

    @FXML
    public void initialize(){
        showInformation();
    }


    public void setBackButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewfare.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setBackLobbyButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
