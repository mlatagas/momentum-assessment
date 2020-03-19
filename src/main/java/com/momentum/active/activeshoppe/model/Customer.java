package com.momentum.active.activeshoppe.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Customer {
    @NonNull int customerId;
    @NonNull String customerName;
    @NonNull int activeDaysPoints;
}
