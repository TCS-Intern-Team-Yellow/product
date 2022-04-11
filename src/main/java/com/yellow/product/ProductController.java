package com.yellow.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @GetMapping("/details")
    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

}
