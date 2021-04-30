package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    // / creating an endpoint
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    // default is get so we do not need to add it
    @RequestMapping(value = "/products")
    public @ResponseBody
    List<Product> findAllProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    List<Product> deleteProduct(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    //add product :
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    // RequestBody) we need when we want post something
    public @ResponseBody
    List<Product> creatProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    //update product
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    // RequestBody) we need when we want post something
    public @ResponseBody
    List<Product> Updateroduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.createProduct(product);
    }

}



