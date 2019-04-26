package com.syun.auth.service;

import com.syun.auth.domain.dto.IamRoleDTO;
import com.syun.auth.domain.dto.IamUserDTO;
import com.syun.auth.model.UserDO;
import com.syun.auth.model.UserK;
import com.syun.auth.feign.IamFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-16 19:11
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IamFeignService iamFeignService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

//        loadUserByPassword(s);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        System.out.println(request.getHeaderNames());

        IamUserDTO userDTO = new IamUserDTO();


        Set<SimpleGrantedAuthority> grantedAuthorities =
                Optional.ofNullable(loadUserByPassword(s))
                        .map(p -> {
                                    if (p == null) {
                                        throw new UsernameNotFoundException("username not fount");
                                    }
                                    userDTO.setUsername(p.getUsername());
                                    userDTO.setPassword(p.getPassword());
                                    userDTO.setRoles(p.getRoles());
                                    return p.getRoles()
                                            .stream()
                                            .map(IamRoleDTO::getName)
                                            .map(SimpleGrantedAuthority::new)
                                            .collect(Collectors.toSet());
                                }
                        ).orElse(null);

        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定

        return new User(userDTO.getUsername(), userDTO.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
    }


    private IamUserDTO loadUserByPassword(String username) {
        return Optional.ofNullable(iamFeignService.getUserByUsername(username))
                .map(HttpEntity::getBody)
                .orElse(null);
    }
}
