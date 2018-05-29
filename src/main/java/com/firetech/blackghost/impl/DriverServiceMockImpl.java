package com.firetech.blackghost.impl;

import java.util.ArrayList;
import java.util.List;

import com.firetech.blackghost.model.Driver;
import com.firetech.blackghost.services.DriverService;

public class DriverServiceMockImpl implements DriverService {

    private static List<Driver> drivers = new ArrayList<>();
    static {
        Driver d = new Driver();
        d.setDriverId(5000);
        d.setName("高剑");
        d.setMobile("13764574562");
        d.setPlateNumber("苏A2MB09");
        d.setWechatName("gaotistuta");
        d.setDriverType(1);
        drivers.add(d);
    }
    
    private volatile int idGen = 5001;
    
    public List<Driver> getAllDrivers() {
        return drivers;
    }

    public Driver createDriver(Driver driver) {
        driver.setDriverId(idGen++);
        drivers.add(driver);
        return driver;
    }

    public void updateDriver(Driver driver) {
        Driver d = drivers.stream()
                .filter(x -> x.getDriverId() == driver.getDriverId())
                .findFirst()
                .get();
        if (d != null) {
            d.setDriverId(driver.getDriverId());
            d.setName(driver.getName());
            d.setMobile(driver.getMobile());
            d.setPlateNumber(driver.getPlateNumber());
            d.setWechatName(driver.getWechatName());
            d.setDriverType(driver.getDriverType());
        }
    }

}
