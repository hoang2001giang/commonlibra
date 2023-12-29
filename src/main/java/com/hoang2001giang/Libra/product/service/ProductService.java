package com.hoang2001giang.Libra.product.service;

import com.hoang2001giang.Libra.product.dto.CreateProductInVO;
import com.hoang2001giang.Libra.product.dto.GetProductInVO;
import com.hoang2001giang.Libra.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    ProductDto create(CreateProductInVO vo);
    ProductDto getOne(String id);
    ProductDto getOne(GetProductInVO vo);
}
