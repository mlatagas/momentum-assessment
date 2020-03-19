package com.momentum.active.activeshoppe.service.impl;

import com.momentum.active.activeshoppe.data.repository.CustomerRepository;
import com.momentum.active.activeshoppe.data.repository.ProductRepository;
import com.momentum.active.activeshoppe.exception.ActiveShoppeBadRequestException;
import com.momentum.active.activeshoppe.exception.ActiveShoppeResourceNotFoundException;
import com.momentum.active.activeshoppe.model.Product;
import com.momentum.active.activeshoppe.service.ActiveShoppeService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ActiveShoppeServiceImpl implements ActiveShoppeService {

    ProductRepository productRepository;
    CustomerRepository customerRepository;

    @Autowired
    public ActiveShoppeServiceImpl(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        val productDaoList = productRepository.findAll();
        val productList = new ArrayList<Product>();
        productDaoList.forEach(it -> productList.add(Product.builder().productSource(it).build()));
        return productList;
    }

    @Override
    public List<Product> purchaseProduct(int customerId, List<Product> products) {

        if (products.isEmpty()) {
            throw new ActiveShoppeBadRequestException("The customer did not provide any products to purchase");
        }

        val customer = customerRepository.findByCustomerId(customerId);

        if (null == customer) {
            throw new ActiveShoppeResourceNotFoundException("User with id: " + customerId + " not found");
        }

        val customerPoints = customer.getActiveDayPoints();
        val availableProducts = getAllProducts();
        if (availableProducts.containsAll(products)) {
            val pointsRequired = products.stream().map(it -> customerPoints).count();
            val pointsDifference = customerPoints - pointsRequired;
            if (pointsDifference >= 0) {
                customer.setActiveDayPoints(Math.toIntExact(pointsDifference));
                customerRepository.saveAndFlush(customer);
                return products;
            }
            throw new ActiveShoppeBadRequestException("Number of points required: " + pointsRequired + "for purchase exceeds customers available points: " + customerPoints);

        }
        throw new ActiveShoppeResourceNotFoundException("One or more of the products you selected is currently unavailable.");
    }
}
