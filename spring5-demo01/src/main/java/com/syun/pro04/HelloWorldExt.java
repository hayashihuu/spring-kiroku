package com.syun.pro04;

import com.syun.pro01.HelloWorld;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-19 20:26
 */

public class HelloWorldExt  {

    private HelloWorld helloWorld;

    public HelloWorldExt(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void hello(){
        helloWorld.getMessage();
    }


}
