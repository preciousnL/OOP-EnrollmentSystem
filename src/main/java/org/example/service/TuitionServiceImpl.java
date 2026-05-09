package org.example.service;

public class TuitionServiceImpl implements ITuitionService {
    private double pricePerUnit = 1000.00; // As per TuitionFeePayment in diagram
    private double balance = 0.0;
    private double totalTuition = 0.0;

    @Override
    public double calculateTuitionFee(int units, double discountRate) {
        double baseFee = units * pricePerUnit;
        double discount = baseFee * discountRate;
        this.totalTuition = baseFee - discount;
        this.balance = this.totalTuition;
        return this.totalTuition;
    }

    @Override
    public void makePayment(double amount) {
        if (amount > 0) {
            this.balance -= amount;
            System.out.println("Payment of Php " + amount + " made successfully.");
        }
    }

    @Override
    public double getRemainingBalance() {
        return Math.max(0, balance);
    }

    @Override
    public boolean isFullyPaid() {
        return balance <= 0 && totalTuition > 0;
    }
}
