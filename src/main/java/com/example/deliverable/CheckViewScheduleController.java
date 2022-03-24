package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckViewScheduleController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> arrivalchoicebox;

    @FXML
    private Label checklabel;


    @FXML
    private ChoiceBox<String> departchoicebox;

    @FXML
    private Label mylabel;


    private String[] Station ={"Islamabad","Lahore","Karachi","Quetta","Skardu"};

    @FXML
    public void initialize() {
        departchoicebox.getItems().addAll(Station);
        departchoicebox.setOnAction(this::DepartStationinput);

        arrivalchoicebox.getItems().addAll(Station);
        arrivalchoicebox.setOnAction(this::ArrivalStationinput);
    }

    String mydepartStation;
    public void DepartStationinput(ActionEvent event){
        mydepartStation = departchoicebox.getValue();
        mylabel.setText(mydepartStation);
       // trainSchedule.setDeparture_platform(mydepartStation);
    }
    String myarrivalStation;
    public void ArrivalStationinput(ActionEvent event){
        myarrivalStation = arrivalchoicebox.getValue();
        mylabel.setText(myarrivalStation);
       // trainSchedule.setArrival_platform(myarrivalStation);
    }


    public void onSubmitButtonSchedule(ActionEvent event) throws IOException{

        // if no trains moving then simply put alert box


        root = FXMLLoader.load(getClass().getResource("viewschedule.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onBackButtonSchedule(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
