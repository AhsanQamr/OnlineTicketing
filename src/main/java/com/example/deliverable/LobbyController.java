package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Objects;

public class LobbyController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomelabel;

    @FXML
    public void initialize(){
        Passenger P = Passenger.getInstance();
        welcomelabel.setText("Welcome "+P.getUserName());
    }

    public void setLogoutButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login_view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setAccountViewButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("AccountView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setCheckScheduleButton(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("checkviewschedule.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setViewFareButton (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewfare.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setIssueTicketButton(ActionEvent event) throws IOException{
        BookingC bookingC = new BookingC();
        String cnic = null;
        String store = bookingC.validateAtIssuance(cnic);
        if(Objects.equals(store, "Success")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setHeaderText("Ticket Already Issued");
            alert.setContentText("Can't proceed further");
            alert.showAndWait();
            return;
        }

        root = FXMLLoader.load(getClass().getResource("issueticket1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setCancelTicketButton(ActionEvent event) throws IOException{
        BookingC bookingC = new BookingC();
        String cnic = null;
        String store = bookingC.cancelBooking(cnic);
        if(!Objects.equals(store, "Success")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setHeaderText(store);
            alert.setContentText("Please Issue a ticket First");
            alert.showAndWait();
            return;
        }
        root = FXMLLoader.load(getClass().getResource("cancelticket.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setBookingsButton(ActionEvent event) throws IOException{

        BookingC bookingC = new BookingC();
        String cnic = null;
        String store = bookingC.seeBooking(cnic);
        if(!Objects.equals(store, "Success")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setHeaderText(store);
            alert.setContentText("Please book a seat first");
            alert.showAndWait();
            return;
        }

        root = FXMLLoader.load(getClass().getResource("booking.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setLuggagePolicyScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("luggagepolicy.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setCancelPolicyScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("cancelpolicy.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
