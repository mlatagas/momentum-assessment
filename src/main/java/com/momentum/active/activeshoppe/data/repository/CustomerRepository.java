package com.momentum.active.activeshoppe.data.repository;

import com.momentum.active.activeshoppe.data.CustomerDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDao, Integer> {
    CustomerDao findByCustomerId(int customerId);
    @Override
    CustomerDao  saveAndFlush(CustomerDao customerDao);
}
