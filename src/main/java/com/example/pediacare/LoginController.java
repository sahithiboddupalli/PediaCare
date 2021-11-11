package com.example.pediacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.*;
import org.controlsfx.control.action.Action;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class LoginController {
    @FXML
    private Label loginText;

    @FXML
    private TextField loginUsername;

    @FXML
    private TextField loginPassword;

    @FXML
    public void onLoginClick(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(PatientPortal.class.getResource("patientportal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        String username = loginUsername.getText();
        String password = loginPassword.getText();

        String excelFilePath=".\\datafiles\\Book1.xlsx";
        FileInputStream inputstream=new FileInputStream(excelFilePath);

        XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
        XSSFSheet sheet=workbook.getSheetAt(0);	//XSSFSheet sheet=workbook.getSheet("Sheet1");




        ///////// Iterator ////////////////////////


        Iterator iterator=sheet.iterator();
        ArrayList<User> users = new ArrayList<>();
        while(iterator.hasNext())
        {
            User user = new User();

            XSSFRow row=(XSSFRow) iterator.next();

            Iterator cellIterator=row.cellIterator();
            XSSFCell cell=(XSSFCell) cellIterator.next();
            user.setUsername(cell.getStringCellValue());
             cell=(XSSFCell) cellIterator.next();
            user.setPassword(cell.getStringCellValue());
          users.add(user);
        }
        boolean status = false;
        for(User user1 : users){
            if(user1.getUsername().equals(username) && user1.getPassword().equals(password)){
                stage.show();
                status = true;
            }

        }
        if(status == false)
            loginText.setText("Try logging in with vaild credentials");








    }
}