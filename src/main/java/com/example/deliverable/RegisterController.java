package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField agelabel;

    @FXML
    private Button backregister;

    @FXML
    private TextField cniclabel;

    @FXML
    private TextField emaillabel;

    @FXML
    private TextField fullnamelabel;

    @FXML
    private TextField passwordlabel;

    @FXML
    private Button submitbutton;

    @FXML
    private TextField usernamelabel;


    @FXML
    private Label promptatregister;


    // calling object of passenger
    Passenger P = Passenger.getInstance();


    public boolean setFullNameLabel(){
        String fullName;
        fullName = fullnamelabel.getText();

        if(!(fullName.matches("^[a-zA-Z\\s]+"))){
            promptatregister.setText("Fullname must contain only alphabets with no specials");
            return false;
        }

        P.setFullName(fullName);
        return true;
    }
    public boolean setUserNameLabel() {
        String userName;
        userName = usernamelabel.getText();

        if (!(userName.matches("^[a-zA-Z]\\w{4,19}$"))) {
            promptatregister.setText("username must not start with alphabet, and characters between 5 to 20");
            return false;
        }

        P.setUserName(userName);
        return true;
    }
    public void setEmailLabel(){
        String email;
        email = emaillabel.getText();
        P.setEmail(email);
    }
    public boolean setPasswordLabel(){
        String password;
        password = passwordlabel.getText();

        if(password.length()<8 || password.length()>15){
            promptatregister.setText("password contains 8 to 15 characters");
            return false;
        }
        P.setPassword(password);
        return true;
    }
    public boolean setCnicLabel(){
        String cnic;
        cnic = cniclabel.getText();

        if(cnic.length() != 13){
            promptatregister.setText("Only 13 numeric characters allowed");
            return false;
        }
        P.setCnicNo(cnic);
        return true;
    }
    public boolean setAgeLabel(){
        String  age;
        age = agelabel.getText();

        int age_int = Integer.parseInt(age);
        if(age_int<18){
            promptatregister.setText("Below 18 children not allowed to signup");
            return false;
        }
        P.setAge(age);
        return true;
    }



    public void setSubmitButton(ActionEvent event) throws IOException {

        if(!setFullNameLabel()){
            return;
        }
        if(!setUserNameLabel()){
            return;
        }
        if(!setCnicLabel()){
            return;
        }
        if(!setPasswordLabel()){
            return;
        }
        setEmailLabel();

        if(!setAgeLabel())
            return;

        String result = P.signUp();

        if(!Objects.equals(result, "Success")){
            if(Objects.equals(result, "Error connecting to database")){
                System.out.println("Database issues are here i think");
                promptatregister.setText("Username already taken!");
                return;
            }
            promptatregister.setText(result);
            return;
        }
        root = FXMLLoader.load(getClass().getResource("login_view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setRefreshButton(ActionEvent event) throws IOException{
            root = FXMLLoader.load(getClass().getResource("register.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    public void setBackButtonRegister(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login_view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}


//    public void handle(ActionEvent event) {
//        if(!fnamefield.getText().matches("[aA-zZ ]+$")) {
//            ErrorAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Please enter your full name.\n"
//                    + "Please make sure no");
//            return;
//        }