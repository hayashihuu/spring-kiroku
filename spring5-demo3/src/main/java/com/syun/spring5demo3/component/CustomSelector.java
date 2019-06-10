package com.syun.spring5demo3.component;

import ch.qos.logback.core.spi.ContextAware;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-10 21:37
 */
@Slf4j
public class CustomSelector implements ImportSelector, BeanFactoryAware{


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("set beanFactory");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String test = Bean2.class.getName();
        System.out.println(test);
        return new String[]{test};
    }



}
