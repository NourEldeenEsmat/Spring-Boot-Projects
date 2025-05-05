package com.example.Simple_Ecommerce_App.Repositries;

import com.example.Simple_Ecommerce_App.Entities.Product;
import com.example.Simple_Ecommerce_App.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
   List<Product> findAllByAdmin(User admin);

   List<Product> findAllByProductNameContainsAndProductPrice(String pName,Double price);

}
