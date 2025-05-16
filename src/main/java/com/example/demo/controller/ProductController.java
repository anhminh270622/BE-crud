package com.example.demo.controller;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.ProductCreationRequest;
import com.example.demo.dto.response.ProductResponse;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    ApiResponse<ProductResponse> addProduct(@RequestBody @Valid ProductCreationRequest request) {
        ApiResponse<ProductResponse> response = new ApiResponse<>();
        ProductResponse product = productService.createProduct(request);
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(product);
        return response;
    }

    @GetMapping()
    ApiResponse<List<ProductResponse>> getAllProducts() {
        ApiResponse<List<ProductResponse>> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(productService.getAllProducts());
        response.setTotalRecords(
                productService.getAllProducts().size()
        );
        return response;
    }

    @GetMapping("/{id}")
    ApiResponse<ProductResponse> getProductById(@PathVariable String id) {
        ApiResponse<ProductResponse> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(productService.getProductById(id));
        response.setTotalRecords(
                productService.getProductById(id) != null ? 1 : 0
        );
        return response;
    }

    @PutMapping("/{id}")
    ApiResponse<ProductResponse> updateProduct(@PathVariable String id, @RequestBody ProductCreationRequest request) {
        ApiResponse<ProductResponse> response = new ApiResponse<>();
        ProductResponse product = productService.updateProduct(id, request);
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(product);
        return response;
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteProductById(@PathVariable String id) {
        ApiResponse<Void> response = new ApiResponse<>();
        productService.deleteProductById(id);
        response.setCode(200);
        response.setMessage("Success");
        return response;
    }
}
