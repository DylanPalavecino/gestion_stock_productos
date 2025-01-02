package com.palavecinodylan.gestor_stock.config.security;

import com.palavecinodylan.gestor_stock.config.security.filter.JwtAuthenticationFilter;
import com.palavecinodylan.gestor_stock.models.RolePermission;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    @Autowired
    private AuthenticationProvider daoAuthenticationProvider;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessConfig -> sessConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(daoAuthenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(HttpSecurityConfig::buildRequestMatchers)


                .build();

    }



    private static void buildRequestMatchers(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        /* PRODUCTS AUTHORIZATIONS */
        authReqConfig.requestMatchers(HttpMethod.GET, "/api/product/")
                .hasAuthority(RolePermission.READ_ALL_PRODUCTS.name());
        authReqConfig.requestMatchers(HttpMethod.GET, "/api/product/{id}")
                .hasAuthority(RolePermission.READ_PRODUCT.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/api/product/add")
                .hasAuthority(RolePermission.CREATE_PRODUCT.name());
        authReqConfig.requestMatchers(HttpMethod.DELETE, "/api/product/delete/{id}")
                .hasAuthority(RolePermission.DELETE_PRODUCT.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/api/product/update/{id}")
                .hasAuthority(RolePermission.UPDATE_PRODUCT.name());

        /* ORDER ITEMS AUTHORIZATIONS */
        authReqConfig.requestMatchers(HttpMethod.POST, "/api/item/add")
                .hasAuthority(RolePermission.ADD_ITEM.name());
        authReqConfig.requestMatchers(HttpMethod.GET, "/api/item/get/{id}")
                .hasAuthority(RolePermission.READ_ITEM.name());

        /* ORDERS AUTHORIZATIONS */
        authReqConfig.requestMatchers(HttpMethod.GET, "/api/order/{id}")
                .hasAuthority(RolePermission.READ_ORDER.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/api/order/empty-order")
                .hasAuthority(RolePermission.CREATE_ORDER.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/api/order/remove-item/{orderId}/{itemId}")
                .hasAuthority(RolePermission.REMOVE_ITEM.name());

        /* CUSTOMERS AUTHORIZATIONS */
        authReqConfig.requestMatchers(HttpMethod.GET, "/api/customer/")
                .hasAuthority(RolePermission.READ_ALL_CUSTOMERS.name());
        authReqConfig.requestMatchers(HttpMethod.GET, "/api/customer/{id}")
                .hasAuthority(RolePermission.READ_CUSTOMER.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/api/customer/create")
                .hasAuthority(RolePermission.CREATE_CUSTOMER.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/api/customer/update/{id}")
                .hasAuthority(RolePermission.UPDATE_CUSTOMER.name());
        authReqConfig.requestMatchers(HttpMethod.DELETE, "/api/customer/delete/{id}")
                .hasAuthority(RolePermission.DELETE_CUSTOMER.name());

        /* INVOICE AUTHORIZATIONS */
        authReqConfig.requestMatchers(HttpMethod.GET, "/api/invoice/{id}")
                .hasAuthority(RolePermission.READ_INVOICE.name());
        authReqConfig.requestMatchers(HttpMethod.POST, "/api/invoice/generate")
                .hasAuthority(RolePermission.CREATE_INVOICE.name());

        authReqConfig.requestMatchers(HttpMethod.POST,"/api/employee/register").permitAll();
        authReqConfig.requestMatchers(HttpMethod.POST, "/api/auth/authenticate").permitAll();
        authReqConfig.requestMatchers(HttpMethod.GET, "/api/auth/validate-token").permitAll();
        authReqConfig.requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**").permitAll();
        authReqConfig.anyRequest().authenticated();

    }


}
