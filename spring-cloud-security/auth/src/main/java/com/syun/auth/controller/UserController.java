package com.syun.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * <p>必须要有，做验证</p>
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:10:43
 * ProjectName:Mirco-Service-Skeleton
 */
@RestController
public class UserController {
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @PostMapping("/testPost")
    public String test(HttpServletRequest request) {
        System.out.println(request.getHeaderNames());
        return "testPost";
    }
}
