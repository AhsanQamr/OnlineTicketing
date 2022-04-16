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

public class BookingC {

    @FXML
    private Label arrname;

    @FXML
    private Label arrtime;

    @FXML
    private Label cnic;

    @FXML
    private Label depname;

    @FXML
    private Label deptime;

    @FXML
    private Label fare;

    @FXML
    private Label flightno;

    @FXML
    private Label name;

    @FXML
    private Label seatno;

    @FXML
    private Label ticketno;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Reservation reservation = Reservation.getInstance();

    public void showTicketInfo(){
        name.setText(reservation.getName());
        cnic.setText(reservation.getCnic());
        flightno.setText(reservation.getFlight_number());
        ticketno.setText(Integer.toString(reservation.getTicket_number()));
        fare.setText(reservation.getFare());
        depname.setText(reservation.getDep_airport());
        deptime.setText(reservation.getDep_time());
        arrname.setText(reservation.getArr_airport());
        arrtime.setText(reservation.getArr_time());
        seatno.setText(reservation.getSeatno());

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

    DBHandler dbHandler = new DBHandler();

    public String seeBooking(String cnic) {
        return dbHandler.seeBooking(reservation.getCnic());
    }

    public String validateAtIssuance(String cnic) {
        return dbHandler.validateAtIssuance(reservation.getCnic());
    }

    public String cancelBooking(String cnic) {
        return dbHandler.cancelBooking(reservation.getCnic());
    }
}
