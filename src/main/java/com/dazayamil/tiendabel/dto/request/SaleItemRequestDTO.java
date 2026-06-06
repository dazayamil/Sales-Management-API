package com.dazayamil.tiendabel.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record SaleItemRequestDTO (

    @NotNull(message = "productId is required")
    Long productoId,

    @Min(value = 1, message = "quantity must be at least 1")
    int quantity,

    @NotBlank(message = "productSize is required")
    String productSize,

    @DecimalMin(value = "0.01", message = "priceAtMoment must be greater than 0")
    BigDecimal priceAtMoment
){}
