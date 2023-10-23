package com.gethigh;
public class MortgageMonthlyPayment {
    public static float monthlyPayment;
    public static float monthlyPayment(float minValueAnnualRate, float maxValueAnnualRate,
                                int minValuePrincipal, int maxValuePrincipal,
                                byte minValuePeriod, byte maxValuePeriod) {

        new MortgagePrincipal(minValuePrincipal,maxValuePrincipal);
        var superAnnualRate = new MortgageValueAnnualRate(minValueAnnualRate,maxValueAnnualRate);
        var superPeriodYears = new MortgageValuePeriod(minValuePeriod,maxValuePeriod);

        MortgagePrincipal.valuePrincipal();
        superAnnualRate.annualInterestRate();
        superPeriodYears.periodYears();

        float monthInterestRate = superAnnualRate.getAnnualInterestRate()/100/12;
        float parentheses = 1 + monthInterestRate;
        float numberOfPayments = superPeriodYears.getPeriodYears() * 12;
        float power = (float) Math.pow(parentheses,numberOfPayments);
        float upperLine = monthInterestRate*power;
        float bottomLine = power-1;
        float mortgageResult = MortgagePrincipal.getValuePrincipal()*(upperLine/bottomLine);
        float round = Math.round(mortgageResult*100);
        monthlyPayment = round/100;
        return monthlyPayment;
    }
    public static float getMonthlyPayment() {
        return monthlyPayment;
    }
}
