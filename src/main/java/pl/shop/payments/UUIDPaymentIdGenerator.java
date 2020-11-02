package pl.shop.payments;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Log
@Component
public class UUIDPaymentIdGenerator implements PaymentIdGenerator {

    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }

}
