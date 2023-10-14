package com.gethigh;

import java.util.Scanner;

public class MortgagePrincipal {

    private static int minValuePrincipal;
    private static int maxValuePrincipal;
    private static boolean gotPrincipal = false;
    private static int principal;


    public void valuePrincipalMinMax (int minValuePrincipal, int maxValuePrincipal) {
        setMinValuePrincipal(minValuePrincipal);
        setMaxValuePrincipal(maxValuePrincipal);
    }
    public int valuePrincipal () {

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
}
