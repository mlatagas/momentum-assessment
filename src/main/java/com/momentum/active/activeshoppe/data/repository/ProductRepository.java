package com.momentum.active.activeshoppe.data.repository;

import com.momentum.active.activeshoppe.data.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductDao, Integer> {
    List<ProductDao> findAll();
}
