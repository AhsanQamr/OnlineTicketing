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

public class ViewScheduleController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label airplanecomp;

    @FXML
    private Label airplanetype;

    @FXML
    private Label arrairportcode;

    @FXML
    private Label arrairportname;

    @FXML
    private Label arrflighttime;

    @FXML
    private Label depairportcode;

    @FXML
    private Label depairportname;

    @FXML
    private Label depflighttime;

    @FXML
    private Label flightno;

    @FXML
    private Label legno;

    @FXML
    private Label maxseats;


    FlightDescription flightDescription = FlightDescription.getInstance();
    AirplaneDescription airplaneDescription = AirplaneDescription.getInstance();

    @FXML
    public void initialize(){
        showExpandedView();
    }

    public void showExpandedView(){
        flightno.setText(flightDescription.getFlight_number());
        airplanetype.setText(airplaneDescription.getAirplane_type());
        airplanecomp.setText(airplaneDescription.getAirplane_company());
        maxseats.setText(airplaneDescription.getSeats());
        legno.setText(flightDescription.getLeg_number());
        depflighttime.setText(flightDescription.getDep_time());
        depairportcode.setText(flightDescription.getDep_airport_code());
        depairportname.setText(flightDescription.getDep_airport_name());
        arrairportcode.setText(flightDescription.getArr_airport_code());
        arrairportname.setText(flightDescription.getArr_airport_name());
        arrflighttime.setText(flightDescription.getArr_time());
    }

    public void onBackToLobbyButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onBackButtonViewSchedule(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("scheduleview.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
