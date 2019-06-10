package com.syun.spring5demo3.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-07 09:37
 */
@Configuration
@Import({CustomSelector.class,CustomRegister.class})
public class BeanCtreateConfiguration {


    @Bean("list")
    public ArrayList getArrayList() {
        ArrayList list = new ArrayList();
        list.add("1");
        return list;
    }

}
