package com.gethigh;
import java.util.Scanner;

public class MortgageValueAnnualRate {

    private static float minValueAnnualRate;
    private static float maxValueAnnualRate;




    public MortgageValueAnnualRate (float minValueAnnualRate, float maxValueAnnualRate) {
        setMinAnnualRate(minValueAnnualRate);
        setMaxValueAnnualRate(maxValueAnnualRate);
    }

    public static float annualInterestRate () {
        Scanner mortgage = new Scanner(System.in);
        System.out.printf("Annual Rate (%s - %s) ONLY: ", minValueAnnualRate, maxValueAnnualRate);

        while (!mortgage.hasNextFloat()) {
            System.out.printf("Input is not a number. Enter a number: ");
            mortgage.next();
        }

        float annualInterestRate = mortgage.nextFloat();

        while (annualInterestRate < minValueAnnualRate || annualInterestRate > maxValueAnnualRate) {

            System.out.printf("WATRUDOIN I TOLD YA %s - %s", minValueAnnualRate, maxValueAnnualRate);

            System.out.print("\nAnnual Rate : ");

            while (!mortgage.hasNextFloat()) {
                System.out.printf("Input is not a number. Enter a number: ");
                mortgage.next();
            }

            annualInterestRate = mortgage.nextFloat();

            continue;

        }
        return annualInterestRate;
    }

    private void setMinAnnualRate(float minValueAnnualRate) {
        if (minValueAnnualRate <= 0.01) {
            throw new IllegalArgumentException("Annual Rate shouldn't be less or equal to 0.01 MF");
        }
        else {
            this.minValueAnnualRate = minValueAnnualRate;

        }
    }
    private float getMinAnnualRate() {
        return minValueAnnualRate;
    }
    private void setMaxValueAnnualRate (float maxValueAnnualRate) {
        if (maxValueAnnualRate >= 30.0) {
            throw new IllegalArgumentException("Annual Rate shouldn't be more or equal to 30 MF");
        }
        else {
            this.maxValueAnnualRate = maxValueAnnualRate;

        }
    }
    /*
    public static float result() {
        MortgageCalculatorV3 asd = new MortgageCalculatorV3();
        int valuePrincipal = asd.principal;
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

    */




}
