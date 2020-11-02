package pl.shop.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import static pl.shop.Application.ANSI_BLUE;
import static pl.shop.Application.ANSI_RESET;

@Component
@Log
@RequiredArgsConstructor
public class LoggingPaymentService implements PaymentService {

    public static final String LOG_FORMAT = "A new payment of %s has been initiated";

    private final FakePaymentService paymentService;

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var payment = paymentService.process(paymentRequest);
        log.info(ANSI_BLUE + createLogEntry(payment) + ANSI_RESET);
        return payment;
    }

    String createLogEntry(Payment payment) {
        return String.format(LOG_FORMAT, payment.getMoney());
    }
}
