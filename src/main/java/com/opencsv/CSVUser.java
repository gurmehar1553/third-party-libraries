package com.opencsv;

import com.opencsv.bean.CsvBindByName;
// POJO class for reading CSV Directory
public class CSVUser {
    @CsvBindByName
    private String name;
    @CsvBindByName(column = "email",required = true)
    private String email;
    @CsvBindByName(column = "phoneNo")
    private String phoneNo;
    @CsvBindByName(column = "country")
    private String country;
    public CSVUser(){

    }
    public CSVUser(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }

    @Override
    public String toString() {
        return "CSVUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
