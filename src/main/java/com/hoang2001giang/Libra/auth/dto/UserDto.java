package com.hoang2001giang.Libra.auth.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;
}
