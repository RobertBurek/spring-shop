package pl.shop.payments;

import lombok.extern.java.Log;

import java.util.UUID;

@Log
public class UUIDPaymentIdGenerator implements PaymentIdGenerator {
    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }

}
