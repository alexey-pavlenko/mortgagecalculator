package com.gethigh;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MortgageV3 {
    public static void main(String[] args) {

        var mort = new MortgageCalculatorV3();
        mort.valuePrincipalMinMax(25_000,90_000);

        mort.valuePeriodMinMax((byte) 1, (byte) 29);

        mort.annualRateValueMinMax((float) 0.1, (float) 20.1);

        float mortgageResult = mort.result();

        float valRemaining = mort.remaining();


        String resultDollars = NumberFormat.getCurrencyInstance().format(mortgageResult);

        System.out.println("Your monthly payment: " + resultDollars);

        float  principalValue = valRemaining;
        int monthX = 0;
        DecimalFormat roundItUp = new DecimalFormat("##.00");

        while (principalValue>0) {

            monthX +=1;

            System.out.printf("Remaining dept in Month %s: "+roundItUp.format(principalValue)+"\n", monthX);

            principalValue = principalValue - mortgageResult;

        }

    }

}