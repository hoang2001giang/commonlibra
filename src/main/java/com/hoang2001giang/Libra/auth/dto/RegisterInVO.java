package com.hoang2001giang.Libra.auth.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class RegisterInVO {
    @NotEmpty
    @Size(min = 1, message = "First Name must have at least 1 characters")
    @Size(max = 25, message = "First Name must not be over 25 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 1, message = "Last Name must have at least 1 characters")
    @Size(max = 25, message = "Last Name must not be over 25 characters")
    private String lastName;

    @NotEmpty(message = "Email must not be empty")
    private String email;

    @NotEmpty(message = "Password must not be empty")
    @Size(min = 5, message = "Password must have at least 5 characters")
    @Size(max = 255, message = "Password must not be over 255 characters")
    private String password;
}
