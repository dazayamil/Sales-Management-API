package com.dazayamil.salemanagementapi.service;

import com.dazayamil.salemanagementapi.dto.request.ProductRequestDTO;
import com.dazayamil.salemanagementapi.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO createProduct(ProductRequestDTO request);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO request);
    void deleteProduct(Long id);
}
