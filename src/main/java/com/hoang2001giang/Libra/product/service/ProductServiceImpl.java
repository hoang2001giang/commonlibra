package com.hoang2001giang.Libra.product.service;

import com.hoang2001giang.Libra.category.data.Category;
import com.hoang2001giang.Libra.category.data.CategoryRepository;
import com.hoang2001giang.Libra.file.data.FileEntity;
import com.hoang2001giang.Libra.file.data.FileRepository;
import com.hoang2001giang.Libra.product.data.Product;
import com.hoang2001giang.Libra.product.data.ProductRepository;
import com.hoang2001giang.Libra.product.dto.CreateProductInVO;
import com.hoang2001giang.Libra.product.dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    FileRepository fileRepository;

    @Override
    public List<ProductDto> getAll() {
        return listEntityToListDto(productRepository.findAll());
    }

    @Override
    @Transactional
    public ProductDto create(CreateProductInVO vo) {
        Product createdProduct = new Product();
        BeanUtils.copyProperties(vo, createdProduct);

        Category category = categoryRepository.getByName(vo.getCategory()).orElseThrow();
        createdProduct.setCategory(category);

        List<FileEntity> files = fileRepository.findAllById(vo.getImages());
        createdProduct.setImages(files);

        productRepository.save(createdProduct);
        return entityToDto(createdProduct);
    }

    private ProductDto entityToDto(Product entity) {
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setCategory(entity.getCategory().getName());
        return dto;
    }

    private List<ProductDto> listEntityToListDto(List<Product> entities) {
        List<ProductDto> dtos = new ArrayList<>();
        for (Product entity: entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }
}
