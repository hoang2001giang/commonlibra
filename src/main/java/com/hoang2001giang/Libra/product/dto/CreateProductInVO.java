package com.hoang2001giang.Libra.product.dto;

import com.hoang2001giang.Libra.product.data.Product;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class CreateProductInVO {
    private String slug;
    @NotBlank(message = "Product Name is required")
    private String name;
    @NotBlank(message = "Product Code is required")
    private String code;
    private String colorCodes;
    private int price;
    private String discount;
    private String sellingPrice;
    private String description;
    private String thumbnail;
    private List<String> images;
    private String category;
    private String status;
    private String note;

}
