package com.example.pediacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class PharmacyViewController{
    @FXML
    private Label welcomeText;
    @FXML
    private TextField preferedPharmacy;
    @FXML
    private TextArea prescription;

    public void onHomeClick(ActionEvent actionEvent) {
    }

    public void onContactUsClick(ActionEvent actionEvent) {
    }

    public void onDoctorClick(ActionEvent actionEvent) {
    }

    public void onPersonalDetailsClick(ActionEvent actionEvent) {
    }

    public void onMedicalHistoryClick(ActionEvent actionEvent) {
    }

    public void onMedicalInsuranceClick(ActionEvent actionEvent) {
    }

    public void onBookAppointmentClick(ActionEvent actionEvent) {
    }

    public void onMessageDoctorClick(ActionEvent actionEvent) {
    }

    public void sendprescription(ActionEvent actionEvent) {
        welcomeText.setText("Your prescription will be mailed to pharmacy  shortly");

    }
    public void load(){
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
                cell = (XSSFCell) cellIterator.next();
                user.setPharmacy(cell.getStringCellValue());

                users.add(user);
            }
            inputstream.close();


            for (UserMedicalHistory user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    prescription.setText(user.getPrescribedMedicines());
                    preferedPharmacy.setText(user.getPharmacy());


                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }


}
