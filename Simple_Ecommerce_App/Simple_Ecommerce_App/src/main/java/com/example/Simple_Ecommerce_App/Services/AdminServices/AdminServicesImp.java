package com.example.Simple_Ecommerce_App.Services.AdminServices;

import com.example.Simple_Ecommerce_App.Dtos.ProductDto;
import com.example.Simple_Ecommerce_App.Entities.Product;
import com.example.Simple_Ecommerce_App.Entities.User;
import com.example.Simple_Ecommerce_App.Repositries.ProductRepo;
import com.example.Simple_Ecommerce_App.Repositries.ReservationRepo;
import com.example.Simple_Ecommerce_App.Repositries.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminServicesImp implements AdminServices {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ReservationRepo reservationRepo;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Optional<User> admin = userRepo.findById(productDto.getAdminId());
        Product product = productDto.toProduct();
        product.setAdmin(admin.get());
        Product product1 = productRepo.save(product);
        return product1.toDto();
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public List<ProductDto> getAllProducts(Long adminId) {
        Optional<User> admin = userRepo.findById(adminId);
        List<Product> products = productRepo.findAllByAdmin(admin.get());
        return products.stream().map(Product::toDto).toList();
    }

    @Override
    public ProductDto viewProduct(Long productId) {
        Optional<Product> product = productRepo.findById(productId);
        return product.get().toDto();
    }
}
