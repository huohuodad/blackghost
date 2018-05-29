package com.firetech.blackghost.model;

public class Driver {

    private int driverId;
    private String name;
    private String mobile;
    private String plateNumber;
    private String wechatName;
    private int driverType;


    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public String getWechatName() {
        return wechatName;
    }
    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }
    public int getDriverType() {
        return driverType;
    }
    public void setDriverType(int driverType) {
        this.driverType = driverType;
    }
    
}
