package com.example.Booking_Service;


import com.example.Booking_Service.entity.Book;
import com.example.Booking_Service.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer(); // Assuming you have a Customer entity
        customer.setId(1); // Initialize Customer with a mock ID
        customer.setName("John Doe"); // Initialize Customer's name (if needed)

        // Initialize Book object
        book = new Book();
        book.setId(1);
        book.setName("Java Programming");
        book.setCategory("Tech");
        book.setAuthor("Joshua Bloch");
        book.setPublisher("Addison-Wesley");
        book.setCustomer(customer);
    }

    @Test
    public void testId() {
        assertEquals(1, book.getId(), "Book ID should be 1");
    }

    @Test
    public void testName() {
        book.setName("Effective Java");
        assertEquals("Effective Java", book.getName(), "Book name should be 'Effective Java'");
    }

    @Test
    public void testCategory() {
        book.setCategory("Programming");
        assertEquals("Programming", book.getCategory(), "Book category should be 'Programming'");
    }

    @Test
    public void testAuthor() {
        book.setAuthor("Joshua Bloch");
        assertEquals("Joshua Bloch", book.getAuthor(), "Book author should be 'Joshua Bloch'");
    }

    @Test
    public void testPublisher() {
        book.setPublisher("Addison-Wesley");
        assertEquals("Addison-Wesley", book.getPublisher(), "Book publisher should be 'Addison-Wesley'");
    }

    @Test
    public void testCustomer() {
        book.setCustomer(customer);
        assertEquals(customer, book.getCustomer(), "Book's customer should be 'John Doe'");
    }

    @Test
    public void testBookDetails() {
        // Set book details and verify
        book.setId(1);
        book.setName("Effective Java");
        book.setCategory("Programming");
        book.setAuthor("Joshua Bloch");
        book.setPublisher("Addison-Wesley");
        book.setCustomer(customer);

        assertAll("book",
                () -> assertEquals(1, book.getId()),
                () -> assertEquals("Effective Java", book.getName()),
                () -> assertEquals("Programming", book.getCategory()),
                () -> assertEquals("Joshua Bloch", book.getAuthor()),
                () -> assertEquals("Addison-Wesley", book.getPublisher()),
                () -> assertEquals(customer, book.getCustomer())
        );
    }
}
