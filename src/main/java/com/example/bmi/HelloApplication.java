package com.example.bmi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    // The entry point for the JavaFX application. It sets up the stage and scene.
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML layout from the specified resource (hello-view.fxml)
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // Create a new scene with a size of 320x240
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("BMI Calculator");
        stage.setScene(scene);
        stage.show();
    }
    // Main method to launch the JavaFX application.
    public static void main(String[] args) {
        launch();
    }
}