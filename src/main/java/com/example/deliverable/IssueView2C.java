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

public class IssueView2C {

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
    private Label fare;

    @FXML
    private Label flightno;

    @FXML
    private Label legno;

    @FXML
    private Label maxseats;

    private Stage stage;
    private Scene scene;
    private Parent root;

    FlightDescription flightDescription = FlightDescription.getInstance();
    AirplaneDescription airplaneDescription = AirplaneDescription.getInstance();

    public void showDetailedInfo(){
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
        fare.setText(flightDescription.getFare());
    }

    @FXML
    public void initialize(){
        showDetailedInfo();
    }


    public void setSeatButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("selectseat.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onBackButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("issueview1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
