package com.JPADemo.ProductCatalog.service;
import com.JPADemo.ProductCatalog.exception.ProductException;
import com.JPADemo.ProductCatalog.model.Product;
import com.JPADemo.ProductCatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product pro)
    {
        return productRepository.save(pro);
    }
    @Override
    public List<Product> getProduct()
    {
        return this.productRepository.findAll();
    }
    @Override
    public Product updateProduct(Product pro)
    {
        Optional<Product> proObj= this.productRepository.findById(pro.getProID());
        if(proObj.isPresent())
        {
            Product proUpdate= proObj.get();
            proUpdate.setProID(pro.getProID());
            proUpdate.setProName(pro.getProName());
            proUpdate.setProQuantity(pro.getProQuantity());
            return this.productRepository.save(proUpdate);
        }
        else{
            throw new ProductException("Product is not found for this specific id");
        }
    }
    @Override
    public Product getProductById(long proId)
    {
        Optional<Product> proObj= this.productRepository.findById(proId);
        if(proObj.isPresent())
        {
            return proObj.get();
        }
        else{
            throw new ProductException("PRodcut didn't found with ID:"+proId);
        }

    }
    @Override
    public void deleteProduct(long proId)
    {
        Optional<Product>proObj = this.productRepository.findById(proId);
        if(proObj.isPresent())
        {
            this.productRepository.deleteById(proId);
        }
        else{
            throw new ProductException("Product didn't found with ID: "+proId);
        }
    }
}
