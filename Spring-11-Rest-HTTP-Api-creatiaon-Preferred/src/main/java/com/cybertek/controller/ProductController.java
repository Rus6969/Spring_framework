package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// equal controller = responsebody
@RestController
// we add requstnapping at class level so we do not use it in each api
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // / creating an endpoint
    @GetMapping(value = "{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    // default is get so we do not need to add it
    @GetMapping
    public List<Product> findAllProducts() {
        return productService.getProducts();
    }

    @DeleteMapping(value = "{id}")
    public List<Product> deleteProduct(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

//    //add product :
//    @PostMapping
//    // RequestBody) we need when we want post something
//    public List<Product> creatProduct(@RequestBody Product product) {
//        return productService.ceateProduct(product);
//    }

    //update product
    @PutMapping(value = "{id}")
    // RequestBody) we need when we want post something
    public List<Product> Updateroduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.createProduct(product);
    }

}



