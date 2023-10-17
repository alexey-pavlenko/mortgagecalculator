package com.gethigh;

import static com.gethigh.MortgageValueAnnualRate.annualInterestRate;
import static com.gethigh.MortgageValuePeriod.periodYears;
import static com.gethigh.MortgagePrincipal.valuePrincipal;

public class FinalMortgageCalculations
{
    public float monthlyPayment() {
        int valuePrincipal = valuePrincipal();
        int periodYears = periodYears();
        float annualInterestRate = annualInterestRate();
        float monthInterestRate = annualInterestRate/100/12;
        float parentheses = 1 + monthInterestRate;
        float numberOfPayments = periodYears * 12;
        float power = (float) Math.pow(parentheses,numberOfPayments);
        float upperLine = monthInterestRate*power;
        float bottomLine = power-1;
        float mortgageResult = valuePrincipal*(upperLine/bottomLine);
        float round = Math.round(mortgageResult*100);
        return round/100;

    }

    public float remainingDept() {
        return (float) valuePrincipal();
    }

}
