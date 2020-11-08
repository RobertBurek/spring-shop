package pl.shop.payments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Long.parseLong;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IncrementalPaymentIdGeneratorTest {

    private final static String ID_FORMAT = "\\d{10}";

    private final IncrementalPaymentIdGenerator incrementalPaymentIdGenerator = new IncrementalPaymentIdGenerator();

    @DisplayName("Should generate valid Id")
    @Test
    void shouldGenerateValidId() {
        String id = incrementalPaymentIdGenerator.getNext();
        assertEquals(true, id.matches(ID_FORMAT));
    }

    @DisplayName("Should generate Id by incrementing value of previousOne")
    @Test
    void shouldGenerateIdByIncrementingValueOfPreviousOne() {
        long firstValue = parseLong(incrementalPaymentIdGenerator.getNext());
        long secondValue = parseLong(incrementalPaymentIdGenerator.getNext());
        assertEquals(firstValue + 1, secondValue);
    }

}