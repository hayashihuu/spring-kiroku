package com.syun.resource.service;

import com.syun.resource.fegin.IamFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-27 13:53
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired(required = false)
    private IamFeignService iamFeignService;


    private AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public boolean hasPermissionService(HttpServletRequest request, Authentication authentication) {

        System.out.println("request.getRequestURL(): " + request.getRequestURL());

        List<SimpleGrantedAuthority> grantedAuthorities = (List<SimpleGrantedAuthority>) authentication.getAuthorities();

        boolean hasPremission = false;


        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.getName());

        List<String> urls = null;
//        iamFeignService.getUserPermissionByUsername("hayashihuu");

        String requestUrl = request.getRequestURL().toString();

//        for (String url : urls) {
//            System.out.println(url);
//            if (url.equals(requestUrl)) {
//                hasPremission = true;
//                break;
//            }
//        }

//        for (SimpleGrantedAuthority grantedAuthority : grantedAuthorities) {
//            System.out.println(grantedAuthority.toString());
//            if("ROLE_syun".equals(grantedAuthority.toString())){
//                hasPremission = true;
//                break;
//            }
//            if(antPathMatcher.match("http://localhost:9070/test/test", request.getRequestURL().toString())){
//                hasPremission = true;
//                break;
//            }
//        }


        if(authentication.getPrincipal().equals("syun")&&authentication.getName().equals("syun")){
            return true;
        }

        return false;

    }
}
