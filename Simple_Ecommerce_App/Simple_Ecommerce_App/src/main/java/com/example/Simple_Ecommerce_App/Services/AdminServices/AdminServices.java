package com.example.Simple_Ecommerce_App.Services.AdminServices;

import com.example.Simple_Ecommerce_App.Dtos.ProductDto;

import java.util.List;

public interface AdminServices {
    ProductDto createProduct(ProductDto productDto);
    void deleteProduct(Long productId);
    List<ProductDto> getAllProducts(Long adminId);
    ProductDto viewProduct(Long productId);

    List<ProductDto> searchProduct(String pName,Double price);
}
