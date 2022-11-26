package com.JPADemo.ProductCatalog.controller;
import com.JPADemo.ProductCatalog.model.Product;
import com.JPADemo.ProductCatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    private ResponseEntity<List<Product>> getAllProducts()
    {
        return ResponseEntity.ok().body(this.productService.getProduct());
    }
    @GetMapping("/product/{prodId}")
    private Product getProductById(@PathVariable long prodId)
    {
        return this.productService.getProductById(prodId);
    }
    @PostMapping("/product")
    private ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        return ResponseEntity.ok().body(this.productService.createProduct(product));

    }
}
