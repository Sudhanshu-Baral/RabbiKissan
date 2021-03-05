
package com.example.rabbikissan;

public class
Farmer {
    public String fullName,uid, Email, phoneNumber, Gender;


    public Farmer() {

    }

//    public Farmer(String fullName, String email, String phoneNumber, String gender) {
//        this.fullName = fullName;
//        Email = email;
//        this.phoneNumber = phoneNumber;
//        Gender = gender;
//    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "fullName='" + fullName + '\'' +
                ", uid='" + uid + '\'' +
                ", Email='" + Email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
