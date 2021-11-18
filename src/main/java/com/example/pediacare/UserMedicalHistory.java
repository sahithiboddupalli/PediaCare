package com.example.pediacare;

public class UserMedicalHistory {
    String username;
    String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String currentCondition;

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    String id;
    String pharmacy;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    public String getPreviousCondition() {
        return previousCondition;
    }

    public void setPreviousCondition(String previousCondition) {
        this.previousCondition = previousCondition;
    }

    public String getVisitSummary() {
        return visitSummary;
    }

    public void setVisitSummary(String visitSummary) {
        this.visitSummary = visitSummary;
    }

    public String getPrescribedMedicines() {
        return prescribedMedicines;
    }

    public void setPrescribedMedicines(String prescribedMedicines) {
        this.prescribedMedicines = prescribedMedicines;
    }

    String previousCondition;
    String visitSummary;
    String prescribedMedicines;

}
