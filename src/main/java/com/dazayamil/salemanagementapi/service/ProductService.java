package com.dazayamil.salemanagementapi.service;

import com.dazayamil.salemanagementapi.dto.request.ProductRequestDTO;
import com.dazayamil.salemanagementapi.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO createProduct(ProductRequestDTO dto);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto);
    void deleteProduct(Long id);
}
