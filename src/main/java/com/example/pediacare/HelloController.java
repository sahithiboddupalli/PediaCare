package com.example.pediacare;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label wText;
 // This is welcome page
    @FXML
    protected void onHelloButtonClick() {
        wText.setText("Welcome to JavaFX Application!");
    }
}
