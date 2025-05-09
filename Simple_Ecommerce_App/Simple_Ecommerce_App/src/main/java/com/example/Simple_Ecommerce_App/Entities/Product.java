package com.example.Simple_Ecommerce_App.Entities;

import com.example.Simple_Ecommerce_App.Dtos.ProductDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productDescription;
    private int productStock;
    private Double productPrice;

    @ManyToOne
    @JoinColumn
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User admin;
    public ProductDto toDto(){
        ProductDto productDto = new ProductDto();
        productDto.setProductDescription(productDescription);
        productDto.setProductName(productName);
        productDto.setProductPrice(productPrice);
        productDto.setProductId(productId);
        productDto.setProductStock(productStock);
        productDto.setAdmin(admin);
        return productDto;
    }
}
