package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for payment balance checking.
 * Tests payment processing and balance tracking.
 */
public class PaymentBalanceTest {

    private TuitionServiceImpl tuitionService;
    private static final double PRICE_PER_UNIT = 1000.00;

    @BeforeEach
    void setUp() {
        tuitionService = new TuitionServiceImpl();
        // Initialize with a tuition fee calculation
        tuitionService.calculateTuitionFee(5, 0.0); // 5000.00 tuition
    }

    @Test
    void testInitialBalanceAfterCalculation() {
        // After calculating tuition, balance should equal total tuition
        double expectedBalance = 5000.00;
        double actualBalance = tuitionService.getRemainingBalance();

        assertEquals(expectedBalance, actualBalance, 0.01,
            "Initial balance should equal total tuition");
    }

    @Test
    void testMakePaymentReducesBalance() {
        // Make a payment of 2000
        double paymentAmount = 2000.00;
        tuitionService.makePayment(paymentAmount);

        double expectedBalance = 3000.00; // 5000 - 2000
        double actualBalance = tuitionService.getRemainingBalance();

        assertEquals(expectedBalance, actualBalance, 0.01,
            "Balance should be reduced by payment amount");
    }

    @Test
    void testMakeFullPayment() {
        // Pay the full balance
        double paymentAmount = 5000.00;
        tuitionService.makePayment(paymentAmount);

        double expectedBalance = 0.00;
        double actualBalance = tuitionService.getRemainingBalance();

        assertEquals(expectedBalance, actualBalance, 0.01,
            "Balance should be 0 after full payment");
    }

    @Test
    void testMakeOverPayment() {
        // Pay more than the balance
        double paymentAmount = 6000.00;
        tuitionService.makePayment(paymentAmount);

        // Balance should be 0 (not negative)
        double expectedBalance = 0.00;
        double actualBalance = tuitionService.getRemainingBalance();

        assertEquals(expectedBalance, actualBalance, 0.01,
            "Balance should be 0 after overpayment (no negative balance)");
    }

    @Test
    void testMakeZeroPayment() {
        // Make a payment of 0
        double initialBalance = tuitionService.getRemainingBalance();

        tuitionService.makePayment(0.00);

        double finalBalance = tuitionService.getRemainingBalance();

        assertEquals(initialBalance, finalBalance, 0.01,
            "Zero payment should not change balance");
    }

    @Test
    void testMakeNegativePayment() {
        // Make a negative payment (invalid)
        double initialBalance = tuitionService.getRemainingBalance();

        tuitionService.makePayment(-100.00);

        double finalBalance = tuitionService.getRemainingBalance();

        assertEquals(initialBalance, finalBalance, 0.01,
            "Negative payment should not change balance");
    }

    @Test
    void testIsFullyPaidReturnsFalse() {
        // With initial balance, should not be fully paid
        assertFalse(tuitionService.isFullyPaid(),
            "Should not be fully paid initially");
    }

    @Test
    void testIsFullyPaidReturnsTrue() {
        // Make full payment
        tuitionService.makePayment(5000.00);

        assertTrue(tuitionService.isFullyPaid(),
            "Should be fully paid after full payment");
    }

    @Test
    void testMultiplePayments() {
        // Make multiple payments
        tuitionService.makePayment(1000.00);
        tuitionService.makePayment(1500.00);
        tuitionService.makePayment(500.00);

        double expectedBalance = 2000.00; // 5000 - (1000 + 1500 + 500)
        double actualBalance = tuitionService.getRemainingBalance();

        assertEquals(expectedBalance, actualBalance, 0.01,
            "Balance should reflect multiple payments");

        assertFalse(tuitionService.isFullyPaid(),
            "Should not be fully paid after partial payments");
    }
}
