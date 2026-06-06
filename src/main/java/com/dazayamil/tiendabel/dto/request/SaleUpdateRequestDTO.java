package com.dazayamil.tiendabel.dto.request;

import com.dazayamil.tiendabel.model.enums.Payment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record SaleUpdateRequestDTO (
    @NotNull(message = "paymentMethod is required")
    Payment paymentMethod,
    @NotEmpty(message = "items must contain at least one item")
    @Valid
    List<SaleItemRequestDTO> items
){}
