package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for tuition fee calculation.
 * Tests tuition calculation with different units and discount rates.
 */
public class TuitionFeeCalculationTest {

    private TuitionServiceImpl tuitionService;
    private static final double PRICE_PER_UNIT = 1000.00;

    @BeforeEach
    void setUp() {
        tuitionService = new TuitionServiceImpl();
    }

    @Test
    void testCalculateTuitionWithoutDiscount() {
        // Calculate tuition for 5 units with 0% discount
        int units = 5;
        double discountRate = 0.0;
        double expectedTuition = units * PRICE_PER_UNIT; // 5000.00

        double actualTuition = tuitionService.calculateTuitionFee(units, discountRate);

        assertEquals(expectedTuition, actualTuition, 0.01,
            "Tuition without discount should be units * price per unit");
    }

    @Test
    void testCalculateTuitionWithDiscount() {
        // Calculate tuition for 6 units with 10% discount
        int units = 6;
        double discountRate = 0.10; // 10% discount
        double expectedTuition = (units * PRICE_PER_UNIT) * (1 - discountRate); // 5400.00

        double actualTuition = tuitionService.calculateTuitionFee(units, discountRate);

        assertEquals(expectedTuition, actualTuition, 0.01,
            "Tuition with discount should be calculated correctly");
    }

    @Test
    void testCalculateTuitionWithFullDiscount() {
        // Calculate tuition with 100% discount (free)
        int units = 5;
        double discountRate = 1.0; // 100% discount
        double expectedTuition = 0.0;

        double actualTuition = tuitionService.calculateTuitionFee(units, discountRate);

        assertEquals(expectedTuition, actualTuition, 0.01,
            "Tuition with 100% discount should be 0");
    }

    @Test
    void testCalculateTuitionWithZeroUnits() {
        // Calculate tuition for 0 units
        int units = 0;
        double discountRate = 0.0;
        double expectedTuition = 0.0;

        double actualTuition = tuitionService.calculateTuitionFee(units, discountRate);

        assertEquals(expectedTuition, actualTuition, 0.01,
            "Tuition for 0 units should be 0");
    }

    @Test
    void testDisplayTuitionFeeFormat() {
        // Test the display format method
        double totalTuition = 5000.00;
        String display = tuitionService.displayTuitionFee(totalTuition);

        assertTrue(display.contains("5000.00"),
            "Display should contain the tuition amount");
        assertTrue(display.contains("Total Tuition Fee"),
            "Display should contain descriptive text");
    }

    @Test
    void testMultipleTuitionCalculations() {
        // Test multiple calculations to ensure service handles multiple transactions
        double tuition1 = tuitionService.calculateTuitionFee(3, 0.0);
        double tuition2 = tuitionService.calculateTuitionFee(4, 0.0);

        assertEquals(3000.00, tuition1, 0.01, "First tuition should be 3000");
        assertEquals(4000.00, tuition2, 0.01, "Second tuition should be 4000");
    }
}
