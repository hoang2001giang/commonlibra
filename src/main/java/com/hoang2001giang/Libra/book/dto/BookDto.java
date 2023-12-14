package com.hoang2001giang.Libra.book.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class BookDto {
    private String id;
    private String userId;
    private String name;
    private String description;
}
