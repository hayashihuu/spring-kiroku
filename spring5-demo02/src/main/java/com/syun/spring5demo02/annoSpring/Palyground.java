package com.syun.spring5demo02.annoSpring;

import org.springframework.core.annotation.AnnotationUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @description: 对于 AnnotationUtils 测试
 * 子类可以获取父类的注解
 * spring 中使用 mvc: RequestMappingHandlerMapping  RequestMappingHandlerAdapter
 * BeanAnnotationHelper
 * AnnotationAsyncExecutionInterceptor
 * StaticListableBeanFactory DefaultListableBeanFactory
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-13 19:53
 */
public class Palyground {


    public static void main(String[] args) throws NoSuchMethodException {

        Method method = TestParent.class.getMethod("test", HttpServletRequest.class);
        Annotation staticTestAnnot = AnnotationUtils.findAnnotation(method, StaticTextAnnotation.class);
        System.out.println("@staticTextAnnotation of method is: " + staticTestAnnot);
        System.out.println("@staticTestAnnotation method value: " + AnnotationUtils.getValue(staticTestAnnot, "text"));
        System.out.println("@staticTestAnnotation method default value: " + AnnotationUtils.getDefaultValue(staticTestAnnot, "text"));
        System.out.println("@staticTestAnnotation value: " + AnnotationUtils.getValue(staticTestAnnot));

        System.out.println("--------------分隔符------------------");

        Annotation classNameAnnotation = AnnotationUtils.findAnnotation(TestChildren.class, ClassNameAnnotation.class);
        System.out.println("@ClassNameAnnotation of TestChildren.class is: " + classNameAnnotation);
        System.out.println("@ClassNameAnnotation method value: " + AnnotationUtils.getValue(classNameAnnotation, "className"));
        System.out.println("@ClassNameAnnotation method default value: " + AnnotationUtils.getDefaultValue(classNameAnnotation, "className"));
        System.out.println("@ClassNameAnnotation value: " + AnnotationUtils.getValue(classNameAnnotation));




    }

}
