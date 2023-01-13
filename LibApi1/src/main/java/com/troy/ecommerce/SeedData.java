package com.troy.ecommerce;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class SeedData {
    private ProductRepo productRepository;

    public SeedData(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

//    private List<Product> prod = Arrays.asList(
//            new Product(1, "Hot", "Tea", 20.0 ),
//            new Product(2,"Hot","Coffee",30.0),
//            new Product(3,"Cold","Sprite",40.0),
//            new Product(4,"Hot","Latte",50.0),
//            new Product(5,"Cold","Fruity",60.0),
//            new Product(6,"Cold","Pepsi",70.0),
//            new Product(1, "Hot", "Ginger Tea", 20.0 ),
//            new Product(2,"Hot","Herbal Tea",30.0),
//            new Product(3,"Cold","Green Tea",40.0),
//            new Product(4,"Hot","Latte",50.0),
//            new Product(5,"Cold","Fruity",60.0),
//            new Product(6,"Cold","Pepsi",70.0)
//            );

//    @PostConstruct
//    public void saveCustomers(){
//        productRepository.saveAll(prod);
//    }
}
