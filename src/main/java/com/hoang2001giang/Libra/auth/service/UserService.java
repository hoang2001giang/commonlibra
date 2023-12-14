package com.hoang2001giang.Libra.auth.service;

import com.hoang2001giang.Libra.auth.dto.RegisterInVO;
import com.hoang2001giang.Libra.auth.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    UserDto getUser(String userId);
    UserDto createUser(RegisterInVO inVO);
    UserDetails loadUserById(String userId) throws UsernameNotFoundException;
}
