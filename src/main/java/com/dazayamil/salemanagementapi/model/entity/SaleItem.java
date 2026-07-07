package com.dazayamil.salemanagementapi.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "sale_item")
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_size")
    private String productSize;

    @Column(name = "price_at_moment", nullable = false)
    private BigDecimal priceAtMoment;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
