package com.dazayamil.salemanagementapi.service;

import com.dazayamil.salemanagementapi.dto.request.SaleCreateRequestDTO;
import com.dazayamil.salemanagementapi.dto.request.SaleUpdateRequestDTO;
import com.dazayamil.salemanagementapi.dto.response.DailyReportResponseDTO;
import com.dazayamil.salemanagementapi.dto.response.SaleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {
    SaleResponseDTO createSale(SaleCreateRequestDTO request);
    SaleResponseDTO getSaleById(Long id);
    List<SaleResponseDTO> getAllSales();
    SaleResponseDTO updateSaleById(Long id, SaleUpdateRequestDTO request);
    DailyReportResponseDTO getDailyReport(LocalDate date);
}
