package com.example.pediacare;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PatientMedicalInsuranceController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label healthInsuranceNumber;
    @FXML
    private Label healthInsuranceAgent;
    @FXML
    private Label medicalSupport;


    @FXML
    public void onHomeClick() throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("PediaCare");
        stage.setScene(scene);
        stage.show();
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
    public void onPersonalDetailsClick() throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(PatientDashboardApplication.class.getResource("patientdashboard-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("PediaCare");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onMedicalHistoryClick() throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(PatientMedicalHistoryApplication.class.getResource("patientmedicalhistory-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("PediaCare");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onMedicalInsuranceClick() throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(PatientMedicalInsuranceApplication.class.getResource("patientmedicalinsurance-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("PediaCare");
        stage.setScene(scene);
        stage.show();
    }
/*
    @FXML
    public void onPreferredPharmacyClick() throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(PatientPreferredPharmacyApplication.class.getResource("patientpreferredpharmacy-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("PediaCare");
        stage.setScene(scene);
        stage.show();
    }

 */

    @FXML
    public void onBookAppointmentClick() throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(BookAppointmentApplication.class.getResource("bookappointment-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("PediaCare");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onMessageDoctorClick() throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MessageDoctorApplication.class.getResource("messagedoctor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("PediaCare");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onSaveClick() throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MessageDoctorApplication.class.getResource("messagedoctor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("PediaCare");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onSavingClick() throws Exception{

    }
}
