package com.hoang2001giang.Libra.auth.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class LoginInVO {
    @NotEmpty(message = "Email must not be empty")
    private String email;
    @NotEmpty(message = "Password must not be empty")
    @Size(min = 5, message = "Password must have at least 5 characters")
    @Size(max = 255, message = "Password must not be over 255 characters")
    private String password;
}
