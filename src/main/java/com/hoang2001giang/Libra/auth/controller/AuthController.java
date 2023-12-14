package com.hoang2001giang.Libra.auth.controller;

import com.hoang2001giang.Libra.auth.dto.LoginOutVO;
import com.hoang2001giang.Libra.auth.dto.RegisterInVO;
import com.hoang2001giang.Libra.auth.dto.UserDto;
import com.hoang2001giang.Libra.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private ResponseEntity<UserDto> register(@RequestBody @Valid RegisterInVO inVO) {
        return new ResponseEntity<>(userService.createUser(inVO), HttpStatus.CREATED);
    }
}
