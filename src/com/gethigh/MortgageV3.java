package com.gethigh;
import java.text.NumberFormat;
public class MortgageV3 {
        public static void main(String[] args) {

        var mortgageValuePeriod = new MortgageValuePeriod((byte) 1, (byte) 29);
        var mortgageValuePrincipal = new MortgagePrincipal(25_000, 90_000);
        var mortgageValueAnnualRate = new MortgageValueAnnualRate(0.1F, 20.0F);

        var monthlyPayment = new MortgageFormulas(mortgageValuePeriod,
                mortgageValuePrincipal, mortgageValueAnnualRate);

        monthlyPayment.monthlyPayment();


        System.out.println("Your monthly payment: " +
                NumberFormat.getCurrencyInstance().format(MortgageFormulas.getMonthlyPayment()));

        int month = 0;
        var MortgageRemainingDept = new MortgageRemainingDept();

        for (double balance : MortgageRemainingDept.mortgageRemainingDept()) {
            month++;
            System.out.printf("Ending (Remaining) Balance (Dept), Month %s: "
                    + NumberFormat.getCurrencyInstance().format(balance) + "\n", month);
        }

            var mortgageValuePrincipalv2 = new MortgagePrincipalv2(25_000, 90_000);
            MortgageFormulas.setMortgageValuePrincipal(mortgageValuePrincipalv2);

            monthlyPayment.monthlyPayment();
            System.out.println("Your monthly payment: " +
                    NumberFormat.getCurrencyInstance().format(MortgageFormulas.getMonthlyPayment()));

        }
}