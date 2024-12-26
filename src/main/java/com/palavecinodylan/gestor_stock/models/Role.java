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
            RolePermission.READ_ALL_INVOICES,
            RolePermission.UPDATE_INVOICE,
            RolePermission.DELETE_INVOICE,

            RolePermission.CREATE_ORDER,
            RolePermission.READ_ORDER,
            RolePermission.READ_ALL_ORDERS,
            RolePermission.UPDATE_ORDER

    )),
    ROLE_EMPLOYEE(Arrays.asList(
            RolePermission.CREATE_CUSTOMER,
            RolePermission.READ_CUSTOMER,
            RolePermission.READ_ALL_CUSTOMERS,
            RolePermission.UPDATE_CUSTOMER,

            RolePermission.READ_PRODUCT,
            RolePermission.READ_ALL_PRODUCTS,
            RolePermission.UPDATE_PRODUCT,

            RolePermission.CREATE_INVOICE,
            RolePermission.READ_INVOICE,
            RolePermission.UPDATE_INVOICE,

            RolePermission.CREATE_ORDER,
            RolePermission.READ_ORDER,
            RolePermission.UPDATE_ORDER

    ));

    private List<RolePermission> permissions;
}
