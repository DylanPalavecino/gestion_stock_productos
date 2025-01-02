package com.palavecinodylan.gestor_stock.controller.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SaveUser {

    private String username;
    private String name;
    private String password;
    private String repeatedPassword;

}
