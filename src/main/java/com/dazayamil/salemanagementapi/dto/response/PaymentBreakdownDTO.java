package com.dazayamil.salemanagementapi.dto.response;

import com.dazayamil.salemanagementapi.model.enums.Payment;
import java.math.BigDecimal;

public record PaymentBreakdownDTO (
    Payment paymentMethod,
    int count,
    BigDecimal total
){}
