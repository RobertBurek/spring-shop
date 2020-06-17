package pl.shop;

import lombok.extern.java.Log;
import pl.shop.payments.FakePaymentService;
import pl.shop.payments.LocalMoney;
import pl.shop.payments.PaymentRequest;


@Log
public class Application {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33;1m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_FIOLET = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static void main(String[] args) {

        var paymentService = new FakePaymentService();
        var paymentRequest = PaymentRequest.builder()
                .money((LocalMoney.of(1_000)))
                .build();
        var payment = paymentService.process(paymentRequest);
        log.info(ANSI_FIOLET + payment.toString() + ANSI_RESET);

    }
}
