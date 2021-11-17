package com.example.pediacare;

public class UserInsurance {
    String username;
    String password;
    String healthInsuranceNumber;
    String healthAgentName;

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

    public String getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    public void setHealthInsuranceNumber(String healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    public String getHealthAgentName() {
        return healthAgentName;
    }

    public void setHealthAgentName(String healthAgentName) {
        this.healthAgentName = healthAgentName;
    }

    public String getMedicalSupport() {
        return medicalSupport;
    }

    public void setMedicalSupport(String medicalSupport) {
        this.medicalSupport = medicalSupport;
    }

    String medicalSupport;

}
