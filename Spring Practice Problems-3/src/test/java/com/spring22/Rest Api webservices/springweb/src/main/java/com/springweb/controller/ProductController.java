package com.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springweb.entity.Product;
import com.springweb.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService p;

    @GetMapping("/product")
    public List<Product> getAllProduct() {
        return p.findAllProduct();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = p.getProduct(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product pe) {
        p.InsertProduct(pe);
        return ResponseEntity.ok(pe);
    }

    @PutMapping("/product/{id}")
    public void update(@PathVariable int id, @RequestBody Product pe) {
        p.UpdateProduct(id, pe);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable int id) {
        p.deleteById(id);
    }
}
