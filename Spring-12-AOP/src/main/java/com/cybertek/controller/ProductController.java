package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;
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


    @GetMapping(value = "{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
      // here example where we do not want  pass headers instead directly pass a boddy
        return ResponseEntity.ok(productService.getProduct(id));
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



