package com.example.pediacare;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PatientPortalController {
    @FXML
    public Label welcomeText;

    @FXML
    public Label dashboardText;

    @FXML
    public Label personalDetailsText;



    @FXML
    public void onHomeClick() {
        welcomeText.setText("This is Home Page");
    }

    @FXML
    public void onContactUsClick() {
        welcomeText.setText("This is Contact Us page!");
    }

    @FXML
    public void onDoctorClick() {
        welcomeText.setText("This is Doctors page");
    }

    @FXML
    public void onLogoutClick() {
        welcomeText.setText("The is logout page");
    }

    @FXML
    public void onPersonalDetailsClick() {
        welcomeText.setText("This is personal Details page");
    }

    @FXML
    public void onMedicalHistoryClick() {
        welcomeText.setText("This is Medical history page");
    }

    @FXML
    public void onMedicalInsuranceClick() {
        welcomeText.setText("This is Medical Insurance page");
    }

    @FXML
    public void onPreferredPharmacyClick() {
        welcomeText.setText("This is preferred pharmacy page");
    }

    @FXML
    public void onBookAppointmentClick() {
        welcomeText.setText("This is book appointment");
    }

    @FXML
    public void onMessageDoctorClick() {
        welcomeText.setText("This is message to doctor page");
    }

    @FXML
    public void onSaveClick() {
        welcomeText.setText("This is save action");
    }

    @FXML
    public void onCancelClick() {
        welcomeText.setText("This is cancel on click page");
    }


}