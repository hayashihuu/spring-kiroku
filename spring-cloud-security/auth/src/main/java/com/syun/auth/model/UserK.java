package com.syun.auth.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.security.Permission;
import java.util.Set;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-16 19:18
 */
@Data
public class UserK {

    private Long id;

    private String username;

    private String password;

    private Set<GrantedAuthority> authorities;

    private Set<Permission> permissions;






}
