package com.gethigh;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MortgageV3 {
    public static void main(String[] args) {

        var mortPrincipal = new MortgagePrincipal(25_000,90_000);

        var mortValuePeriod = new MortgageValuePeriod((byte) 1, (byte) 29);

        var mortValueAnnualRate = new MortgageValueAnnualRate((float) 0.1, (float) 20.1);

        var finalMortgageCalculations = new FinalMortgageCalculations();

        float monthlyPayment = finalMortgageCalculations.monthlyPayment();

        String resultDollars = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("Your monthly payment: " + resultDollars);

        float  principalValue = finalMortgageCalculations.remainingDept();
        int monthX = 0;
        DecimalFormat roundItUp = new DecimalFormat("##.00");

        while (principalValue>0) {

            monthX +=1;

            System.out.printf("Remaining dept in Month %s: "+roundItUp.format(principalValue)+"\n", monthX);

            principalValue = principalValue - monthlyPayment;

        }

    }

}