package com.momentum.active.activeshoppe.service.impl;

import com.google.common.collect.ImmutableList;
import com.momentum.active.activeshoppe.exception.ActiveShoppeBadRequestException;
import com.momentum.active.activeshoppe.exception.ActiveShoppeResourceNotFoundException;
import com.momentum.active.activeshoppe.model.Product;
import com.momentum.active.activeshoppe.service.ActiveShoppeService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActiveShoppeServiceImplTest {

    @Autowired
    private ActiveShoppeService classUnderTest;

    @Test
    void should_get_all_available_products() {
        assertNotNull(classUnderTest);
        assertEquals(5, classUnderTest.getAllProducts().size());
    }

    @Test
    void should_fail_with_ActiveShoppeBadRequestException_when_product_list_is_empty() {
        assertThrows(ActiveShoppeBadRequestException.class, () ->
                        classUnderTest.purchaseProduct(1, Collections.emptyList())
                , "The customer did not provide any products to purchase");
    }

    @Test
    void should_fail_with_ActiveShoppeResourceNotFoundException_when_customer_is_not_found() {
        val customerId = -10000;
        assertThrows(ActiveShoppeResourceNotFoundException.class, () -> {
            classUnderTest.purchaseProduct(customerId, ImmutableList.of(getFakeProduct(0, "Fake Name")));
        }, "User with id: " + customerId + " not found");
    }

    @Test
    void should_fail_with_ActiveShoppeResourceNotFoundException_when_one_or_more_products_is_not_found() {
        val customerId = 1;
        assertThrows(ActiveShoppeResourceNotFoundException.class, () -> {
            classUnderTest.purchaseProduct(customerId, ImmutableList.of(getFakeProduct(0, "Fake Name")));
        }, "One or more of the products you selected is currently unavailable.");
    }


    @Test
    void should_purchase_available_and_decrement_customer_available_points_products() {
        val productsPurchased = classUnderTest.purchaseProduct(1,ImmutableList.of(getFakeProduct(5, "Kanstock")));
        assertEquals(1,productsPurchased.size());
    }


    private static Product getFakeProduct(int productCode, String productName) {
        return Product.builder()
                .code(productCode)
                .name(productName)
                .build();
    }
}