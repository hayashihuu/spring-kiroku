package com.syun.pro06.processor;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-04-10 21:59
 */
public class InitSequenceBean implements InitializingBean {

    public InitSequenceBean() {
        System.out.println("InitSequenceBean: constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("InitSequenceBean: postConstruct");
    }

    public void initMethod() {
        System.out.println("InitSequenceBean: init-method");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitSequenceBean: afterPropertiesSet");
    }


}
