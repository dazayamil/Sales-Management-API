package com.dazayamil.salemanagementapi.service.impl;

import com.dazayamil.salemanagementapi.dto.response.ProductResponseDTO;
import com.dazayamil.salemanagementapi.mapper.ProductMapper;
import com.dazayamil.salemanagementapi.model.entity.Product;
import com.dazayamil.salemanagementapi.repository.ProductRepository;
import com.dazayamil.salemanagementapi.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository){
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.finAllByActiveTrue();
        return productMapper.toResponseDTOlist(products);
    }

}
