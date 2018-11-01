package com.sunforge.numeralcalc.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> numberQuantity;

    @FXML
    private AnchorPane number1Pane;

    @FXML
    private TextField number1TextField;

    @FXML
    private ComboBox<?> number1BaseComboBox;

    @FXML
    private TextField number1BaseInteger;

    @FXML
    private CheckBox sameBaseCheckBox;

    @FXML
    private AnchorPane number2Pane;

    @FXML
    private TextField number2TextField;

    @FXML
    private ComboBox<?> number2BaseComboBox;

    @FXML
    private TextField number2BaseInteger;

    @FXML
    private Button computeButton;

    @FXML
    private Label resultLabel;

    @FXML
    void initialize() {

    }
}
