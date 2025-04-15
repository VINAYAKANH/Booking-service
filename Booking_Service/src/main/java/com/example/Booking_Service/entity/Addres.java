package com.example.Booking_Service.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;


@Entity

public class Addres{

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String houseNo;

    private String area;

    private String city;

    private long pincode;

    private String state;

    // Getters and Setters

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getHouseNo() { return houseNo; }

    public void setHouseNo(String houseNo) { this.houseNo = houseNo; }

    public String getArea() { return area; }

    public void setArea(String area) { this.area = area; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public long getPincode() { return pincode; }

    public void setPincode(long pincode) { this.pincode = pincode; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

}



