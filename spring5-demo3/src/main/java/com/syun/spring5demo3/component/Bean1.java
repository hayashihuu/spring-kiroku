package com.syun.spring5demo3.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-07 09:37
 */
@Component
public class Bean1 {

    @Autowired
    @Qualifier("list")
    private ArrayList arrayList;





}
