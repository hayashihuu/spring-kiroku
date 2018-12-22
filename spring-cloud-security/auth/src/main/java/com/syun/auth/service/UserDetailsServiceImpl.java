package com.syun.auth.service;

import com.syun.auth.model.UserK;
import javafx.beans.property.SimpleSetProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-16 19:11
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        System.out.println(request.getHeaderNames());
        Enumeration<String> iterable = request.getHeaderNames();
        System.out.println("headers:");
        while (iterable.hasMoreElements()) {
            String temp = iterable.nextElement();
            System.out.println(temp + ":  " + request.getHeader(temp));

        }

        System.out.println("params: ");
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String temp = params.nextElement();
            System.out.println(temp + ":  " + request.getParameter(temp));
        }

        HttpServletResponse response = requestAttributes.getResponse();


        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定

        UserK userK = new UserK();
        userK.setUsername("syun");
        if (!s.equals(userK.getUsername())) {
            try {
                throw new Exception("无此用户");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + "");
        Set<GrantedAuthority> set = new HashSet<>();
        set.add(grantedAuthority);
        userK.setAuthorities(set);
        userK.setPassword(new BCryptPasswordEncoder().encode("syun"));
        User user = new User(userK.getUsername(), userK.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, set);
        return user;
    }
}
