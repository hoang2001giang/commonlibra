package com.hoang2001giang.Libra.category.controller;

import com.hoang2001giang.Libra.category.data.Category;
import com.hoang2001giang.Libra.category.data.CategoryRepository;
import com.hoang2001giang.Libra.category.dto.CategoryDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(listEntityToListDto(categoryRepository.findAll()), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getOneById(@PathVariable(name="id") String categoryId) {
//        return new ResponseEntity<>(
//                entityToDto(categoryRepository.findById(categoryId).orElseThrow()),
//                HttpStatus.OK);
//    }

    private CategoryDto entityToDto(Category entity) {
        CategoryDto dto = new CategoryDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private List<CategoryDto> listEntityToListDto(List<Category> entities) {
        List<CategoryDto> dtos = new ArrayList<>();
        for (Category entity: entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }
}
