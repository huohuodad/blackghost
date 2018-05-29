package com.firetech.blackghost.model;

public class Customer {
    private int customerId;
    private String name;
    private String telephone;
    private String mobile;
    private String wechatName;

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getWechatName() {
        return wechatName;
    }
    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
