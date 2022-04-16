package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CancelTicketC {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label arrname;

    @FXML
    private Label cnic;

    @FXML
    private Label depname;

    @FXML
    private Label name;


    @FXML
    private Label prompt;

    @FXML
    private Label ticketno;

    Reservation reservation = Reservation.getInstance();
    DBHandler dbHandler = new DBHandler();
    public void showTicketInfo(){
        name.setText(reservation.getName());
        cnic.setText(reservation.getCnic());
        ticketno.setText(Integer.toString(reservation.getTicket_number()));
        depname.setText(reservation.getDep_airport());
        arrname.setText(reservation.getArr_airport());
    }
    @FXML
    public void initialize(){
        showTicketInfo();
    }


    public void setBackButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setCancelTicketButton(ActionEvent event) throws IOException{
        String cnicno = null;
        String store = reservation.deleteTicket(cnicno);
        if(!Objects.equals(store, "Success")){
            prompt.setText(store);
            return;
        }


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error!");
        alert.setHeaderText("Ticket Cancelled Successfully");
        alert.setContentText("Press Issue Ticket for 'New Ticket' ");
        alert.showAndWait();

        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


}
