package pl.shop.payments;

import lombok.extern.java.Log;

import java.time.Instant;

import static pl.shop.Application.ANSI_RESET;
import static pl.shop.Application.ANSI_YELLOW;

@Log
public class FakePaymentService {

    public static final String LOG_FORMAT = "A new payment of %s has been initiated";

    private final UUIDPaymentIdGenerator uuidPaymentIdGenerator = new UUIDPaymentIdGenerator();

    public Payment process(PaymentRequest paymentRequest) {
        var payment = Payment.builder()
                .id(uuidPaymentIdGenerator.getNext())
                .money(paymentRequest.getMoney())
                .timestamp(Instant.now())
                .status(PaymentStatus.STARTED)
                .build();
        log.info(ANSI_YELLOW + createLogEntry(payment) + ANSI_RESET);
        return payment;
    }

    String createLogEntry(Payment payment) {
        return String.format(LOG_FORMAT, payment.getMoney());
    }
}
