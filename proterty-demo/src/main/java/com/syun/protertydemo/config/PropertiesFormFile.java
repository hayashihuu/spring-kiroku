package com.syun.protertydemo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * @description:
 * @program: proterty-demo
 * @author: syun
 * @create: 2018-12-13 13:59
 */

@PropertySource(value = {"classpath:demo.properties"})
@Data
@Component
public class PropertiesFormFile {

    @Value("${info.name}")
    private String name;

    @Value("${info.age}")
    private Integer age;


}
