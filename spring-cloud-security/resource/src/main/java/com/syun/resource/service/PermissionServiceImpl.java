package com.syun.resource.service;

import com.syun.auth.domain.dto.IamRoleDTO;
import com.syun.auth.domain.dto.IamUserDTO;
import com.syun.auth.model.IamPermission;
import com.syun.resource.fegin.IamFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-27 13:53
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    private final IamFeignService iamFeignService;


    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public PermissionServiceImpl(IamFeignService iamFeignService) {
        this.iamFeignService = iamFeignService;
    }


    @Override
    public boolean hasPermissionService(HttpServletRequest request, Authentication authentication) {

        System.out.println("request.getRequestURL(): " + request.getRequestURL());

        List<SimpleGrantedAuthority> grantedAuthorities = (List<SimpleGrantedAuthority>) authentication.getAuthorities();

        boolean hasPremission = false;
//      获取用户所有的可访问资源
        Set<IamPermission> permissions = Optional.ofNullable(iamFeignService.getUserByUsername(authentication.getPrincipal().toString()))
                .map(HttpEntity::getBody)
                .map(IamUserDTO::getRoles)
                .filter(p -> !p.isEmpty())
                .orElse(Collections.emptySet())
                .stream()
                .map(IamRoleDTO::getPermissions)
                .reduce((p, q) -> {
                    q.addAll(p);
                    return q;
                }).orElse(null);

//        请求的 url
        String requestUrl = request.getRequestURL().toString();
//       检测是否拥有权限
        hasPremission = Optional.ofNullable(permissions)
                .orElse(Collections.emptySet())
                .stream()
                .anyMatch(p -> requestUrl.endsWith(p.getUrl()));
 
        return hasPremission;

    }
}
