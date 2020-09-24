package com.capgemini.pecuniabootcamp.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "CustomerEntity")
public class CustomerEntity {
    @Id
    @Column(name = "Customer_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
//    @NotNull
//    @Size(min=2, message="Name must not be less than 2 characters")
    private String name;
//    @NotNull
    @Column(unique=true)
    private long contactNumber;
//    @NotNull
    @Column(unique=true)
    private long aadharNumber;
//    @NotNull
    @Column(unique=true)
    private String panNumber;
//    @NotNull
    private String gender;
//    @NotNull
    private String dateOfBirth;
//    @NotNull
    private String address;
//    @NotNull
    private String city;
//    @NotNull
    private String state;
//    @NotNull
    private String country;
//    @NotNull
    private long zipCode;
//    @NotNull
    private double balance;
    @Enumerated
//    @NotNull
    private Status status;
//    @NotNull
    private int creditScore;




    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(long aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
