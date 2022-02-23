package com.example.MyBankApi.Repository;

import com.example.MyBankApi.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
