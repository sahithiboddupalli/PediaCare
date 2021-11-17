package com.example.pediacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

public class WelcomeController {
    @FXML
    public Label welcomeText;

    @FXML
    public void onHomeClick() {
        welcomeText.setText("This is home page");
    }

    @FXML
    public void onContactUsClick() {
        welcomeText.setText("This is contact us page");
    }

    @FXML
    public void onDoctorClick() {
        welcomeText.setText("This is doctor page");
    }

    @FXML
    public void onLoginClick(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onLoginDoctorClick(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(LoginDoctorApplication.class.getResource("logindoctor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onLoginNurseClick(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(LoginNurseApplication.class.getResource("loginnurse-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onRegisterClick(){ welcomeText.setText("This is Registering a patient");}
}