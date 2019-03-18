package com.syun.pro02;

import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-18 22:10
 */

@ToString
@Setter
public class JavaCollection {

    List addressList;
    Set addressSet;
    Map addressMap;
    Properties addressProp;



}
