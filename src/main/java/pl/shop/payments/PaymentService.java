package pl.shop.payments;

public interface PaymentService {

    Payment process(PaymentRequest paymentRequest);
}
