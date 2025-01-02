package com.palavecinodylan.gestor_stock.controller;

import com.palavecinodylan.gestor_stock.controller.request.AuthRequest;
import com.palavecinodylan.gestor_stock.dto.AuthDTO;
import com.palavecinodylan.gestor_stock.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
