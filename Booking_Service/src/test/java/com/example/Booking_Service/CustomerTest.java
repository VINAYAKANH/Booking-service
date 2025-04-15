package com.example.Booking_Service;


import com.example.Booking_Service.entity.Addres;
import com.example.Booking_Service.entity.Book;
import com.example.Booking_Service.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private Customer customer;
    private Book book;
    private Addres address;

    @BeforeEach
    public void setUp() {
        // Create a Customer
        customer = new Customer();
        customer.setCustomerId(1);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhone(new BigInteger("1234567890"));

        // Create an Address
        address = new Addres();
        address.setId(1);
        address.setHouseNo("123");
        address.setArea("Downtown");
        address.setCity("New York");
        address.setPincode(10001);
        address.setState("NY");

        // Set Address to Customer
        customer.setAddress(address);

        // Create a Book and associate with Customer
        book = new Book();
        book.setId(1);
        book.setName("Java Programming");
        book.setCategory("Tech");
        book.setAuthor("Joshua Bloch");
        book.setPublisher("Addison-Wesley");
        book.setCustomer(customer);

        // Add Book to Customer's Book List
        customer.setBooks(Collections.singletonList(book));
    }

    @Test
    public void testCustomerId() {
        assertEquals(1, customer.getCustomerId(), "Customer ID should be 1");
    }

    @Test
    public void testName() {
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName(), "Customer name should be 'Jane Doe'");
    }

    @Test
    public void testEmail() {
        customer.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", customer.getEmail(), "Customer email should be 'jane.doe@example.com'");
    }

    @Test
    public void testPhone() {
        customer.setPhone(new BigInteger("9876543210"));
        assertEquals(new BigInteger("9876543210"), customer.getPhone(), "Customer phone should be '9876543210'");
    }

    @Test
    public void testBooks() {
        assertNotNull(customer.getBooks(), "Books list should not be null");
        assertEquals(1, customer.getBooks().size(), "Customer should have one book in the list");
        assertEquals(book, customer.getBooks().get(0), "Customer's first book should be the one we set");
    }

    @Test
    public void testAddress() {
        assertNotNull(customer.getAddress(), "Customer address should not be null");
        assertEquals(address, customer.getAddress(), "Customer's address should be the one we set");
    }

    @Test
    public void testCustomerDetails() {
        // Verify all the customer details
        assertAll("customer",
                () -> assertEquals(1, customer.getCustomerId()),
                () -> assertEquals("John Doe", customer.getName()),
                () -> assertEquals("john.doe@example.com", customer.getEmail()),
                () -> assertEquals(new BigInteger("1234567890"), customer.getPhone())
        );
    }
}

