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
        Product product = productRepository.findAllByActiveTrue(id).orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.teResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        Product product = Product.builder()
                .name(request.name())
                .category(request.category())
                .price(request.price())
                .build();

        Product savedProduct = productRepository.save(product);
        return productMapper.teResponseDTO(savedProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO request) {
        Product product = productRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(request.name());
        product.setCategory(request.category());
        product.setPrice(request.price());

        Product savedProduct = productRepository.save(product);
        return productMapper.teResponseDTO(savedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setActive(false);
        productRepository.save(product);
    }
}
