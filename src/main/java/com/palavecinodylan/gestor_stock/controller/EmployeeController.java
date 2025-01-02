package com.palavecinodylan.gestor_stock.controller;

import com.palavecinodylan.gestor_stock.controller.request.SaveUser;
import com.palavecinodylan.gestor_stock.dto.UserDTO;
import com.palavecinodylan.gestor_stock.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/employee")
@RestController
public class EmployeeController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerEmployee(@RequestBody @Valid SaveUser newUser) {

        UserDTO userDTO = authenticationService.registerEmployee(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);

    }

}
