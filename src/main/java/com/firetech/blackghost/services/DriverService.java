package com.firetech.blackghost.services;

import java.util.List;

import com.firetech.blackghost.model.Driver;

public interface DriverService {

    List<Driver> getAllDrivers();
    Driver createDriver(Driver driver);
    void updateDriver(Driver driver);
}
