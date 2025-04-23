package com.example.Simple_Ecommerce_App.Entities;

import com.example.Simple_Ecommerce_App.Dtos.ProductDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    private boolean isReserved;
    @ManyToOne
    @JoinColumn(name = "adminId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User admin;
    public ProductDto toDto(){
        ProductDto productDto = new ProductDto();
        productDto.setProductDescription(productDescription);
        productDto.setProductName(productName);
        productDto.setProductPrice(productPrice);
        productDto.setProductId(productId);
        productDto.setProductStock(productStock);
        productDto.setAdminId(admin.getUserId());
        productDto.setReserved(isReserved);
        return productDto;
    }
}
