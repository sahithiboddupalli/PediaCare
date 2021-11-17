package com.example.pediacare;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.prefs.Preferences;

public class PatientMedicalHistoryController {

    @FXML
    private Label welcomeText;
    @FXML
    private TextField previousCondition;
    @FXML
    private TextField currentCondition;
    @FXML
    private TextArea visitSummary;
    @FXML
    private TextField prescribedMedicines;
    @FXML
    private Button contactus;
    @FXML
    private Button doctor;
    @FXML
    private Button personalDetails;
    @FXML
    private Button medicalhistory;
    @FXML
    private Button medicalinsurance;
    @FXML
    private Button bookappointment;
    @FXML
    private Button messagedoctor;







public void load(){
    System.out.println("Stage started");
    Preferences userPreferences = Preferences.userRoot();

    String username = userPreferences.get("username","root");
    String password = userPreferences.get("password","root");
    System.out.println(username+"  USername in Insurance");
    System.out.print(password+" PAssword in Insurance");



    String excelFilePath=".\\datafiles\\Book1.xlsx";
    try {
        FileInputStream inputstream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet sheet = workbook.getSheetAt(3);    //XSSFSheet sheet=workbook.getSheet("Sheet4");


        ///////// Iterator ////////////////////////


        Iterator iterator = sheet.iterator();
        ArrayList<UserMedicalHistory> users = new ArrayList<>();
        while (iterator.hasNext()) {
            UserMedicalHistory user = new UserMedicalHistory();

            XSSFRow row = (XSSFRow) iterator.next();
            Iterator cellIterator = row.cellIterator();
            XSSFCell cell = (XSSFCell) cellIterator.next();
            user.setUsername(cell.getStringCellValue());
            System.out.println("Cell is :: "+cell.getStringCellValue());
            cell = (XSSFCell) cellIterator.next();
            user.setPassword(cell.getStringCellValue());
            cell = (XSSFCell) cellIterator.next();
            user.setPreviousCondition(cell.getStringCellValue());
            cell = (XSSFCell) cellIterator.next();
            user.setCurrentCondition(cell.getStringCellValue());
            cell = (XSSFCell) cellIterator.next();
            user.setVisitSummary(cell.getStringCellValue());
            cell = (XSSFCell) cellIterator.next();
            user.setPrescribedMedicines(cell.getStringCellValue());
            users.add(user);
        }
        inputstream.close();


        for (UserMedicalHistory user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentCondition.setText(user.getCurrentCondition());
                prescribedMedicines.setText(user.getPrescribedMedicines());
                previousCondition.setText(user.getPreviousCondition());
                visitSummary.setText(user.getVisitSummary());


            }

        }
    }
    catch(Exception e){
        e.printStackTrace();
    }

}


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


    public void doctorLoad(String id) {
        System.out.println("Stage started");
        Preferences userPreferences = Preferences.userRoot();

        String username = userPreferences.get("username","root");
        String password = userPreferences.get("password","root");
        System.out.println(username+"  USername in Insurance");
        System.out.print(password+" PAssword in Insurance");



        String excelFilePath=".\\datafiles\\Book1.xlsx";
        try {
            FileInputStream inputstream = new FileInputStream(excelFilePath);

            XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
            XSSFSheet sheet = workbook.getSheetAt(3);    //XSSFSheet sheet=workbook.getSheet("Sheet4");


            ///////// Iterator ////////////////////////


            Iterator iterator = sheet.iterator();
            ArrayList<UserMedicalHistory> users = new ArrayList<>();
            while (iterator.hasNext()) {
                UserMedicalHistory user = new UserMedicalHistory();

                XSSFRow row = (XSSFRow) iterator.next();
                Iterator cellIterator = row.cellIterator();
                XSSFCell cell = (XSSFCell) cellIterator.next();
                user.setUsername(cell.getStringCellValue());
                System.out.println("Cell is :: "+cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setPassword(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setPreviousCondition(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setCurrentCondition(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setVisitSummary(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setPrescribedMedicines(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellType(CellType.STRING);
                user.setId(cell.getStringCellValue());
                users.add(user);
            }
            inputstream.close();


            for (UserMedicalHistory user : users) {
                if (user.getId().equals(id)) {
                    currentCondition.setText(user.getCurrentCondition());
                    prescribedMedicines.setText(user.getPrescribedMedicines());
                    previousCondition.setText(user.getPreviousCondition());
                    visitSummary.setText(user.getVisitSummary());
                    contactus.setVisible(false);
                    doctor.setVisible(false);
                    personalDetails.setVisible(false);
                    medicalhistory.setVisible(false);
                    medicalinsurance.setVisible(false);
                    bookappointment.setVisible(false);
                    messagedoctor.setVisible(false);

                }




            }
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }
}
