package com.firetech.blackghost.model2;

import java.util.Date;

public class BillOfLanding {
    private String blNo;                // 提单号
    private int quantity;               // 货柜数
    private String content;             // 品名
    private String brand;               // 品牌
    private String countryOfOrigin;     // 原产国（比如，泰国）
    private String wharf;               // 靠泊码头
    private Date arriveDate;            // 到港日期
    private String quarantineApplyNo;   // 检验检疫报检编号（发给驾驶员）
    private int quarantineContainerQuantity;    // （检验检疫）查验箱量
    private String quarantineAddress;   // 查验地址

    public String getBlNo() {
        return blNo;
    }
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
    public String getWharf() {
        return wharf;
    }
    public void setWharf(String wharf) {
        this.wharf = wharf;
    }
    public Date getArriveDate() {
        return arriveDate;
    }
    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }
    public String getQuarantineApplyNo() {
        return quarantineApplyNo;
    }
    public void setQuarantineApplyNo(String quarantineApplyNo) {
        this.quarantineApplyNo = quarantineApplyNo;
    }
    public int getQuarantineContainerQuantity() {
        return quarantineContainerQuantity;
    }
    public void setQuarantineContainerQuantity(int quarantineContainerQuantity) {
        this.quarantineContainerQuantity = quarantineContainerQuantity;
    }
    public String getQuarantineAddress() {
        return quarantineAddress;
    }
    public void setQuarantineAddress(String quarantineAddress) {
        this.quarantineAddress = quarantineAddress;
    }
}
