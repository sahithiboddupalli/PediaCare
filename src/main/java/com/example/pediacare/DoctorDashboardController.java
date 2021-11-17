package com.example.pediacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.controlsfx.control.action.Action;

public class DoctorDashboardController {
    @FXML
    public Label firstName;
    @FXML
    public Label lastName;
    @FXML
    public Label phone;
    @FXML
    public Label email;
    @FXML
    public Label specalisation;

    @FXML
    public void onSaveInfoClick(ActionEvent event) throws Exception{

    }
}
