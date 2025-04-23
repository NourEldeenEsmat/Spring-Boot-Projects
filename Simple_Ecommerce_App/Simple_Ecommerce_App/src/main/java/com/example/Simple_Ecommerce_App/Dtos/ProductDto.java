package com.example.Simple_Ecommerce_App.Dtos;

import com.example.Simple_Ecommerce_App.Entities.Product;
import lombok.Data;

@Data
public class ProductDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private int productStock;
    private Double productPrice;
    private boolean isReserved;
    private Long adminId;

    public Product toProduct() {
        Product product = new Product();
        product.setProductDescription(productDescription);
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setProductId(productId);
        product.setProductStock(productStock);
        product.setReserved(isReserved);
        return product;
    }
}
