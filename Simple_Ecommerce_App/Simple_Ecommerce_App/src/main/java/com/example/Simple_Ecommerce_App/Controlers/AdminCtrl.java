package com.example.Simple_Ecommerce_App.Controlers;

import com.example.Simple_Ecommerce_App.Dtos.ProductDto;
import com.example.Simple_Ecommerce_App.Services.AdminServices.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminCtrl {
    @Autowired
    private AdminServices adminServices;
    @PostMapping("/create_product")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto){
        try {
            ProductDto dto = adminServices.createProduct(productDto);
            return ResponseEntity.ok(dto);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_all_products/{productId}")
    public ResponseEntity<?> getAllProducts(@PathVariable Long productId){
        try {
            List<ProductDto> allProducts = adminServices.getAllProducts(productId);
            return ResponseEntity.ok(allProducts);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update_product")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto dto){
        try {
            ProductDto productDto = adminServices.createProduct(dto);
            return ResponseEntity.ok(productDto);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete_product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
        try {
            adminServices.deleteProduct(productId);
            return ResponseEntity.ok("deleted");
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/view_product/{productId}")
    public ResponseEntity<?> viewProduct(@PathVariable Long productId){
//        try{
            ProductDto productDto = adminServices.viewProduct(productId);
            return ResponseEntity.ok(productDto);
//        }catch (RuntimeException e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
    }

}
