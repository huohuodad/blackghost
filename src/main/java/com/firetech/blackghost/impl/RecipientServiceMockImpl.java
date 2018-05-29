package com.firetech.blackghost.impl;

import java.util.ArrayList;
import java.util.List;

import com.firetech.blackghost.model.Recipient;

public class RecipientServiceMockImpl implements com.firetech.blackghost.services.RecipientService {

    private static List<Recipient> recipients = new ArrayList<>();
    
    private volatile int idGen = 6001;
    
    public List<Recipient> getAllRecipients() {
        return recipients;
    }

    public Recipient createRecipient(Recipient recipient) {
        recipient.setRecipientId(idGen++);
        recipients.add(recipient);
        return recipient;
    }

    public void updateRecipient(Recipient recipient) {
        Recipient d = recipients.stream()
                .filter(x -> x.getRecipientId() == recipient.getRecipientId())
                .findFirst()
                .get();
        if (d != null) {
            d.setRecipientId(recipient.getRecipientId());
            d.setName(recipient.getName());
            d.setMobile(recipient.getMobile());
            d.setTelephone(recipient.getTelephone());
            d.setAddress(recipient.getAddress());
        }
    }

}
