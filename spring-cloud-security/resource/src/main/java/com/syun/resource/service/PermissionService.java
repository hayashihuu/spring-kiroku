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

    /**
     * 用以匹配权限资源
     * @param request
     * @param authentication
     * @return
     */
    boolean hasPermissionService(HttpServletRequest request, Authentication authentication);

}
