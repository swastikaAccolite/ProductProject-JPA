package com.JPADemo.ProductCatalog.repository;

import com.JPADemo.ProductCatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {



}
