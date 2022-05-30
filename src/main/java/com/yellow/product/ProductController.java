package com.yellow.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    
    @GetMapping("/detail/{productId}")
    public Optional<Product> getProductDetails(@PathVariable Long productId) {
        return productRepo.findById(productId);
    }
    
    
    @DeleteMapping("/remove/{productId}")
    public boolean removeProductDetail(@PathVariable Long productId) {
    	Optional<Product> product=this.getProductDetails(productId);
    	if(product.isPresent()){
        	productRepo.delete(product.get());
        	return true;
    	}else {    		
    		return false;
    	}
    }
}
