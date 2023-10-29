package com.gethigh;
import java.util.Scanner;
public class MortgageValueAnnualRate {
    public float minValueAnnualRate;
    public float maxValueAnnualRate;
    private float annualInterestRate;
    public MortgageValueAnnualRate(float minValueAnnualRate, float maxValueAnnualRate) {
        setMinAnnualRate(minValueAnnualRate);
        setMaxValueAnnualRate(maxValueAnnualRate);
    }
    public void annualInterestRate () {
        Scanner mortgage = new Scanner(System.in);
        System.out.printf("Annual Rate (%s - %s) ONLY: ", minValueAnnualRate, maxValueAnnualRate);

        while (!mortgage.hasNextFloat()) {
            System.out.printf("Input is not a number. Enter a number: ");
            mortgage.next();
        }

        annualInterestRate = mortgage.nextFloat();

        while (annualInterestRate < minValueAnnualRate || annualInterestRate > maxValueAnnualRate) {

            System.out.printf("WATRUDOIN I TOLD YA %s - %s", minValueAnnualRate, maxValueAnnualRate);

            System.out.print("\nAnnual Rate : ");

            while (!mortgage.hasNextFloat()) {
                System.out.printf("Input is not a number. Enter a number: ");
                mortgage.next();
            }
            annualInterestRate = mortgage.nextFloat();

        }

    }
    private void setMinAnnualRate(float minValueAnnualRate) {
        if (minValueAnnualRate <= 0.01) {
            throw new IllegalArgumentException("Annual Rate shouldn't be less or equal to 0.01 MF");
        }
        else {
            this.minValueAnnualRate = minValueAnnualRate;
        }
    }
    private void setMaxValueAnnualRate (float maxValueAnnualRate) {
        if (maxValueAnnualRate >= 30.0) {
            throw new IllegalArgumentException("Annual Rate shouldn't be more or equal to 30 MF");
        }
        else {
            this.maxValueAnnualRate = maxValueAnnualRate;
        }
    }
    public float getAnnualInterestRate() {
        return annualInterestRate;
    }
}
