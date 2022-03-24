package com.example.deliverable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login_view.fxml"));
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Airline Reservation System");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}