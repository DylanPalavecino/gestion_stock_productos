package com.palavecinodylan.gestor_stock.user.service;

import com.palavecinodylan.gestor_stock.user.request.SaveUser;
import com.palavecinodylan.gestor_stock.user.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {



    Optional<UserEntity> findUserByUsername(String username);

}
