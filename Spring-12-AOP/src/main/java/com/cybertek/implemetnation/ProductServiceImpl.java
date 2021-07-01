package com.cybertek.implemetnation;

import com.cybertek.entity.Product;
import com.cybertek.repository.ProductRepository;
import com.cybertek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> delete(long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @Override
    public List<Product> updateProduct(long id, Product product) {
        // we are using get because it returns Optional class
        Product obj = productRepository.findById(id).get();
        obj.setName(product.getName());
        productRepository.save(obj);
        return productRepository.findAll();
    }

    @Override
    public List<Product> createProduct(Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).get();
    }
}
