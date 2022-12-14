package com.gethigh;
import java.util.Scanner;

public class MortgageCalculatorV3 {
    private static int minValuePrincipal;
    private static int maxValuePrincipal;
    private static byte minValuePeriod;
    private static byte maxValuePeriod;
    private static float minValueAnnualRate;
    private static float maxValueAnnualRate;
    private static boolean gotPrincipal = false;
    private static int principal;




    public void valuePrincipalMinMax (int minValuePrincipal, int maxValuePrincipal) {
        setMinValuePrincipal(minValuePrincipal);
        setMaxValuePrincipal(maxValuePrincipal);
    }
    private int valuePrincipal () {

        if (!gotPrincipal) {

            Scanner mortgage = new Scanner(System.in);
            System.out.printf("Principal (%s - %s) ONLY: ", minValuePrincipal, maxValuePrincipal);

            while (!mortgage.hasNextInt()) {
                System.out.printf("Input is not a number. Enter a number: ");
                mortgage.next();
            }

            principal = mortgage.nextInt();



            while (principal < minValuePrincipal || principal > maxValuePrincipal) {

                System.out.printf("WATRUDOIN I TOLD YA %s - %s", minValuePrincipal, maxValuePrincipal);

                System.out.printf("\nPrincipal (%s - %s) ONLY: ", minValuePrincipal, maxValuePrincipal);

                while (!mortgage.hasNextInt()) {
                    System.out.printf("Input is not a number. Enter a number: ");

                    mortgage.next();

                }


                principal = mortgage.nextInt();



                // continue;



            }

            gotPrincipal = true;
        }



        return principal;
    }
    private void setMinValuePrincipal (int minValuePrincipal) {
        if (minValuePrincipal <= 20_000) {
            throw new IllegalArgumentException("Principal shouldn't be less or equal to 0 MF");
        }
        else {
            this.minValuePrincipal = minValuePrincipal;
        }
    }
    private void setMaxValuePrincipal (int maxValuePrincipal) {
        if (maxValuePrincipal >= 1_000_000) {
            throw new IllegalArgumentException("Principal shouldn't be less or equal to 0 MF");
        }
        else {
            this.maxValuePrincipal = maxValuePrincipal;
        }
    }
    public void valuePeriodMinMax (byte minValuePeriod, byte maxValuePeriod) {
        setMinValuePeriod(minValuePeriod);
        setMaxValuePeriod(maxValuePeriod);
    }
    private static byte periodYears () {

        Scanner mortgage = new Scanner(System.in);
        System.out.printf("Period (Years) (%s - %s) ONLY: ", minValuePeriod, maxValuePeriod);

        while (!mortgage.hasNextByte()) {
            System.out.printf("Input is not a number. Enter a number: ");
            mortgage.next();
        }

        byte periodYears = mortgage.nextByte();

        while (periodYears < minValuePeriod || periodYears > maxValuePeriod) {


            System.out.printf("WATRUDOIN I TOLD YA %s - %s", minValuePeriod, maxValuePeriod);

            System.out.print("\nPeriod (Years): ");

            while (!mortgage.hasNextByte()) {
                System.out.printf("Input is not a number. Enter a number: ");
                mortgage.next();
            }

            periodYears = mortgage.nextByte();

            continue;

        }
        return periodYears;
    }
    private void setMinValuePeriod (byte minValuePeriod) {
        if (minValuePeriod <= 0) {
            throw new IllegalArgumentException("periodYears shouldn't be less or equal to 0 MF");
        }
        else {
            this.minValuePeriod = minValuePeriod;
        }
    }

    private void setMaxValuePeriod (byte maxValuePeriod) {
        if (maxValuePeriod >= 30) {
            throw new IllegalArgumentException("periodYears shouldn't be more or equal to 30 MF");
        }
        else {
            this.maxValuePeriod = maxValuePeriod;
        }
    }

    public void annualRateValueMinMax (float minValueAnnualRate, float maxValueAnnualRate) {
        setMinAnnualRate(minValueAnnualRate);
        setMaxValueAnnualRate(maxValueAnnualRate);
    }

    private static float annualInterestRate () {
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

    public float result() {
        var resultMortgage = new MortgageCalculatorV3();
        int valuePrincipal = resultMortgage.valuePrincipal();
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

    public float remaining() {
        var asd  = new MortgageCalculatorV3();
        float valueRemaining = asd.valuePrincipal();
        return valueRemaining;
    }



}
