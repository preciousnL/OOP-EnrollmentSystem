package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TuitionFeePaymentTest {
    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
    void setUp(){
        tuitionFeePayment = new TuitionFeePayment();
    }

    @Test
    void testCalculateTuitionFeeWithoutDiscount() {
        double result = tuitionFeePayment.calculateTuitionFee(3, 0.0);

        assertEquals(3000.0, result);
        assertEquals(3000.0, tuitionFeePayment.getRemainingBalance());
    }

    @Test
    void testCalculateTuitionFeeWithDiscount() {
        double result = tuitionFeePayment.calculateTuitionFee(3, 0.50);

        assertEquals(1500.0, result);
        assertEquals(1500.0, tuitionFeePayment.getRemainingBalance());
    }

    @Test
    void testMakePaymentReducesBalance() {
        tuitionFeePayment.calculateTuitionFee(3, 0.0);
        tuitionFeePayment.makePayment(1000.0);

        assertEquals(2000.0, tuitionFeePayment.getRemainingBalance());
        assertFalse(tuitionFeePayment.isFullyPaid());
    }

    @Test
    void testFullPaymentMakesBalanceZero() {
        tuitionFeePayment.calculateTuitionFee(3, 0.0);
        tuitionFeePayment.makePayment(3000.0);

        assertEquals(0.0, tuitionFeePayment.getRemainingBalance());
        assertTrue(tuitionFeePayment.isFullyPaid());
    }

    @Test
    void testOverPaymentKeepsBalanceAtZero() {
        tuitionFeePayment.calculateTuitionFee(3, 0.0);
        tuitionFeePayment.makePayment(5000.0);

        assertEquals(0.0, tuitionFeePayment.getRemainingBalance());
        assertTrue(tuitionFeePayment.isFullyPaid());
    }
}