package com.dazayamil.salemanagementapi.controller;

import com.dazayamil.salemanagementapi.dto.response.ProductResponseDTO;
import com.dazayamil.salemanagementapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //Solo accesible para usuarios con el rol ADMIN y EMPLOYEE
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id){
        ProductResponseDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
}
