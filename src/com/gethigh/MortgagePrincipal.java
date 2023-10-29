package com.gethigh;
import java.util.Scanner;
public class MortgagePrincipal {
    private int minValuePrincipal;
    private int maxValuePrincipal;
    private boolean gotPrincipal = false;
    private int valuePrincipal;

    public MortgagePrincipal (int minValuePrincipal, int maxValuePrincipal) {
        setMinValuePrincipal(minValuePrincipal);
        setMaxValuePrincipal(maxValuePrincipal);
    }
    public void valuePrincipal () {

        if (!gotPrincipal) {

            Scanner mortgage = new Scanner(System.in);
            System.out.printf("Principal (%s - %s) ONLY: ", minValuePrincipal, maxValuePrincipal);

            while (!mortgage.hasNextInt()) {
                System.out.printf("Input is not a number. Enter a number: ");
                mortgage.next();
            }

            valuePrincipal = mortgage.nextInt();

            while (valuePrincipal < minValuePrincipal || valuePrincipal > maxValuePrincipal) {

                System.out.printf("WATRUDOIN I TOLD YA %s - %s", minValuePrincipal, maxValuePrincipal);

                System.out.printf("\nPrincipal (%s - %s) ONLY: ", minValuePrincipal, maxValuePrincipal);

                while (!mortgage.hasNextInt()) {
                    System.out.printf("Input is not a number. Enter a number: ");

                    mortgage.next();

                }
                valuePrincipal = mortgage.nextInt();

            }
            gotPrincipal = true;
        }

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
    public int getValuePrincipal() {
        return valuePrincipal;
    }
}
