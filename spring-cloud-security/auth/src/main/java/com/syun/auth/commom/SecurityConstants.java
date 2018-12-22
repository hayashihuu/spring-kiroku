package com.syun.auth.commom;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-22 17:42
 */
public interface SecurityConstants {

     String DEFAULT_PARAMETER_NAME_USER = "username";

     String DEFAULT_PARAMETER_NAME_PASSWORD = "password";

    /**
     * 默认的用户名密码登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";



    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";






}
