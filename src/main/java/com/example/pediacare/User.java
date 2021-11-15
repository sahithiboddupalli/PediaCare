package com.example.pediacare;

public class User {
    String username;
    String password;
    String firstName;
    String lastName;
    String parentFirstName;
    String parentLastName;
    String email;
    int phone;
    String mail;
    int age;
    String gender;

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

    public String getFirstName(){return firstName; }

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName(){return lastName; }

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getParentFirstName(){return parentFirstName; }

    public void setParentFirstName(String parentFirstName) {this.parentFirstName = parentFirstName;}

    public String getParentLastName(){return parentLastName; }

    public void setParentLastName(String parentLastName) {this.parentLastName = parentLastName;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}
