package com.example.demo.service;

import com.example.demo.dto.request.ProductCreationRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;

    public List<ProductResponse> createProducts(List<ProductCreationRequest> requests) {
        if (requests == null || requests.isEmpty()) {
            return Collections.emptyList();
        }
        List<Product> products = requests.stream()
                .map(productMapper::toProduct)
                .collect(Collectors.toList());

        List<Product> savedProducts = productRepository.saveAll(products);
        return productMapper.toProductResponseList(savedProducts);
    }


    public List<ProductResponse> getAllProducts() {
        return productMapper.toProductResponseList(productRepository.findAll());
    }

    public ProductResponse getProductById(String id) {
        return productMapper.toProductResponse(productRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với id: " + id)));
    }

    public void deleteProductById(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Không tìm thấy sản phẩm với id: " + id);
        }
    }

    public ProductResponse updateProduct(String id, ProductCreationRequest request) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với id: " + id));
        if (product != null) {
            productMapper.updateProductFromRequest(request, product);
            Product updated = productRepository.save(product);
            return productMapper.toProductResponse(updated);
        } else {
            throw new RuntimeException("Không tìm thấy sản phẩm với id: " + id);
        }
    }

    // delete all products
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
