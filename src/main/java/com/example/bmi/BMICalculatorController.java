package com.example.bmi;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;


public class BMICalculatorController {

    @FXML
    private TextField weightField;

    @FXML
    private TextField heightField;

    @FXML
    private RadioButton metricRadio;

    @FXML
    private RadioButton imperialRadio;

    @FXML
    private Label bmiResultLabel;

    @FXML
    private Label bmiStatusLabel;

    @FXML
    private ToggleGroup unitToggleGroup;

    @FXML
    public void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            boolean isMetric = metricRadio.isSelected();
            double bmi;
            if (isMetric) {
                bmi = weight / (height * height);
            } else {
                bmi = (weight / (height * height)) * 703;
            }

            bmiResultLabel.setText(String.format("Your BMI: %.2f", bmi));
            bmiStatusLabel.setText(getBMIStatus(bmi));
        } catch (NumberFormatException e) {
            bmiResultLabel.setText("Please enter valid numbers.");
            bmiStatusLabel.setText("");
        }
    }

    private String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    @FXML
    public void clearFields() {
        weightField.clear();
        heightField.clear();
        bmiResultLabel.setText("");
        bmiStatusLabel.setText("");
    }

    @FXML
    public void exitApp() {
        Platform.exit();
    }

    @FXML
    public void showHelp() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText("BMI Calculator Instructions");
        alert.setContentText("Enter your weight and height to calculate your BMI. Choose between Metric and Imperial units.");
        alert.showAndWait();
    }
}
