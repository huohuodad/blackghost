package com.firetech.blackghost.model2;

import java.util.Date;

public class Container {
    private int id;                     // 货柜ID
    private String blNo;                // 提单号
    private String containerNo;         // 箱号
    private String model;               // 箱型
    private int quantity;               // 件数
    private double weight;              // 重量（吨）
    private int recipientId;            // 收货单位ID
    private String returnAddress;       // 还箱地址
    private int driverId;               // 司机ID
    private int deliveryId;             // 配送ID
    private Date expectedArrivalTime;   // 期望到达时间
    private Date arrivalTime;           // 实际到达时间
    private int status;                 // 状态 1: 新建 2: 已下达送货指令 3: 司机已提箱再送货中 4: 已收货

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBlNo() {
        return blNo;
    }
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }
    public String getContainerNo() {
        return containerNo;
    }
    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public int getRecipientId() {
        return recipientId;
    }
    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }
    public String getReturnAddress() {
        return returnAddress;
    }
    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public int getDeliveryId() {
        return deliveryId;
    }
    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }
    public Date getExpectedArrivalTime() {
        return expectedArrivalTime;
    }
    public void setExpectedArrivalTime(Date expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }
    public Date getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
