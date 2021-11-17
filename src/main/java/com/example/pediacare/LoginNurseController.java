package com.example.pediacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class LoginNurseController {
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    @FXML
    public Label loginText;

    @FXML
    public void onLoginNurseButtonClick(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("nurseportal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("Login");
        stage.setScene(scene);

        String username1 = username.getText();
        String password1 = password.getText();




        String excelFilePath=".\\datafiles\\Book1.xlsx";
        FileInputStream inputstream=new FileInputStream(excelFilePath);

        XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
        XSSFSheet sheet=workbook.getSheetAt(5);




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
        inputstream.close();
        boolean status = false;

        for(User user : users){
            if(user.getUsername().equals(username1) && user.getPassword().equals(password1)){
                stage.show();
                loginText.setText("");

                status = true;
            }

        }
        if(status == false){
            loginText.setText("Enter Valid Credentials");
        }

    }
}
