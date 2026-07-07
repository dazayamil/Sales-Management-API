package com.dazayamil.salemanagementapi.dto.request;

import com.dazayamil.salemanagementapi.model.enums.Payment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record SaleCreateRequestDTO (
    @NotNull(message = "userId is required")
    Long userId,

    @NotNull(message = "paymentMethod is required")
    Payment paymentMethod,

    @NotEmpty(message = "items must contain at least one item")
    @Valid
    List<SaleItemRequestDTO> items
){}
