package com.gethigh;

import java.util.Scanner;

public class MortgageValuePeriod {
    private static byte minValuePeriod;
    private static byte maxValuePeriod;
    public void valuePeriodMinMax (byte minValuePeriod, byte maxValuePeriod) {
        setMinValuePeriod(minValuePeriod);
        setMaxValuePeriod(maxValuePeriod);
    }
    public static byte periodYears () {

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
}
