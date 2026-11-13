package com.dazayamil.salemanagementapi.mapper;

import com.dazayamil.salemanagementapi.dto.response.ProductResponseDTO;
import com.dazayamil.salemanagementapi.dto.response.UserResponseDTO;
import com.dazayamil.salemanagementapi.model.entity.Product;
import com.dazayamil.salemanagementapi.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toResponseDTO(User user);
    List<UserResponseDTO> toResponseDTOlist(List<User> users);
}
