package com.example.pediacare;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class PatientDashboardController implements Initializable {
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

    @FXML
    public void onPreferredPharmacyClick() throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(PatientPreferredPharmacyApplication.class.getResource("patientpreferredpharmacy-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("PediaCare");
        stage.setScene(scene);
        stage.show();
    }

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
    public void onSaveClick() throws IOException {
        String excelFilePath = "datafiles/Book1.xlsx";
        FileInputStream input = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheetAt(1);    //XSSFSheet sheet=workbook.getSheet("Sheet1");
        input.close();
        boolean status = false;

        Iterator iterator = sheet.iterator();
        ArrayList<User> users = new ArrayList<>();
        while (iterator.hasNext()) {
            User user = new User();

            Row row = (Row) iterator.next();
            Iterator cellIterator = row.cellIterator();
            XSSFCell cell = (XSSFCell) cellIterator.next();
            if (cell.getStringCellValue().equals(firstName.getText())) {
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(middleName.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(lastName.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(parentFirstName.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(parentMiddleName.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(parentLastName.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(email.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(phone.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(mail.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(age.getText());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(gender.getText());
                cell = (XSSFCell) cellIterator.next();
                Preferences userPreferences = Preferences.userRoot();

                String username = userPreferences.get("username", "root");
                String password = userPreferences.get("password", "root");
                cell.setCellValue(username);
                cell = (XSSFCell) cellIterator.next();
                cell.setCellValue(password);
                users.add(user);
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
            cell = row.createCell(i++);
            cell.setCellValue(gender.getText());
            Preferences userPreferences = Preferences.userRoot();

            String username = userPreferences.get("username", "root");
            String password = userPreferences.get("password", "root");
            cell = row.createCell(i++);
            cell.setCellValue(username);
            cell = row.createCell(i);
            cell.setCellValue(password);
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();
            welcomeText.setText("Deatils Saved Successfully");

        }
    }

    @FXML
    public void onCancelClick() {
        welcomeText.setText("This is cancel on click page");
    }

    public void load() {
        System.out.println("Stage started");
        Preferences userPreferences = Preferences.userRoot();

        String username = userPreferences.get("username","root");
        String password = userPreferences.get("password","root");



        String excelFilePath=".\\datafiles\\Book1.xlsx";
        try {
            FileInputStream inputstream = new FileInputStream(excelFilePath);

            XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
            XSSFSheet sheet = workbook.getSheetAt(1);    //XSSFSheet sheet=workbook.getSheet("Sheet1");


            ///////// Iterator ////////////////////////


            Iterator iterator = sheet.iterator();
            ArrayList<User> users = new ArrayList<>();
            while (iterator.hasNext()) {
                User user = new User();

                XSSFRow row = (XSSFRow) iterator.next();
                Iterator cellIterator = row.cellIterator();
                XSSFCell cell = (XSSFCell) cellIterator.next();
                user.setFirstName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setMiddleName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setLastName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setParentFirstName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setParentMiddleName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setParentLastName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setEmail(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setPhone(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setMail(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setAge(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setGender(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setUsername(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setPassword(cell.getStringCellValue());
                users.add(user);
            }
            inputstream.close();


            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    firstName.setText(user.getFirstName());
                    lastName.setText(user.getLastName());
                    middleName.setText(user.getMiddleName());
                    parentFirstName.setText(user.getParentFirstName());
                    parentLastName.setText(user.getParentLastName());
                    parentMiddleName.setText(user.getParentMiddleName());
                    email.setText(user.getEmail());
                    phone.setText(user.getPhone());
                    mail.setText(user.getMail());
                    age.setText(user.getAge());
                    gender.setText(user.getGender());

                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void nurseload(String id) {
        String excelFilePath=".\\datafiles\\Book1.xlsx";
        try {
            FileInputStream inputstream = new FileInputStream(excelFilePath);

            XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
            XSSFSheet sheet = workbook.getSheetAt(1);    //XSSFSheet sheet=workbook.getSheet("Sheet1");


            ///////// Iterator ////////////////////////


            Iterator iterator = sheet.iterator();
            ArrayList<User> users = new ArrayList<>();
            while (iterator.hasNext()) {
                User user = new User();

                XSSFRow row = (XSSFRow) iterator.next();
                Iterator cellIterator = row.cellIterator();
                XSSFCell cell = (XSSFCell) cellIterator.next();
                user.setFirstName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setMiddleName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setLastName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setParentFirstName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setParentMiddleName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setParentLastName(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setEmail(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setPhone(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setMail(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setAge(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setGender(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setUsername(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                user.setPassword(cell.getStringCellValue());
                cell = (XSSFCell) cellIterator.next();
                cell.setCellType(CellType.STRING);
                cell = (XSSFCell) cellIterator.next();
                cell.setCellType(CellType.STRING);
                System.out.println(cell.getStringCellValue());
                user.setId(cell.getStringCellValue());

                users.add(user);
            }
            inputstream.close();


            for (User user : users) {
                System.out.println(user.getId()+" inside enhanced llop");
                if (user.getId().equals(id)) {
                    firstName.setText(user.getFirstName());
                    lastName.setText(user.getLastName());
                    middleName.setText(user.getMiddleName());
                    parentFirstName.setText(user.getParentFirstName());
                    parentLastName.setText(user.getParentLastName());
                    parentMiddleName.setText(user.getParentMiddleName());
                    email.setText(user.getEmail());
                    phone.setText(user.getPhone());
                    mail.setText(user.getMail());
                    age.setText(user.getAge());
                    gender.setText(user.getGender());

                }

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}