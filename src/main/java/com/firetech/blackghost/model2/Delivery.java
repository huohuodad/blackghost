package com.firetech.blackghost.model2;

import java.util.Date;

public class Delivery {
    private int id;             // 配送ID
    private int driverId;       // 司机ID
    private Date startTime;     // 配送开始时间
    private String note;        // 注意事项 （提醒驾驶员）

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}
