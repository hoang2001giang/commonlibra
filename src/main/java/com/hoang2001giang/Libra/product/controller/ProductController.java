package com.hoang2001giang.Libra.product.controller;

import com.hoang2001giang.Libra.product.dto.CreateProductInVO;
import com.hoang2001giang.Libra.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> createProduct(@RequestBody CreateProductInVO vo) {
        return new ResponseEntity<>(productService.create(vo), HttpStatus.CREATED);
    }
}
