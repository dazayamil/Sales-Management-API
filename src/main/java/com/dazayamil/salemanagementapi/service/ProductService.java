package com.dazayamil.salemanagementapi.service;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO createProduct(ProductRequestDTO request);
    ProductResponseDTO updateProducto(Long id, ProductRequestDTO request);
    void deleteProduct(Long id);
}
