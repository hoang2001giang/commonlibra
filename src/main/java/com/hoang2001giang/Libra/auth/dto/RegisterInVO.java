package com.hoang2001giang.Libra.auth.dto;

import lombok.Data;

@Data
public class RegisterInVO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
