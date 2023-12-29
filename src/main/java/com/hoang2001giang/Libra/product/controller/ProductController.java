package com.hoang2001giang.Libra.product.controller;

import com.hoang2001giang.Libra.product.dto.CreateProductInVO;
import com.hoang2001giang.Libra.product.dto.GetProductInVO;
import com.hoang2001giang.Libra.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<Object> createProduct(@RequestBody @Valid CreateProductInVO vo) {
        return new ResponseEntity<>(productService.create(vo), HttpStatus.CREATED);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getOneProduct(@PathVariable(name="id") String productId) {
//        return new ResponseEntity<>(productService.getOne(productId), HttpStatus.OK);
//    }

    @GetMapping("/{slug}")
    public ResponseEntity<Object> getOneProductWithSlugAndCategory(@PathVariable(name="slug") String slug,
                                                @RequestParam(name="category") String category) {
        GetProductInVO vo = new GetProductInVO(slug, category);
        return new ResponseEntity<>(productService.getOne(vo), HttpStatus.OK);
    }
}
