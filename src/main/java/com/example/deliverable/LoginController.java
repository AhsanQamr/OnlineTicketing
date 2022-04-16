package com.example.deliverable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label promptatlogin;
    @FXML
    private TextField usernamelabel;
    @FXML
    private PasswordField passwordlabel;

    Passenger P = Passenger.getInstance();

    public void setLoginButton(ActionEvent event) throws IOException{

        String userName = usernamelabel.getText();
        String password = passwordlabel.getText();

        if(Objects.equals(userName, "") || Objects.equals(password, "")){
            promptatlogin.setText("Fields are Empty");
        }

        String result = P.login(userName,password);

        if(!Objects.equals(result, "Success")){
            promptatlogin.setText(result);
            return;
        }

        root = FXMLLoader.load(getClass().getResource("lobby.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setSignUp(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
