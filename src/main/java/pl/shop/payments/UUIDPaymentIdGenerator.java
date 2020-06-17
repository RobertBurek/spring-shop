package pl.shop.payments;

import lombok.extern.java.Log;

import java.util.UUID;

@Log
public class UUIDPaymentIdGenerator {
    public String getNext() {
        return UUID.randomUUID().toString();
    }

}
