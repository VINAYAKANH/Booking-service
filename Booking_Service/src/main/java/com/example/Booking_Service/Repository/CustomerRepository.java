package com.example.Booking_Service.Repository;




import com.example.Booking_Service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    List<Customer> findByBooks_Category(String category);

//    List<Customer> findByBooks_Title(String title);

}

