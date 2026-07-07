package com.dazayamil.salemanagementapi.mapper;

import com.dazayamil.salemanagementapi.dto.response.SaleResponseDTO;
import com.dazayamil.salemanagementapi.model.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(source = "id", target = "saleId")
    SaleResponseDTO toResponseDTO(Sale sale);
    List<SaleResponseDTO> toResponseDTOList (List<Sale> sales);
}
