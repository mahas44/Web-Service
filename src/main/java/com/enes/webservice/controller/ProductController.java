package com.enes.webservice.controller;

import com.enes.webservice.model.Product;
import com.enes.webservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/", produces = "application/json; charset=utf-8")
    public String getHealthCheck(){
        return "{ \"isWorking\" : true }";
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable int id){
        Optional<Product> product = productRepository.findById(id);
        return  product;
    }
}
