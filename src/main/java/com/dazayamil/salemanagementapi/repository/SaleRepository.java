package com.dazayamil.salemanagementapi.repository;

import com.dazayamil.salemanagementapi.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}
