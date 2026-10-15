package com.dazayamil.salemanagementapi.dto.request;

import com.dazayamil.salemanagementapi.model.enums.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDTO (
    @NotBlank(message = "name is required")
    String name,

    @NotNull(message = "category is required")
    Category category,

    @NotNull(message = "price is required")
    @DecimalMin(value = "0.01", message = "price must be greater than 0")
    BigDecimal price
)
{}
