package com.palavecinodylan.gestor_stock.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserDTO {

    private Long id;
    private String username;
    private String name;
    private String role;
    private String jwt;



}

