package com.troy.ecommerce;

import com.troy.ecommerce.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4200/create-employee"} )
public interface ProductRepo extends JpaRepository<Product,Integer> {
}