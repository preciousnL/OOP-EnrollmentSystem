package org.example.service;

/**
 * Delegates all logic to TuitionServiceImpl.
 * Kept for backward compatibility with Main.java.
 */
public class TuitionFeePayment implements ITuitionService {

    private final TuitionServiceImpl impl = new TuitionServiceImpl();

    @Override
    public double calculateTuitionFee(int units, double discountRate) {
        return impl.calculateTuitionFee(units, discountRate);
    }

    @Override
    public void makePayment(double amount) {
        impl.makePayment(amount);
    }

    @Override
    public double getRemainingBalance() {
        return impl.getRemainingBalance();
    }

    @Override
    public boolean isFullyPaid() {
        return impl.isFullyPaid();
    }

    @Override
    public String displayTuitionFee(double totalTuition) {
        return impl.displayTuitionFee(totalTuition);
    }
}