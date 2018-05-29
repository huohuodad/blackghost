package com.firetech.blackghost.services;

import java.util.List;

import com.firetech.blackghost.model.Delivery;
import com.firetech.blackghost.model.Signature;

public interface DeliveryService {

    List<Delivery> getAllOpenDelivery();
    List<Delivery> searchDelivery(String keyword);
    Delivery createDelivery(Delivery delivery);
    void updateDelivery(Delivery delivery);
    List<Delivery> getDeliveriesByDriverId(int driverId);
    Delivery getDeliveryById(int deliveryId);
    Signature getSignature(int deliveryId);
    void saveSignature(int deliveryId, Signature signature);
}
