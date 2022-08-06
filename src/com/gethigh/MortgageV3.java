package com.gethigh;
import java.text.NumberFormat;

public class MortgageV3 {
    public static void main(String[] args) {

        var mort = new MortgageCalculatorV3();
        mort.valuePrincipalMinMax(25_000,90_000);

       mort.valuePeriodMinMax((byte) 1, (byte) 29);

       mort.annualRateValueMinMax((float) 0.1, (float) 20.1);

        float mortgageResult = mort.result();

        String resultDollars = NumberFormat.getCurrencyInstance().format(mortgageResult);

        System.out.println("Your monthly payment: " + resultDollars);
    }
}