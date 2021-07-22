package com.cybertek.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// here different ways of creation headers :::
// equal controller = responsebody
@RestController
// we add requstnapping at class level so we do not use it in each api
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);


    //    @GetMapping(value = "/{id}")
//    public ResponseEntity<Product> getProduct(@PathVariable("id") long id){
//        return ResponseEntity.ok(productService.getProduct(id));
//    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") long id){
        return productService.getProduct(id);
    }



    // default is get so we do not need to add it

    @GetMapping
    public  List<Product> getProducts(){

     //   logger.info("Before -> Controller:{} - Method:{} - Input Parameter:{}", "ProductController ", "getProducts()");
        List<Product> list = productService.getProducts();
       // logger.info("After -> Controller:{} - Method:{} - Output Parameter:{}", "ProductController ", "getProducts()",list.toString());

        return list;
//        return list;
    }


    @DeleteMapping(value = "{id}")
    public  ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") Long id) {
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version","Cybertek.v1");
        responseHttpHeaders.set("Operation","Delete");
        List<Product> list =productService.delete(id);
        return new ResponseEntity<>(list,responseHttpHeaders,HttpStatus.OK);
    }

    //add product :
    @PostMapping
    // RequestBody) we need when we want post something
    public ResponseEntity<List<Product>> createProduct(@RequestBody Product product) {
        List<Product> set = productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version","Cyber")
                .header("Operation","create")
                .body(set);
    }

    //update product
    @PutMapping(value = "{id}")
    // RequestBody) we need when we want post something
    public ResponseEntity<List<Product>> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("Version","Cybertek.V1");
        map.add("Operation","Update");

        List<Product> list = productService.updateProduct(id,product);

        return new ResponseEntity <>(list,map,HttpStatus.OK);

    }
    //custom WrapperClass is used
    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts(){
        return ResponseEntity
                .ok(new ResponseWrapper("products successfully retrieved",productService.getProducts()));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseWrapper>deleteProduct2(@PathVariable("id") Long id){
        return ResponseEntity.ok(new ResponseWrapper("product is deleted ",productService.delete(id)));
    }

    // different option
    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct3(@PathVariable("id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper("product successfully deleted"));
    }

}



