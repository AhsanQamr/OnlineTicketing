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

public class IssueView1C {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label arrcod;

    @FXML
    private Label depcod;

    @FXML
    private Label deptim;

    @FXML
    private Label flno;

    FlightDescription flightDescription = FlightDescription.getInstance();
    AirplaneDescription airplaneDescription = AirplaneDescription.getInstance();

    public void showLessInfo(){
        arrcod.setText(flightDescription.getArr_airport_code());
        depcod.setText(flightDescription.getDep_airport_code());
        flno.setText(flightDescription.getFlight_number());
        deptim.setText(flightDescription.getDep_time());
    }
    @FXML
    public void initialize(){
        showLessInfo();
    }

    public void setViewButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("issueview2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setBackButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("issueticket1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
