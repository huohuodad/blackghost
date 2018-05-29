package com.firetech.blackghost.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.firetech.blackghost.Constants;
import com.firetech.blackghost.model.Driver;

public class WechatAuthFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        Object user = session.getAttribute(Constants.SESSION_DRIVER);
        if (user == null) {
            Driver d = new Driver();
            d.setDriverId(5000);
            d.setName("高剑");
            d.setMobile("13764574562");
            d.setPlateNumber("苏A2MB09");
            d.setWechatName("gaotistuta");
            d.setDriverType(1);
            session.setAttribute(Constants.SESSION_DRIVER, d);
//            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
