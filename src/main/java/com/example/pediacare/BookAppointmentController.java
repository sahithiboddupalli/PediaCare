package com.example.pediacare;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.prefs.Preferences;

public class BookAppointmentController {

    @FXML
    private Label welcomeText;
    @FXML
    private TextArea healthIssue;
    @FXML
    private DatePicker date;


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

    }

    @FXML
    public void onSelectDate() throws Exception{


    }

    @FXML
    public void onBooking() throws Exception{

        String excelFilePath = "datafiles/Book1.xlsx";
        FileInputStream input = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheetAt(1);    //XSSFSheet sheet=workbook.getSheet("Sheet1");
        input.close();
        boolean status = false;

        Iterator iterator = sheet.iterator();
        ArrayList<User> users = new ArrayList<>();
        int i = 0;
        while (iterator.hasNext()) {
            User user = new User();

            Row row = (Row) iterator.next();
            Iterator cellIterator = row.cellIterator();

            XSSFCell cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                cell = (XSSFCell) cellIterator.next();
            i++;
                Preferences userPreferences = Preferences.userRoot();

                String username = userPreferences.get("username", "root");
                String password = userPreferences.get("password", "root");
                System.out.println(username);
                System.out.println(password);

                if(cell.getStringCellValue().equals(username)) {
                    cell = (XSSFCell) cellIterator.next();
                    i++;
                   if(cell.getStringCellValue().equals(password)){


                            cell = (XSSFCell) row.createCell(i++);
                            LocalDate date1 = date.getValue();
                            cell.setCellValue(date1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));



                    }
                }
                }
                FileOutputStream outputStream = new FileOutputStream(excelFilePath);
                workbook.write(outputStream);
                outputStream.flush();
                outputStream.close();
                workbook.close();


        welcomeText.setText("Appointment sucessfully booked on "+date.getValue());

    }
}
