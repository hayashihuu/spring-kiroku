package com.syun.auth.filter;

import com.syun.auth.BaseAuthenticationToken;
import com.syun.auth.commom.SecurityConstants;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-22 17:38
 */
public class BaseUserAutheniticationFilter extends AbstractAuthenticationProcessingFilter implements Filter {


    private String usernameParam = "username";

    private String passowrdParam = "password";

    private boolean postOnly = true;



    public BaseUserAutheniticationFilter(){
        super(new AntPathRequestMatcher(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM, "POST"));
    }

    protected BaseUserAutheniticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    protected BaseUserAutheniticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        if (postOnly && !"POST".equals(httpServletRequest.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not support: " + httpServletRequest.getMethod());
        }

//        获取请求中传来的用户凭证
        String username = obtainUsername(httpServletRequest);
        String password = obtainPassword(httpServletRequest);

        if (username == null) {
            username = "";
        }

        username = username.trim();

//      填充token
        BaseAuthenticationToken authenticationToken = new BaseAuthenticationToken(null, username, password);
        setDetails(httpServletRequest, authenticationToken);

//        调用provider中的验证方法
        return this.getAuthenticationManager().authenticate(authenticationToken);
    }


    protected void setDetails(HttpServletRequest request, BaseAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }




    private String obtainUsername(HttpServletRequest request) {

        return request.getParameter(usernameParam);
    }

    private String obtainPassword(HttpServletRequest request) {
        return request.getParameter(passowrdParam);
    }


    public boolean isPostOnly() {
        return postOnly;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

}
