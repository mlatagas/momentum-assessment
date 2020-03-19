package com.momentum.active.activeshoppe.controller;

import com.momentum.active.activeshoppe.model.Product;
import com.momentum.active.activeshoppe.service.ActiveShoppeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@CrossOrigin
@RestController
//@Timed
@Slf4j
public class ActiveShoppeController {

    ActiveShoppeService activeShoppeService;

    @Autowired
    public ActiveShoppeController(ActiveShoppeService activeShoppeService) {
        this.activeShoppeService = activeShoppeService;
    }

    @GetMapping(value = "/v1/products")
    @ApiOperation(value = "Returns a List of available products",
            response = Product.class,
            responseContainer = "List")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(activeShoppeService.getAllProducts());
    }

    @PostMapping(value = "/v1/{customer-id}/purchase-product",consumes="application/json",
            produces="application/json")
    @ApiOperation(value = "Product purchased",
            response = Product.class,
            responseContainer = "List")
    public ResponseEntity<List<Product>> purchaseProduct(@PathVariable("customer-id") int customerId, @RequestBody List<Product> products) {
        log.info("requesting product(s): {} for customerId: {}", products, customerId);
        return ResponseEntity.ok(activeShoppeService.purchaseProduct(customerId, products));
    }


}
