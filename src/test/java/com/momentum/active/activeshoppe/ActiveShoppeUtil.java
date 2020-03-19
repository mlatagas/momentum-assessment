package com.momentum.active.activeshoppe;

import com.momentum.active.activeshoppe.model.Product;

public class ActiveShoppeUtil {

    public static Product getFakeProduct(int productCode, String productName, int pointsCost) {
        return Product.builder()
                .code(productCode)
                .name(productName)
                .points(pointsCost)
                .build();
    }
}
