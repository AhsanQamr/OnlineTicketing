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
import java.util.Objects;

public class SelectSeatC {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> seatchoicebox;
    @FXML
    private Label prompt;

    private String[] Seats = {"1","2","5","6","4","8","9","10","13","15","20","45","34","38","39","55"};
    @FXML
    public void initialize(){
        seatchoicebox.getItems().addAll(Seats);
        seatchoicebox.setOnAction(this::selectSeat);
    }

    String myseat;
    public void selectSeat(ActionEvent event){
        myseat = seatchoicebox.getValue();
    }


    public void generateTicketButton(ActionEvent event) throws IOException{

        selectSeat(event);
        Reservation reservation = Reservation.getInstance();
        reservation.setSeatno(myseat);
        String store = reservation.generateBooking();
        if(!Objects.equals(store, "Success")){
            prompt.setText(store);
            System.out.println("issues are there");
            return;
        }

        root = FXMLLoader.load(getClass().getResource("ticket.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void backButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("issueview2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
