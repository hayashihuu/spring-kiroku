package com.syun.spring5demo02.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @description: 创建 监听器 简单版
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-09 22:27
 */
@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        System.out.println("---------------------------->请求销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        System.out.println("---------------------------->请求创建");
    }

}
