package com.dazayamil.salemanagementapi.repository;

import com.dazayamil.salemanagementapi.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByActiveTrue();
    Optional<Product> findAllByActiveTrue(Long id);
    Optional<Product> findByIdAndActiveTrue(Long id);
}
