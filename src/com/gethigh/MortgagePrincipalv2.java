package com.gethigh;

public class MortgagePrincipalv2 extends MortgagePrincipal {

    public MortgagePrincipalv2 (int minValuePrincipal, int maxValuePrincipal) {
        super(minValuePrincipal, maxValuePrincipal);
    }

    @Override
    public int getValuePrincipal() {

        return super.getValuePrincipal()*1000;
    }
}


