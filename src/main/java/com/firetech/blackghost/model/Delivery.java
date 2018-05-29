package com.firetech.blackghost.model;

public class Delivery {
    private int deliveryId;
    private int driverId;
    private String blNo;
    private String wharf;
    private int quantity;
    private String retrieveTime;
    private String expectedArrivalTime;
    private String arrivalTime;
    private String recipient;
    private String recipientAddress;
    private int status;
    private String note;

    public int getDeliveryId() {
        return deliveryId;
    }
    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public String getBlNo() {
        return blNo;
    }
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }
    public String getWharf() {
        return wharf;
    }
    public void setWharf(String wharf) {
        this.wharf = wharf;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getRetrieveTime() {
        return retrieveTime;
    }
    public void setRetrieveTime(String retrieveTime) {
        this.retrieveTime = retrieveTime;
    }
    public String getExpectedArrivalTime() {
        return expectedArrivalTime;
    }
    public void setExpectedArrivalTime(String expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public String getRecipient() {
        return recipient;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public String getRecipientAddress() {
        return recipientAddress;
    }
    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}
