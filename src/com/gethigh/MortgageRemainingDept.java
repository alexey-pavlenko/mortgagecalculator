package com.gethigh;
public class MortgageRemainingDept {
    public double[] mortgageRemainingDept() {

        short getNumberOfPayments = MortgageValuePeriod.getNumberOfPayments();

        var balances = new double [getNumberOfPayments];
        for (short month = 1; MortgageFormulas.endingBalance(month) > 0; month++) {
            balances[month-1] = MortgageFormulas.endingBalance(month);
        }
        return balances;
    }
}



