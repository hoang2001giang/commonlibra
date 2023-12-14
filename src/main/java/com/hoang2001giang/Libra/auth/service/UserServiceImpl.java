package com.hoang2001giang.Libra.auth.service;

import com.hoang2001giang.Libra.auth.data.Role;
import com.hoang2001giang.Libra.auth.data.RoleRepository;
import com.hoang2001giang.Libra.auth.data.User;
import com.hoang2001giang.Libra.auth.data.UserRepository;
import com.hoang2001giang.Libra.auth.dto.RegisterInVO;
import com.hoang2001giang.Libra.auth.dto.UserDto;
import com.hoang2001giang.Libra.auth.security.UserDetailsImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto getUser(String userId) {
        return entityToDto(userRepository.findById(userId).orElseThrow());
    }

    @Override
    public UserDto createUser(RegisterInVO inVO) {
//        createRoleIfNotFound("ROLE_ADMIN");
//        createRoleIfNotFound("ROLE_USER");

        User createdUser = new User();
        BeanUtils.copyProperties(inVO, createdUser);
        createdUser.setPassword(passwordEncoder.encode(inVO.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        createdUser.setRoles(Arrays.asList(userRole));
        createdUser = userRepository.save(createdUser);
        return entityToDto(createdUser);
    }

    private UserDto entityToDto(User entity) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity, dto);
        List<String> roles = new ArrayList<>();
        for (Role role : entity.getRoles()) {
            roles.add(role.getName());
        }
        dto.setRoles(roles);
        return dto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsImpl(user);
    }

    public UserDetails loadUserById(String userId) throws UsernameNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user id: " + userId));
        return new UserDetailsImpl(user);
    }

    @Transactional
    Role createRoleIfNotFound(String name) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}
