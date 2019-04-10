package com.syun.pro06.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Calendar;

/**
 * @description: beanFactory 的后置处理器
 * 初始化时处理一些额外的操作 例：bean 中变量值
 * 需要实现 BeanFactoryPostProcessor
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-04-10 21:20
 */
public class BeanModifier implements BeanFactoryPostProcessor {


    /**
     * 在 AbstractApplicationContext 中 invokeBeanFactoryPostProcessors 方法调用
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Calendar calendar = Calendar.getInstance();
//        若是下午则改变此值
        if (calendar.get(Calendar.AM_PM) == Calendar.PM) {
            BeanDefinition welcomeDef = configurableListableBeanFactory.getBeanDefinition("welcomerBean");
            welcomeDef.getPropertyValues().add("welcomeText", "Good afternoon");
        }
    }
}
