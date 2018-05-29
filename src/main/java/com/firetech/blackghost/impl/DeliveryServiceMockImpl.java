package com.firetech.blackghost.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.firetech.blackghost.model.Delivery;
import com.firetech.blackghost.model.Signature;
import com.firetech.blackghost.services.DeliveryService;

public class DeliveryServiceMockImpl implements DeliveryService {

    private static List<Delivery> deliveries = new ArrayList<>();
    
    private static Map<Integer, Signature> signatures = new HashMap<>();

    private volatile int idGen = 10000;
    
    public List<Delivery> getAllOpenDelivery() {
        return deliveries.stream()
                .filter(x -> x.getStatus() < 6)
                .collect(Collectors.toList());
    }

    public List<Delivery> searchDelivery(String keyword) {
        List<Delivery> list = deliveries.stream()
                .filter(x -> x.getBlNo().equals(keyword))
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            list = deliveries.stream()
                    .filter(x -> x.getRecipient().contains(keyword))
                    .collect(Collectors.toList());
        }
        if (list.isEmpty()) {
            list = deliveries.stream()
                    .filter(x -> x.getRecipientAddress().contains(keyword))
                    .collect(Collectors.toList());
        }
        return list;
    }

    public Delivery createDelivery(Delivery delivery) {
        delivery.setDeliveryId(idGen++);
        deliveries.add(delivery);
        return delivery;
    }

    public void updateDelivery(Delivery delivery) {
        Delivery d = deliveries.stream()
                .filter(x -> x.getDeliveryId() == delivery.getDeliveryId())
                .findFirst()
                .get();
        if (d != null) {
            d.setDriverId(delivery.getDriverId());
            d.setBlNo(delivery.getBlNo());
            d.setWharf(delivery.getWharf());
            d.setQuantity(delivery.getQuantity());
            d.setRetrieveTime(delivery.getRetrieveTime());
            d.setExpectedArrivalTime(delivery.getExpectedArrivalTime());
            d.setArrivalTime(delivery.getArrivalTime());
            d.setRecipient(delivery.getRecipient());
            d.setRecipientAddress(delivery.getRecipientAddress());
            d.setStatus(delivery.getStatus());
            d.setNote(delivery.getNote());
        }
    }

    @Override
    public List<Delivery> getDeliveriesByDriverId(int driverId) {
        List<Delivery> list = deliveries.stream()
                .filter(x -> x.getDriverId() == driverId)
                .filter(x -> x.getStatus() < 6 && x.getStatus() > 1)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public Delivery getDeliveryById(int deliveryId) {
        return deliveries.stream()
                .filter(x -> (x.getDeliveryId() == deliveryId))
                .findFirst()
                .get();
    }

    @Override
    public Signature getSignature(int deliveryId) {
        return signatures.get(deliveryId);
    }

    @Override
    public void saveSignature(int deliveryId, Signature signature) {
        signatures.put(deliveryId, signature);
    }

}
