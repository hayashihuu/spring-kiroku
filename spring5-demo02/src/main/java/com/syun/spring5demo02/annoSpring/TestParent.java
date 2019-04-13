package com.syun.spring5demo02.annoSpring;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-13 19:51
 */
@ClassNameAnnotation(className = "TestChildren")
public class TestParent {

    @StaticTextAnnotation(value = "Custom text value", text = "Test test")
    public String test(HttpServletRequest request) {
        return "test";
    }



}
