package com.syun.spring5demo3.component;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-10 21:55
 */
public class CustomRegister implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("register success before");
        registry.registerBeanDefinition("bean2", BeanDefinitionBuilder.genericBeanDefinition(Bean2.class).getBeanDefinition());
        System.out.println(registry.getBeanDefinition("bean2"));
        System.out.println("register success after");
    }
}
