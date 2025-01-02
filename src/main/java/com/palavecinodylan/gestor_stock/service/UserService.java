package com.palavecinodylan.gestor_stock.service;

import com.palavecinodylan.gestor_stock.controller.request.SaveUser;
import com.palavecinodylan.gestor_stock.dto.UserDTO;
import com.palavecinodylan.gestor_stock.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {


    UserEntity registerOneEmployee(SaveUser newUser);
    Optional<UserEntity> findUserByUsername(String username);

}
