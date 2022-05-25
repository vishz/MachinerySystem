package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer where nic=? ", nativeQuery = true)
    Optional<Customer> getCustomerByNic(String nic);
}
