package com.example.Simple_Ecommerce_App.Services.AdminServices;

import com.example.Simple_Ecommerce_App.Dtos.ProductDto;
import com.example.Simple_Ecommerce_App.Entities.Product;
import com.example.Simple_Ecommerce_App.Entities.User;
import com.example.Simple_Ecommerce_App.Errors.RecordNotFoundException;
import com.example.Simple_Ecommerce_App.Repositries.ProductRepo;
import com.example.Simple_Ecommerce_App.Services.AuthServices.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminServicesImp implements AdminServices {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    AuthServices authServices;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product1 = productRepo.save(productDto.toProduct());
        return product1.toDto();
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public List<ProductDto> getAllProducts(Long adminId) {
        User admin = authServices.getUserById(adminId).toUser();
        List<Product> products = productRepo.findAllByAdmin(admin);
        return products.stream().map(Product::toDto).toList();
    }

    @Override
    public ProductDto viewProduct(Long productId) {
        Optional<Product> product = productRepo.findById(productId);
        if(product.isPresent()){
            return product.get().toDto();
        }else {
            throw new RecordNotFoundException("not found");
        }
    }

    @Override
    public List<ProductDto> searchProduct(String pName, Double price) {
        return productRepo.findAllByProductNameContainsAndProductPrice(pName,price)
                .stream().map(Product::toDto).toList();
    }
}
