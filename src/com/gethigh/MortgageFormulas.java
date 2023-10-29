package com.gethigh;
public class MortgageFormulas {
    private static float monthlyPayment;
    private static double endingBalance;
    private static MortgageValuePeriod mortgageValuePeriod;
    private static MortgagePrincipal mortgageValuePrincipal;
    private static MortgageValueAnnualRate mortgageValueAnnualRate;
    public MortgageFormulas(MortgageValuePeriod mortgageValuePeriod,
                            MortgagePrincipal mortgageValuePrincipal,
                            MortgageValueAnnualRate mortgageValueAnnualRate) {
        this.mortgageValuePeriod = mortgageValuePeriod;
        this.mortgageValuePrincipal = mortgageValuePrincipal;
        this.mortgageValueAnnualRate = mortgageValueAnnualRate;
    }
    private static float monthInterestRate(){
        float monthInterestRate = mortgageValueAnnualRate.getAnnualInterestRate()/100/12;

        return monthInterestRate;
    }
    private static float parentheses(){
        float parentheses = 1 + monthInterestRate();

        return parentheses;
    }
    public float monthlyPayment() {
        mortgageValuePrincipal.valuePrincipal();
        mortgageValueAnnualRate.annualInterestRate();
        mortgageValuePeriod.periodYears();

        float numberOfPayments = mortgageValuePeriod.getPeriodYears() * 12;
        float power = (float) Math.pow(parentheses(),numberOfPayments);
        float upperLine = monthInterestRate()*power;
        float bottomLine = power-1;
        float mortgageResult = mortgageValuePrincipal.getValuePrincipal()*(upperLine/bottomLine);
        float round = Math.round(mortgageResult*100);
        monthlyPayment = round/100;

        return monthlyPayment;
    }
    public static double endingBalance(double madePayments) {
        endingBalance = mortgageValuePrincipal.getValuePrincipal()*(Math.pow(parentheses(),madePayments))-
                (monthlyPayment/monthInterestRate())*(Math.pow(parentheses(),madePayments)-1);

        return endingBalance;
    }
    public static float getMonthlyPayment() {
        return monthlyPayment;
    }
}
