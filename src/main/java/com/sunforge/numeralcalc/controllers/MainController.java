package com.sunforge.numeralcalc.controllers;

import java.net.URL;
import java.util.*;
import java.util.function.BiConsumer;

import com.sunforge.numeralcalc.computations.MainHandler;
import com.sunforge.numeralcalc.computations.Operation;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane number1Pane;

    @FXML
    private TextField number1TextField;

    @FXML
    private ComboBox<String> number1BaseComboBox;

    @FXML
    private Label number1BaseIntegerLabel;

    @FXML
    private TextField number1BaseInteger;

    @FXML
    private CheckBox sameBaseCheckBox;

    @FXML
    private ComboBox<String> operation1;

    @FXML
    private Label operation1Label;

    @FXML
    private AnchorPane number2Pane;

    @FXML
    private Label base2Label;

    @FXML
    private TextField number2TextField;

    @FXML
    private ComboBox<String> number2BaseComboBox;

    @FXML
    private Label number2BaseIntegerLabel;

    @FXML
    private TextField number2BaseInteger;

    @FXML
    private Button computeButton;

    @FXML
    private Label resultLabel;


    @FXML
    void initialize() {
        //Bases initialization
        Map<String, Integer> predefinedBases = new LinkedHashMap<>();
        predefinedBases.put("Двоїчна", 2);
        predefinedBases.put("Троїчна", 3);
        predefinedBases.put("Восьмерічна", 8);
        predefinedBases.put("Десятирічна", 10);
        predefinedBases.put("Шістнадцятерічна", 16);
        predefinedBases.put("Інша", -1);

        for (Map.Entry<String, Integer> currentPair : predefinedBases.entrySet()) {
            number1BaseComboBox.getItems().add(currentPair.getKey());
            number2BaseComboBox.getItems().add(currentPair.getKey());
        }

        //Operation initialization
        Map<String, Operation> predefinedOperations = new LinkedHashMap<>();
        predefinedOperations.put("Додавання", Operation.ADDITION);
        predefinedOperations.put("Віднімання", Operation.SUBSTRACTION);
        predefinedOperations.put("Множення", Operation.MULTIPLICATION);
        predefinedOperations.put("Ділення", Operation.DIVISION);

        for (Map.Entry<String, Operation> currentPair : predefinedOperations.entrySet()) {
            operation1.getItems().add(currentPair.getKey());
        }
        //Setting selection
        number1BaseComboBox.getSelectionModel().select(0);
        number2BaseComboBox.getSelectionModel().select(0);
        operation1.getSelectionModel().select(0);

        //Declaring what to hide if user checks that bases are the same
        List<Control> additionalBasesList = new ArrayList<>();
        additionalBasesList.add(number2BaseComboBox);
        additionalBasesList.add(base2Label);

        number1BaseComboBox.setOnAction(event -> {
            if (predefinedBases.get(number1BaseComboBox.getSelectionModel().getSelectedItem()) == null) {
                number1BaseIntegerLabel.setVisible(true);
                number1BaseInteger.setVisible(true);
            } else {
                number1BaseIntegerLabel.setVisible(false);
                number1BaseInteger.setVisible(false);
            }
        });

        sameBaseCheckBox.setOnAction(event -> {
            if (sameBaseCheckBox.isSelected()) {
                for (Control currentControl : additionalBasesList) {
                    currentControl.setVisible(false);
                }
            } else {
                for (Control currentControl : additionalBasesList) {
                    currentControl.setVisible(true);
                }
            }
        });

        computeButton.setOnAction(event -> {
            Map<Integer, Integer> numberAndBases = new LinkedHashMap<>();
            int argsNumber1 = Integer.parseInt(number1TextField.getText());
            int argsBase1 = predefinedBases.get(number1BaseComboBox.getSelectionModel().getSelectedItem());
            if (argsBase1 == -1) {
                argsBase1 = Integer.parseInt(number1BaseInteger.getText());
            }
            int argsNumber2 = Integer.parseInt(number1TextField.getText());
            int argsBase2 = predefinedBases.get(number1BaseComboBox.getSelectionModel().getSelectedItem());
            if (argsBase2 == -1) {
                argsBase2 = Integer.parseInt(number2BaseInteger.getText());
            }
            Operation currentOperation = predefinedOperations.get(operation1.getSelectionModel().getSelectedItem());
            resultLabel.setText(String.valueOf(MainHandler.compute(argsNumber1, argsBase1, argsNumber2, argsBase2, currentOperation)));
        });
    }
}
