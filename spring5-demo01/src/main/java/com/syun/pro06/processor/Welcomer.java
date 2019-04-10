package com.syun.pro06.processor;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-04-10 21:16
 */
@Slf4j
@ToString
public class Welcomer {

    @Setter
    @Getter
    private String welcomeText;

    public void initWelcomer(){
        log.info("welcome is initialized");
    }




}
