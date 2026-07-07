package com.dazayamil.salemanagementapi.dto.response;

import com.dazayamil.salemanagementapi.model.enums.Status;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SaleResponseDTO(
        Long saleId,
        LocalDateTime createdAt,
        BigDecimal totalAmount,
        Status status
) {}
