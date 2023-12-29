package com.hoang2001giang.Libra.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductInVO {
    private String slug;
    private String category;
}
