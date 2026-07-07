package com.dazayamil.salemanagementapi.repository;

import com.dazayamil.salemanagementapi.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
