package com.devteria.identityservice.mapper;

import com.devteria.identityservice.dto.response.PageProductResponse;
import com.devteria.identityservice.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  //  Page<PageProductResponse> toPageProductResponse(  Page<Product> productsPage);
}
