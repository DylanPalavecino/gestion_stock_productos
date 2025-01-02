package com.palavecinodylan.gestor_stock.models;


import lombok.*;

import java.util.Arrays;
import java.util.List;
@Getter
@AllArgsConstructor
public enum Role {

    ROLE_ADMIN(Arrays.asList(
            RolePermission.CREATE_CUSTOMER,
            RolePermission.READ_CUSTOMER,
            RolePermission.READ_ALL_CUSTOMERS,
            RolePermission.UPDATE_CUSTOMER,
            RolePermission.DELETE_CUSTOMER,

            RolePermission.CREATE_PRODUCT,
            RolePermission.READ_PRODUCT,
            RolePermission.READ_ALL_PRODUCTS,
            RolePermission.UPDATE_PRODUCT,
            RolePermission.DELETE_PRODUCT,

            RolePermission.CREATE_INVOICE,
            RolePermission.READ_INVOICE,
            RolePermission.UPDATE_INVOICE,


            RolePermission.CREATE_ORDER,
            RolePermission.READ_ORDER,
            RolePermission.REMOVE_ITEM,
            RolePermission.DELETE_ORDER,
            RolePermission.ADD_ITEM,

            RolePermission.CREATE_USER


    )),
    ROLE_EMPLOYEE(Arrays.asList(
            RolePermission.CREATE_CUSTOMER,
            RolePermission.READ_CUSTOMER,
            RolePermission.READ_ALL_CUSTOMERS,
            RolePermission.UPDATE_CUSTOMER,

            RolePermission.READ_PRODUCT,
            RolePermission.READ_ALL_PRODUCTS,

            RolePermission.CREATE_INVOICE,
            RolePermission.READ_INVOICE,
            RolePermission.UPDATE_INVOICE,

            RolePermission.CREATE_ORDER,
            RolePermission.READ_ORDER,
            RolePermission.REMOVE_ITEM,
            RolePermission.ADD_ITEM

    ));

    private List<RolePermission> permissions;
}
