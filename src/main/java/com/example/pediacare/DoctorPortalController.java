package com.example.pediacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

public class DoctorPortalController {


    @FXML
    private TextField id;
    @FXML
    private Label appointments;


    @FXML
    public void onSearchClick(ActionEvent event) throws Exception{

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(PatientMedicalHistoryApplication.class.getResource("patientmedicalhistory-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("PediaCare");
        stage.setScene(scene);
        PatientMedicalHistoryController controller =fxmlLoader.getController();
        controller.doctorLoad(id.getText());
        stage.show();

        /*String excelFilePath=".\\datafiles\\Book1.xlsx";
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
                if(cellIterator != null) {
                    cell = (XSSFCell) cellIterator.next();
                    cell.setCellType(CellType.STRING);
                    user.setId(cell.getStringCellValue());
                }
                users.add(user);
            }
            inputstream.close();


            for (UserMedicalHistory user : users) {
                if (user.getId().equals(id.getText())) {
                    currentcondtion.setText("Current Condition is : "+user.getCurrentCondition());
                    prescribedMedicines.setText("Patient name is : "+user.getPrescribedMedicines());
                    previouscondition.setText("Previous condition is : "+user.getPreviousCondition());
                    visitsummary.setText("Patient visit summary  is : "+user.getVisitSummary());
                    patientname.setText("Patient name is : "+user.getUsername());


                }
            }
        }
        catch (Exception e){
        e.printStackTrace();}*/
    }
    @FXML
    public void onDashboardClick(ActionEvent event) throws Exception{}
    @FXML
    public void onUploadPrescrptionClick(ActionEvent event) throws Exception{}
    @FXML
    public void onEnterFindingsClick(ActionEvent event) throws Exception{}
    @FXML
    public void onViewUpcomingAppointmentsClick(ActionEvent event) throws Exception{

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
                user.setUsername(cell.getStringCellValue());

                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                cell = (XSSFCell) cellIterator.next();
                user.setPassword(cell.getStringCellValue());
                if(cellIterator.hasNext()) {
                    cell = (XSSFCell) cellIterator.next();
                    user.setDate(cell.getStringCellValue());
                }
                users.add(user);

            }
            inputstream.close();
            appointments.setText("Upcoming appointments are: ");
            for (User user : users) {
                appointments.setText(user.getDate()+" Patient name is "+user.getUsername());
                break;

            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void onsendMessageClick(ActionEvent actionEvent) {



    }
}
