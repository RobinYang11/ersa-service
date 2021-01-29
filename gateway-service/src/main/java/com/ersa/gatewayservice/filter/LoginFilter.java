package com.ersa.gatewayservice.filter;

import com.ersa.gatewayservice.client.SsoClient;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter extends ZuulFilter {

    private final SsoClient ssoClient;

    @Autowired
    public LoginFilter(SsoClient ssoClient) {
        this.ssoClient = ssoClient;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        ssoClient.setKey("name", "robin");
        System.out.println(ssoClient.hasKey("name"));
        System.out.println(ssoClient.getKey("name"));
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        if (request.getRequestURL().indexOf("login") > 0) {
            return null;
        }
        try {
            response.sendRedirect("http://127.0.0.1:8885/sso-service/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
