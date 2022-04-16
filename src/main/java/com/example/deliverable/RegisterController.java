package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


    public void setFullNameLabel(){
        String fullName;
        fullName = fullnamelabel.getText();
        P.setFullName(fullName);
    }
    public void setUserNameLabel(){
        String userName;
        userName = usernamelabel.getText();
        P.setUserName(userName);
    }
    public void setEmailLabel(){
        String email;
        email = emaillabel.getText();
        P.setEmail(email);
    }
    public void setPasswordLabel(){
        String password;
        password = passwordlabel.getText();
        P.setPassword(password);
    }
    public void setCnicLabel(){
        String cnic;
        cnic = cniclabel.getText();
        P.setCnicNo(cnic);
    }
    public void setAgeLabel(){
        String  age;
        age = agelabel.getText();
        P.setAge(age);
    }



    public void setSubmitButton(ActionEvent event) throws IOException {

        setFullNameLabel();
        setUserNameLabel();
        setEmailLabel();
        setPasswordLabel();
        setCnicLabel();
        setAgeLabel();


        String result = P.signUp();
        if(!Objects.equals(result, "Success")){
            if(Objects.equals(result, "Error connecting to database")){
                promptatregister.setText("Username already taken!   Press 'Refresh' and try Again");
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
