package com.palavecinodylan.gestor_stock.user.auth;

import com.palavecinodylan.gestor_stock.user.request.AuthRequest;
import com.palavecinodylan.gestor_stock.user.request.SaveUser;
import com.palavecinodylan.gestor_stock.user.dto.AuthDTO;
import com.palavecinodylan.gestor_stock.user.dto.UserDTO;
import com.palavecinodylan.gestor_stock.user.entity.UserEntity;
import com.palavecinodylan.gestor_stock.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final UserService userService;
    private final JwtService jwtService;

    public UserDTO registerEmployee(SaveUser newUser) {

        UserEntity user = userService.registerOneEmployee(newUser);
        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .role(user.getRole().name())
                .jwt(jwt)
                .build();


    }

    private Map<String, Object> generateExtraClaims(UserEntity user) {

        Map<String, Object> extraClamis = new HashMap<>();
        extraClamis.put("name", user.getName());
        extraClamis.put("role", user.getRole().name());
        extraClamis.put("authorities", user.getAuthorities());

        return extraClamis;

    }

    public AuthDTO login(AuthRequest authRequest) {

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),
                authRequest.getPassword()
        );
        authenticationManager.authenticate(authentication);

        UserDetails user = userService.findUserByUsername(authRequest.getUsername()).get();

        String jwt = jwtService.generateToken(user, generateExtraClaims((UserEntity) user));

        AuthDTO authDTO = new AuthDTO();
        authDTO.setJwt(jwt);

        return authDTO;

    }


    public boolean validate(String jwt) {

        try {
            jwtService.extractUsername(jwt);
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
