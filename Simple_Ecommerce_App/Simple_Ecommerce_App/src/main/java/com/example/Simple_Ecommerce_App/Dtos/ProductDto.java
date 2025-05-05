package com.example.Simple_Ecommerce_App.Dtos;

import com.example.Simple_Ecommerce_App.Entities.Product;
import com.example.Simple_Ecommerce_App.Entities.Reservation;
import com.example.Simple_Ecommerce_App.Entities.User;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private int productStock;
    private Double productPrice;
    private User admin;

    public Product toProduct() {
        Product product = new Product();
        product.setProductDescription(productDescription);
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setProductId(productId);
        product.setProductStock(productStock);
        product.setAdmin(admin);
        return product;
    }
}
