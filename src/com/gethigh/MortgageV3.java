package com.gethigh;
import java.text.NumberFormat;
public class MortgageV3 {

    public static void main(String[] args) {

        var MortgageMonthlyPayment = new MortgageMonthlyPayment();
        float  monthlyPayment = MortgageMonthlyPayment.monthlyPayment(0.1F, 20.0F,
                25_000, 90_000, (byte) 1, (byte) 29);

        String resultDollars = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("Your monthly payment: " + resultDollars);

        var MortgageRemainingDept = new MortgageRemainingDept();
        MortgageRemainingDept.mortgageRemainingDept();

    }
}