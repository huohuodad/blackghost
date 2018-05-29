package com.firetech.blackghost.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.firetech.blackghost.restclient.WechatRestClient;

public class WechatLoginServlet extends HttpServlet {

    private static final long serialVersionUID = -7284701394032590469L;

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatLoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        WechatRestClient restClient = new WechatRestClient();
        try {
            restClient.getUserName(code);   
        } catch (Exception e) {
            LOGGER.error("get user name error.", e);
        }
        resp.sendRedirect("wechat/ongoing-deliveries.html");
    }
}
