package com.example.Booking_Service;


import com.example.Booking_Service.Repository.BookRepository;
import com.example.Booking_Service.Repository.CustomerRepository;
import com.example.Booking_Service.Service.CustomerService;
import com.example.Booking_Service.entity.Book;
import com.example.Booking_Service.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;
    private Book book;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create sample data for tests
        customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setBooks(new ArrayList<>());

        book = new Book();
        book.setId(1);
        book.setName("Test Book");
        book.setCategory("Fiction");
    }

    @Test
    public void testCreateCustomer() {
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer savedCustomer = customerService.createCustomer(customer);

        assertNotNull(savedCustomer);
        assertEquals("John Doe", savedCustomer.getName());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(book);
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = customerService.getAllBooks();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0).getName());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void testGetCustomersByBookName() {
        // Initialize Customer and Book objects
        Customer customer = new Customer();
        customer.setName("John Doe");

        Book book = new Book();
        book.setName("Test Book");
        book.setCustomer(customer);  // Ensure the book has a customer

        // Create a list of books and add the book to it
        List<Book> books = new ArrayList<>();
        books.add(book);

        // Mock the behavior of the repositories
        when(bookRepository.findByName("Test Book")).thenReturn(books); // Mock bookRepository to return the list of books
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer)); // Mock customerRepository

        // Call the method to test
        List<Customer> customers = customerService.getCustomersByBookName("Test Book");

        // Perform assertions
        assertNotNull(customers);  // Ensure the result is not null
        assertEquals(1, customers.size());  // Ensure we have one customer
        assertEquals("John Doe", customers.get(0).getName());  // Check the customer's name

        // Verify interactions with the mock repositories
        verify(bookRepository, times(1)).findByName("Test Book");
    }


    @Test
    public void testGetCustomersByCategory() {
        // Initialize Customer and Book objects
        Customer customer = new Customer();
        customer.setName("John Doe");

        Book book = new Book();
        book.setCategory("Fiction");
        book.setCustomer(customer);  // Set the Customer for the Book

        // Create a list of books and add the book to it
        List<Book> books = new ArrayList<>();
        books.add(book);

        // Mock the behavior of the repositories
        when(bookRepository.findByCategory("Fiction")).thenReturn(books);
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        // Call the method to test
        List<Customer> customers = customerService.getCustomersByCategory("Fiction");

        // Perform assertions
        assertNotNull(customers);  // Ensure the result is not null
        assertEquals(1, customers.size());  // Ensure we have one customer
        assertEquals("John Doe", customers.get(0).getName());  // Check the customer's name

        // Verify interactions with the mock repositories
        verify(bookRepository, times(1)).findByCategory("Fiction");
    }

    @Test
    public void testGetBookByCategory() {
        List<Book> books = new ArrayList<>();
        books.add(book);
        when(bookRepository.findByCategory("Fiction")).thenReturn(books);

        List<Book> result = customerService.getBookByCategory("Fiction");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0).getName());
        verify(bookRepository, times(1)).findByCategory("Fiction");
    }

    @Test
    public void testAssignBookToCustomer() {
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        when(bookRepository.save(book)).thenReturn(book);
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer updatedCustomer = customerService.assignBookToCustomer(1, book);

        assertNotNull(updatedCustomer);
        assertTrue(updatedCustomer.getBooks().contains(book));
        verify(bookRepository, times(1)).save(book);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testAssignBookToCustomerWhenCustomerNotFound() {
        when(customerRepository.findById(1)).thenReturn(Optional.empty());

        Customer updatedCustomer = customerService.assignBookToCustomer(1, book);

        assertNull(updatedCustomer);
        verify(customerRepository, times(1)).findById(1);
    }
}

