package com.firetech.blackghost.restclient;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.firetech.blackghost.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class WechatRestClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatRestClient.class);

    public String getUserName(String code) {
        String getAccessTokenUrl = Constants.GET_ACCESS_TOKEN_URL.replace("CODE", code);
        CloseableHttpClient httpclient = HttpClients.custom().build();
        HttpGet request = new HttpGet(getAccessTokenUrl);
        AccessTokenResponse respBean = null;
        try (CloseableHttpResponse response = httpclient.execute(request)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                LOGGER.error(getResponseBean(response, ErrorResponse.class).toString());
                throw new RuntimeException("failed to get access token.");
            }
            respBean = getResponseBean(response, AccessTokenResponse.class);
            LOGGER.info(respBean.toString());
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        String getUserInfoUrl = Constants.GET_USER_INFO_URL.replace("ACCESS_TOKEN", respBean.getAccess_token())
                .replace("OPENID", respBean.getOpenid());
        request = new HttpGet(getUserInfoUrl);
        UserInfoResponse userInfoRespBean = null;
        try (CloseableHttpResponse response = httpclient.execute(request)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                LOGGER.error(getResponseBean(response, ErrorResponse.class).toString());
                throw new RuntimeException("failed to get user info.");
            }
            userInfoRespBean = getResponseBean(response, UserInfoResponse.class);
            LOGGER.info(userInfoRespBean.toString());
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userInfoRespBean.getUnionid();
    }

    private <T> T getResponseBean(CloseableHttpResponse response, Class<T> beanClass) {
        String respBody = null;
        try {
            respBody = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        try {
            Gson gson = new Gson();
            return gson.fromJson(respBody, beanClass);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("Error to parse JSON response " + respBody, e);
        }
    }

}
