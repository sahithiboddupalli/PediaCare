package com.example.pediacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.prefs.Preferences;

public class RegisteringController{
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public Label welcomeText;
    @FXML
    public TextField parentFirstName;
    @FXML
    public TextField parentLastName;
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    @FXML
    public TextField age;
    @FXML
    public TextField phone;
    @FXML
    public TextField email;


    @FXML
    public void onRegiClick(ActionEvent event) {
        try {
            String excelFilePath = "datafiles/Book1.xlsx";
            FileInputStream input = new FileInputStream(excelFilePath);
            XSSFWorkbook workbook = new XSSFWorkbook(input);
            XSSFSheet sheet = workbook.getSheetAt(1);    //XSSFSheet sheet=workbook.getSheet("Sheet1");
            input.close();

            Iterator iterator = sheet.iterator();


            int rowNum = sheet.getLastRowNum();
            Row row = sheet.createRow(rowNum + 1);

            int i = 0;
            Cell cell = row.createCell(i++);
            cell.setCellValue(firstName.getText());
            cell = row.createCell(i++);
            cell = row.createCell(i++);
            cell = row.createCell(i++);
            cell.setCellValue(parentFirstName.getText());
            cell = row.createCell(i++);
            cell = row.createCell(i++);
            cell.setCellValue(parentLastName.getText());
            cell = row.createCell(i++);
            cell.setCellValue(email.getText());
            cell = row.createCell(i++);
            cell.setCellValue(phone.getText());
            cell = row.createCell(i++);
            cell = row.createCell(i++);
            cell = row.createCell(i++);
            cell = row.createCell(i++);
            cell.setCellValue(username.getText());
            cell = row.createCell(i);
            cell.setCellValue(password.getText());
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();
            welcomeText.setText("Deatils Saved Successfully");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
}



