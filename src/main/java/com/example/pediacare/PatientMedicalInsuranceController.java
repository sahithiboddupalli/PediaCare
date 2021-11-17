package com.example.pediacare;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.prefs.Preferences;

public class PatientMedicalInsuranceController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField healthInsuranceNumber;
    @FXML
    private TextField healthInsuranceAgent;
    @FXML
    private TextField medicalSupport;


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
        String excelFilePath = "datafiles/Book1.xlsx";
        FileInputStream input = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheetAt(2);    //XSSFSheet sheet=workbook.getSheet("Sheet1");
        input.close();
        boolean status = false;

        Iterator iterator = sheet.iterator();
        ArrayList<UserInsurance> users = new ArrayList<>();
        while (iterator.hasNext()) {

            Row row = (Row) iterator.next();
            Iterator cellIterator = row.cellIterator();
            XSSFCell cell = (XSSFCell) cellIterator.next();
            if (cell.getStringCellValue().equals(healthInsuranceAgent.getText())) {
                Preferences userPreferences = Preferences.userRoot();

                String username = userPreferences.get("username", "root");
                String password = userPreferences.get("password", "root");
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(username);
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(password);
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(healthInsuranceNumber.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(healthInsuranceAgent.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(medicalSupport.getText());
                status = true;
                FileOutputStream outputStream = new FileOutputStream(excelFilePath);
                workbook.write(outputStream);
                outputStream.flush();
                outputStream.close();
                workbook.close();
                welcomeText.setText("Deatils Saved Successfully");
            }

        }


        if (status == false) {
            int rowNum = sheet.getLastRowNum();
            Row row = sheet.createRow(rowNum + 1);

            int i = 0;
            Preferences userPreferences = Preferences.userRoot();

            String username = userPreferences.get("username", "root");
            String password = userPreferences.get("password", "root");
            Cell cell = row.createCell(i++);
            cell.setCellValue(username);
            cell = row.createCell(i++);
            cell.setCellValue(password);
            cell = row.createCell(i++);
            cell.setCellValue(healthInsuranceNumber.getText());
            cell = row.createCell(i++);
            cell.setCellValue(healthInsuranceAgent.getText());
            cell = row.createCell(i);
            cell.setCellValue(medicalSupport.getText());

            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();
            welcomeText.setText("Deatils Saved Successfully");

        }

    }

    public void load() {
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
            XSSFSheet sheet = workbook.getSheetAt(2);    //XSSFSheet sheet=workbook.getSheet("Sheet1");


            ///////// Iterator ////////////////////////


            Iterator iterator = sheet.iterator();
            ArrayList<UserInsurance> users = new ArrayList<>();
            while (iterator.hasNext()) {
                UserInsurance user = new UserInsurance();

                XSSFRow row = (XSSFRow) iterator.next();
                Iterator cellIterator = row.cellIterator();
                XSSFCell cell = (XSSFCell) cellIterator.next();
                user.setUsername(cell.getStringCellValue());
                System.out.println("Cell is :: "+cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setPassword(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setHealthInsuranceNumber(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setHealthAgentName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setMedicalSupport(cell.getStringCellValue());
                users.add(user);
            }
            inputstream.close();


            for (UserInsurance user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    healthInsuranceNumber.setText(user.getHealthInsuranceNumber());
                    healthInsuranceAgent.setText(user.getHealthAgentName());
                    medicalSupport.setText(user.getMedicalSupport());

                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
