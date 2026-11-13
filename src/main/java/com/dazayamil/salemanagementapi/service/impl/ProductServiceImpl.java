package com.dazayamil.salemanagementapi.service.impl;

import com.dazayamil.salemanagementapi.dto.request.ProductRequestDTO;
import com.dazayamil.salemanagementapi.dto.response.ProductResponseDTO;
import com.dazayamil.salemanagementapi.exception.ProductNotFoundException;
import com.dazayamil.salemanagementapi.mapper.ProductMapper;
import com.dazayamil.salemanagementapi.model.entity.Product;
import com.dazayamil.salemanagementapi.repository.ProductRepository;
import com.dazayamil.salemanagementapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository){
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAllByActiveTrue();
        return productMapper.toResponseDTOList(products);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findByIdAndActiveTrue(  id).orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.toResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Product product = Product.builder()
                .name(dto.name())
                .category(dto.category())
                .price(dto.price())
                .build();

        Product savedProduct = productRepository.save(product);
        return productMapper.toResponseDTO(savedProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {
        Product product = productRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(dto.name());
        product.setCategory(dto.category());
        product.setPrice(dto.price());

        Product savedProduct = productRepository.save(product);
        return productMapper.toResponseDTO(savedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setActive(false);
        productRepository.save(product);
    }
}
