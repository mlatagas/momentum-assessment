package com.momentum.active.activeshoppe.controller;

import com.momentum.active.activeshoppe.model.Product;
import com.momentum.active.activeshoppe.service.ActiveShoppeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
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

    @PostMapping(value = "/v1/{customer-id}/purchase-product")
    @ApiOperation(value = "Product purchased",
            response = Product.class,
            responseContainer = "List")
    public ResponseEntity<List<Product>> purchaseProduct(@PathVariable("customer-id") int customerId, @RequestBody List<Product> products) {
        return ResponseEntity.ok(activeShoppeService.purchaseProduct(customerId, products));
    }


}
