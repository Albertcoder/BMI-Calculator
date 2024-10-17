package com.example.bmi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField weightInput;

    @FXML
    private TextField heightInput;

    @FXML
    private Label bmiResultLabel;

    @FXML
    private Label bmiStatusLabel;
    // Method triggered when the user presses the 'Calculate BMI' button
    @FXML
    protected void onCalculateBMI() {
        try {
            // Parse the user input for weight and height as double values
            double weight = Double.parseDouble(weightInput.getText());
            double height = Double.parseDouble(heightInput.getText());
            // Calculate BMI using the formula: weight / (height^2)
            double bmi = weight / (height * height);
            // Display the BMI value formatted to 2 decimal places
            bmiResultLabel.setText(String.format("BMI: %.2f", bmi));

            // Determine the BMI status
            String status = getBMIStatus(bmi);
            bmiStatusLabel.setText("Status: " + status);
        } catch (NumberFormatException e) {
            bmiResultLabel.setText("Invalid input. Please enter numbers.");
        }
    }
    // Helper method to determine the BMI status based on the calculated BMI value
    private String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    // Method triggered when the user presses the 'Clear' button to reset the fields
    @FXML
    protected void onClearFields() {
        weightInput.clear();
        heightInput.clear();
        bmiResultLabel.setText("BMI: ");
        bmiStatusLabel.setText("Status: ");
    }
}