package com.hoang2001giang.Libra.book.dto;

import lombok.Data;

@Data
public class CreateBookInVO {
    private String userId;
    private String name;
    private String description;
}
