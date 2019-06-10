package com.syun.spring5demo3.service.impl;

import com.syun.spring5demo3.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-07 18:56
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {



    @Override
    public void getUserInfo() {
        log.info(this.getClass() + ": get user info ");
    }

    @Override
    public void getUserPassword() {

    }


}
