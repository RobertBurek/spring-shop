package pl.shop.payments;

import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FakePaymentServiceTest {

    public static final String PAYMENT_ID = "1";
    public static final FastMoney MONEY = LocalMoney.of(1_000);
    public static final PaymentRequest PAYMENT_REQUEST = PaymentRequest.builder()
            .money(MONEY)
            .build();

    @Mock
    private PaymentIdGenerator paymentIdGenerator;
    private Payment payment;

    @BeforeEach
    void setUp() {
        Mockito.when(paymentIdGenerator.getNext()).thenReturn(PAYMENT_ID);
        FakePaymentService fakePaymentService = new FakePaymentService(paymentIdGenerator);
        payment = fakePaymentService.process(PAYMENT_REQUEST);
    }

    @Test
    void process() {
    }
}