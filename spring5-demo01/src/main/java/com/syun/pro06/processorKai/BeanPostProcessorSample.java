package com.syun.pro06.processorKai;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @description: 在 bean factory 后置处理器调用后之后调用
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-04-10 22:08
 */

public class BeanPostProcessorSample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        若是不为真则干掉这个 bean
        if (bean instanceof ProcessedBean) {
            if (!((ProcessedBean)bean).isValid()) {
                System.out.println(true);
                return null;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
