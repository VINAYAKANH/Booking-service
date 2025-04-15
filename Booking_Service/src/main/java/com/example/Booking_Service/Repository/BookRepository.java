package com.example.Booking_Service.Repository;

import com.example.Booking_Service.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByName(String name);
    List<Book> findByCategory(String category);
}
