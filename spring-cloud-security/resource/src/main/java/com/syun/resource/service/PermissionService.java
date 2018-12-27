package com.syun.resource.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-27 13:52
 */
public interface PermissionService {

    boolean hasPermissionService(HttpServletRequest request, Authentication authentication);

}
