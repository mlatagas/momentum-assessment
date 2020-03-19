package com.momentum.active.activeshoppe.service;

import com.momentum.active.activeshoppe.model.Product;

import java.util.List;

public interface ActiveShoppeService {

   List<Product> getAllProducts();

   List<Product> purchaseProduct(int customerId, List<Product> products);
}
