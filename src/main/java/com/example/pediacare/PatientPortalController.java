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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class PatientPortalController {
    @FXML
    public Label welcomeText;

    @FXML
    public Label dashboardText;

    @FXML
    public Label personalDetailsText;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;
    @FXML
    private TextField parentFirstName;
    @FXML
    private TextField middleName;

    @FXML
    private TextField email;

    @FXML
    private TextField parentMiddleName;

    @FXML
    private TextField parentLastName;

    @FXML
    private TextField phone;

    @FXML
    private TextField age;
    @FXML
    private TextField mail;
    @FXML
    private TextField gender;



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
    public void onSaveClick() throws IOException {


            String excelFilePath = "datafiles/Book1.xlsx";
            FileInputStream input = new FileInputStream(excelFilePath);
            XSSFWorkbook workbook = new XSSFWorkbook(input);
            XSSFSheet sheet = workbook.getSheetAt(1);    //XSSFSheet sheet=workbook.getSheet("Sheet1");
            input.close();
            int rowNum = sheet.getLastRowNum();
            Row row = sheet.createRow(rowNum + 1);
            int i = 0;
            Cell cell = row.createCell(i++);
            cell.setCellValue(firstName.getText());
            cell = row.createCell(i++);
            cell.setCellValue(middleName.getText());
            cell = row.createCell(i++);
            cell.setCellValue(lastName.getText());
            cell = row.createCell(i++);
            cell.setCellValue(parentFirstName.getText());
            cell = row.createCell(i++);
            cell.setCellValue(parentMiddleName.getText());
            cell = row.createCell(i++);
            cell.setCellValue(parentLastName.getText());
            cell = row.createCell(i++);
            cell.setCellValue(email.getText());
            cell = row.createCell(i++);
            cell.setCellValue(phone.getText());
            cell = row.createCell(i++);
            cell.setCellValue(mail.getText());
            cell = row.createCell(i++);
            cell.setCellValue(age.getText());
            cell = row.createCell(i);
            cell.setCellValue(gender.getText());
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();123    w
            welcomeText.setText("Deatils Saved Successfully");



    }

    @FXML
    public void onCancelClick() {
        welcomeText.setText("This is cancel on click page");
    }


}