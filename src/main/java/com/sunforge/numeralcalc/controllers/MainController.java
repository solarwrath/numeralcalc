package com.sunforge.numeralcalc.controllers;

import java.net.URL;
import java.util.*;
import java.util.function.BiConsumer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> numberQuantity;

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
        predefinedBases.put("Інша", null);

        for (Map.Entry<String, Integer> currentPair : predefinedBases.entrySet()) {
            number1BaseComboBox.getItems().add(currentPair.getKey());
            number2BaseComboBox.getItems().add(currentPair.getKey());
        }

        //Quantity initialization
        Map<String, Integer> predefinedQuantity = new LinkedHashMap<>();
        predefinedQuantity.put("Два", 2);
        predefinedQuantity.put("Три", 3);
        predefinedQuantity.put("Чотири", 4);
        predefinedQuantity.put("П'ять", 5);
        predefinedQuantity.put("Шість", 6);
        predefinedQuantity.put("Сім", 7);

        for (Map.Entry<String, Integer> currentPair : predefinedQuantity.entrySet()) {
            numberQuantity.getItems().add(currentPair.getKey());
        }

        //Setting selection
        numberQuantity.getSelectionModel().select(0);
        number1BaseComboBox.getSelectionModel().select(0);
        number2BaseComboBox.getSelectionModel().select(0);

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

        /*computeButton.setOnAction(event -> {
        });*/
    }
}
