package com.example.pediacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginNurseController {
    @FXML
    public Label nurseUsername;
    @FXML
    public Label nursePassword;
    @FXML
    public void onLoginNurseButtonClick(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DoctorPortalApplication.class.getResource("doctorportal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
    }
}
