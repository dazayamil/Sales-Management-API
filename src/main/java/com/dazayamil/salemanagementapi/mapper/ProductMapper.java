package com.dazayamil.salemanagementapi.mapper;

import com.dazayamil.salemanagementapi.dto.response.ProductResponseDTO;
import com.dazayamil.salemanagementapi.model.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ProductMapper {
    ProductResponseDTO teRespondeDTO(Product product);
    List<ProductResponseDTO> toResponseDTOlist(List<Product> products);
}
