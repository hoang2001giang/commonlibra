package com.hoang2001giang.Libra.category.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CategoryDto {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
}
