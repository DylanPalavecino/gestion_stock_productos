package com.palavecinodylan.gestor_stock.user.entity;

import com.palavecinodylan.gestor_stock.models.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;


}
