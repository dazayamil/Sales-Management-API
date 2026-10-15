package com.dazayamil.salemanagementapi.dto.response;

import com.dazayamil.salemanagementapi.model.enums.Category;

import java.math.BigDecimal;

public record ProductRespondeDTO(
        Long id,
        String name,
        Category category,
        BigDecimal price,
        boolean active
) {
}
