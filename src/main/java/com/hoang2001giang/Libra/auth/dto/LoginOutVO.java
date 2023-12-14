package com.hoang2001giang.Libra.auth.dto;

import lombok.Data;

@Data
public class LoginOutVO {
    private String accessToken;
    private String tokenType = "Bearer";

    public LoginOutVO(String accessToken) {
        this.accessToken = accessToken;
    }
}
