package com.hoang2001giang.Libra.auth.controller;

import com.hoang2001giang.Libra.auth.dto.UserDto;
import com.hoang2001giang.Libra.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable(name="id") String userId) {
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

}
