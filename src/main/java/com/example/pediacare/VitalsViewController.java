package com.example.pediacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VitalsViewController {
    @FXML
    private TextField height;
    @FXML
    private TextField weight;
    @FXML
    private TextField temp;
    @FXML
    private TextField age;
    @FXML
    private Label text;

    @FXML
    public void onsave(ActionEvent actionEvent) {

           int ageInteger = Integer.parseInt(age.getText());
            if (ageInteger < 12) {
                text.setText("Cannot take vitals as age is less that 12");
            } else {
                text.setText("Sucessfully taken vitals");

            }


    }
}
