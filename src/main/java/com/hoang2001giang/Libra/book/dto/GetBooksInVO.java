package com.hoang2001giang.Libra.book.dto;

import lombok.Data;

@Data
public class GetBooksInVO {
    private String id;
    private String userId;
    private String name;
    private String description;
}
