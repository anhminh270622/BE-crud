package com.example.demo.mapper;

import com.example.demo.dto.request.ProductCreationRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductCreationRequest product);

    ProductResponse toProductResponse(Product product);

    java.util.List<ProductResponse> toProductResponseList(java.util.List<Product> products);
}
