package com.syun.auth.provider;

import com.syun.auth.BaseAuthenticationToken;
import com.syun.auth.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-22 17:00
 */
@Component
@Slf4j
public class BasicUserDetailServiceProvider implements AuthenticationProvider {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        User user = (User) userDetailsService.loadUserByUsername((String) authentication.getPrincipal());
        String pw = (String) authentication.getCredentials();
        BaseAuthenticationToken authenticationTokenResult = new BaseAuthenticationToken(user.getAuthorities(), user.getUsername());

        if (!new BCryptPasswordEncoder().matches(pw, user.getPassword())) {
            log.info("密码错误，username: {}", authentication.getPrincipal());
            try {
                throw new Exception("密码或用户名错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            authenticationTokenResult.setDetails(authentication.getDetails());
            authenticationTokenResult.setAuthenticated(false);
        }

//        authenticationTokenResult.setAuthenticated(true);

        return authenticationTokenResult;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return BaseAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
