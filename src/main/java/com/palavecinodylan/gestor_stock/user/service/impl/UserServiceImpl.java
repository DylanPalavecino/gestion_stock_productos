package com.palavecinodylan.gestor_stock.user.service.impl;

import com.palavecinodylan.gestor_stock.user.request.SaveUser;
import com.palavecinodylan.gestor_stock.user.entity.UserEntity;
import com.palavecinodylan.gestor_stock.exception.InvalidPasswordException;
import com.palavecinodylan.gestor_stock.models.Role;
import com.palavecinodylan.gestor_stock.user.repository.UserRepository;
import com.palavecinodylan.gestor_stock.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
