package com.palavecinodylan.gestor_stock.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.palavecinodylan.gestor_stock.controller.request.SaveUser;
import com.palavecinodylan.gestor_stock.entity.UserEntity;
import com.palavecinodylan.gestor_stock.exception.InvalidPasswordException;
import com.palavecinodylan.gestor_stock.models.Role;
import com.palavecinodylan.gestor_stock.repository.UserRepository;
import com.palavecinodylan.gestor_stock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity registerOneEmployee(SaveUser newUser) {

        validatePassword(newUser);

        UserEntity user = new UserEntity();
        user.setUsername(newUser.getUsername());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setName(newUser.getName());
        user.setRole(Role.ROLE_EMPLOYEE);

        return userRepository.save(user);

    }

    @Override
    public Optional<UserEntity> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void validatePassword(SaveUser newUser) {

        if (!StringUtils.hasText(newUser.getPassword()) || !StringUtils.hasText(newUser.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }

        if (!newUser.getPassword().equals(newUser.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords don't match");
        }

    }


}
