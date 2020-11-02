package pl.shop.payments;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static pl.shop.Application.ANSI_GREEN;
import static pl.shop.Application.ANSI_RESET;

@Aspect
@Log
@Component
public class PaymentConsoleLogger {

    public static final String LOG_FORMAT = "A new payment of %s has been initiated";

    @AfterReturning(value = "@annotation(LogPayments)",returning = "payment")
    private void log(Payment payment){
        log.info(ANSI_GREEN + createLogEntry(payment)+ ANSI_RESET);
    }

    String createLogEntry(Payment payment) {
        return String.format(LOG_FORMAT, payment.getMoney());
    }
}
