package com.JPADemo.ProductCatalog.service;

import com.JPADemo.ProductCatalog.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product pro);
    Product updateProduct(Product pro);
    List<Product> getProduct();
    Product getProductById(long proId);
    void deleteProduct(long proId);


}
