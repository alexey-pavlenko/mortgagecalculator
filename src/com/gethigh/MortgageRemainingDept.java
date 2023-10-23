package com.gethigh;
import java.text.DecimalFormat;
public class MortgageRemainingDept {
    public void mortgageRemainingDept() {

        float monthlyPayment = MortgageMonthlyPayment.getMonthlyPayment();

        float principalValue = MortgagePrincipal.getValuePrincipal();

        int monthX = 0;
        DecimalFormat roundItUp = new DecimalFormat("##.0");

        while (principalValue > 0) {

            monthX += 1;

            System.out.printf("Remaining dept in Month %s: $" + roundItUp.format(principalValue) + "\n", monthX);

            principalValue = principalValue - monthlyPayment;

        }

    }
}



