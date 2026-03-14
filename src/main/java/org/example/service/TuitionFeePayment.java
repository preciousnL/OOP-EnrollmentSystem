package org.example.service;

import org.example.model.Student;
import org.example.service.StudentRegistration;

import java.util.ArrayList;

public class TuitionFeePayment {
    ArrayList<Double> balances = new ArrayList<>();
    private double pricePerUnit = 1000;
    private double balance;
    private double totalTuition;

    public TuitionFeePayment(){

    }

    public double calculateTuitionFee(int units, double discountRate){

        this.totalTuition = units * pricePerUnit;
        this.totalTuition = totalTuition - (totalTuition * discountRate);
        balance = totalTuition;
        balances.add(balance);
        return totalTuition;

    }

    public void makePayment(double amount){
        if (balances.isEmpty()){
            System.out.println("\n===================================================");
            System.out.println("\nNo Transaction Found.");
        }

        if(amount <= 0){
            System.out.println("\n===================================================");
            System.out.println("\nInvalid payment amount.");
            return;
        }

        balance -= amount;

        if(balance < 0){
            balance = 0;
        }
    }

    public double getRemainingBalance(){
        if (balances.isEmpty()){
            System.out.println("\n===================================================");
            System.out.println("\nNo Transaction Found.");
        }

        return balance;
    }

    public boolean isFullyPaid(){
        if (balances.isEmpty()){
            System.out.println("\n===================================================");
            System.out.println("\nNo Transaction Found.");
        }

        return balance <= 0;
    }

    public double getPricePerUnit(){
        if (balances.isEmpty()){
            System.out.println("\n===================================================");
            System.out.println("\nNo Transaction Found.");
        }
        return pricePerUnit;
    }

    public String displayTuitionFee(double totalTuition){
        return String.format("\nTotal Tuition Fee Amount: %.2f", totalTuition);
    }
}