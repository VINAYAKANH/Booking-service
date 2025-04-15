package com.example.Booking_Service.entity;



import jakarta.persistence.*;


import java.math.BigInteger;

import java.util.List;

@Entity

public class Customer {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int customerId;

    private String name;

    private String email;

    private BigInteger phone;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)

    private List<Book> books;

    @OneToOne(cascade = CascadeType.ALL)

    private Addres address;

    public Customer(int i, String johnDoe, String mail) {
    }

    public Customer() {

    }

    public int getCustomerId() {

        return customerId;

    }

    public void setCustomerId(int customerId) {

        this.customerId = customerId;

    }

    // Getters and Setters


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public BigInteger getPhone() { return phone; }

    public void setPhone(BigInteger phone) { this.phone = phone; }

    public List<Book> getBooks() { return books; }

    public void setBooks(List<Book> books) { this.books = books; }

    public Addres getAddress() { return address; }

    public void setAddress(Addres address) { this.address = address; }

    public void setId(int i) {
    }
}

