package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
    //here we changed return type bc line 44 returns Response entity not a list
    public ResponseEntity<List<Product>> findAllProducts() {
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version","Cybertek.v1");
        responseHttpHeaders.set("Operation","Get List");
       /* when we use response entity we need provide 3 things response body , status and header:
         .ok means 200
        */
        return ResponseEntity
                .ok()
                .headers(responseHttpHeaders)
                .body(productService.getProducts());
    }




    @DeleteMapping(value = "{id}")
    public List<Product> deleteProduct(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    //add product :
    @PostMapping
    // RequestBody) we need when we want post something
    public List<Product> creatProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    //update product
    @PutMapping(value = "{id}")
    // RequestBody) we need when we want post something
    public List<Product> Updateroduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.createProduct(product);
    }

}



