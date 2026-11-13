package com.dazayamil.salemanagementapi.service;

import com.dazayamil.salemanagementapi.dto.request.SaleCreateRequestDTO;
import com.dazayamil.salemanagementapi.dto.request.SaleUpdateRequestDTO;
import com.dazayamil.salemanagementapi.dto.response.DailyReportResponseDTO;
import com.dazayamil.salemanagementapi.dto.response.SaleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {
    List<SaleResponseDTO> getAllSales();
    SaleResponseDTO createSale(SaleCreateRequestDTO dto);
    SaleResponseDTO getSaleById(Long id);
    SaleResponseDTO updateSaleById(Long id, SaleUpdateRequestDTO dto);
    DailyReportResponseDTO getDailyReport(LocalDate date);
}
