package com.dazayamil.tiendabel.dto.response;

import com.dazayamil.tiendabel.model.enums.Payment;
import java.math.BigDecimal;

public record PaymentBreakdownDTO (
    Payment paymentMethod,
    int count,
    BigDecimal total
){}
