package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class IssueTicket1Cont {

    @FXML
    private DatePicker datechoicebox;

    @FXML
    private ChoiceBox<String> departchoicebox;

    @FXML
    private Label promptlabel;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String[] Station ={"San-Francisco","New York","Los-Angeles","Chicago"};

    @FXML
    public void initialize() {
        departchoicebox.getItems().addAll(Station);
        departchoicebox.setOnAction(this::DepartStationinput);

//        arrivalchoicebox.getItems().addAll(Station);
//        arrivalchoicebox.setOnAction(this::ArrivalStationinput);
    }

    String mydepartStation;
    public void DepartStationinput(ActionEvent event){
        mydepartStation = departchoicebox.getValue();
       // mylabel.setText(mydepartStation);
        // trainSchedule.setDeparture_platform(mydepartStation);
    }
    String formattedDate;
    String date;
    public void getDate(ActionEvent event){
        LocalDate localDate = datechoicebox.getValue();
        formattedDate = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(formattedDate);//.toString());
    }

    public void setSubmitButton(ActionEvent event) throws IOException{
        FlightDescription flightDescription = FlightDescription.getInstance();
        // if no trains moving then simply put alert box
        DepartStationinput(event);
        getDate(event);
        String result = flightDescription.issueTicket(mydepartStation,formattedDate);

        if(!Objects.equals(result, "Found")){
            promptlabel.setText(result);
            return;
        }

        root = FXMLLoader.load(getClass().getResource("issueview1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setBackutton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
