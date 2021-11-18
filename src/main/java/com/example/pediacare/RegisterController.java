package com.example.pediacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public TextField parentFirstName;
    @FXML
    public Label parentLastName;
    @FXML
    public Label age;
    @FXML
    public Label phone;
    @FXML
    public Label email;


    @FXML
    public void onRegisteringClick(ActionEvent event) throws Exception{

    }
}
