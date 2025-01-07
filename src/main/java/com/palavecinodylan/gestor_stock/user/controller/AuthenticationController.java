package com.palavecinodylan.gestor_stock.user.controller;

import com.palavecinodylan.gestor_stock.user.request.AuthRequest;
import com.palavecinodylan.gestor_stock.user.dto.AuthDTO;
import com.palavecinodylan.gestor_stock.user.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/validate-token")
    public ResponseEntity<Boolean> validate(@RequestParam String jwt){

        boolean isValid = authenticationService.validate(jwt);
        return ResponseEntity.ok(isValid);

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthDTO> authenticate(@RequestBody @Valid AuthRequest authRequest) {

        AuthDTO response = authenticationService.login(authRequest);
        return ResponseEntity.ok(response);

    }



}
