package com.hoang2001giang.Libra.book.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CreateBookInVO {
    @NotEmpty(message = "Book Name must not be empty")
    @Size(min = 2, message = "Book Name must have at least 2 characters")
    @Size(max = 255, message = "Book Name must not be over 255 characters")
    private String name;
    private String description;
}
