package com.firetech.blackghost.services;

import java.util.List;

import com.firetech.blackghost.model.Recipient;

public interface RecipientService {
    List<Recipient> getAllRecipients();
    Recipient createRecipient(Recipient recipient);
    void updateRecipient(Recipient recipient);
}
