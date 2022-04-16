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

public class ScheduleViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label arr_code_1;

    @FXML
    private Label arr_code_2;

    @FXML
    private Label arr_code_3;

    @FXML
    private Label dep_code_1;

    @FXML
    private Label dep_code_2;

    @FXML
    private Label dep_code_3;

    @FXML
    private Label time1;

    @FXML
    private Label time2;

    @FXML
    private Label time3;

    FlightDescription flightDescription = FlightDescription.getInstance();

    @FXML
    public void initialize(){
        showSmallView();
    }

    public void showSmallView(){
        arr_code_1.setText(flightDescription.getArr_airport_code());
//        arr_code_2.setText(flightDescription.getArr_airport_code());
//        arr_code_3.setText(flightDescription.getArr_airport_code());
        dep_code_1.setText(flightDescription.getDep_airport_code());
//        dep_code_2.setText(flightDescription.getDep_airport_code());
//        dep_code_3.setText(flightDescription.getDep_airport_code());
        time1.setText(flightDescription.getDep_time());
//        time2.setText(flightDescription.getDep_time());
//        time3.setText(flightDescription.getDep_time());
    }


    public void setView1Button(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewschedule.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public void setView2Button(ActionEvent event) throws IOException{
//        root = FXMLLoader.load(getClass().getResource("viewschedule.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene= new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public void setView3Button(ActionEvent event) throws IOException{
//        root = FXMLLoader.load(getClass().getResource("viewschedule.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene= new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    public void setBackButtonSchedule(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("checkviewschedule.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
