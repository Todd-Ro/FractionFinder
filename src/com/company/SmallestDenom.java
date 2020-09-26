package com.company;

public class SmallestDenom {
    /*Finds the fraction with the smallest numerator and denominator that approximates an input with a given level of
    accuracy.
     */

    /*
	1*pi = 3; 3/1 = 5% error
	4*pi = 13; 13/4 = 3% error
	5*pi = 16; 16/5 = 2% error
	6*pi = 19; 19/6 = 1% error
	7*pi = 22; 22/7 = 0.04% error

	pi      = 3.141593
	22/7    = 3.142857
	if 22/7 > pi, error = pi/(22/7) - 1
	22/7 > pi = FALSE; error = (22/7) / pi - 1 = 0.0004
	 */


    public static long[] smallFracImproper(double d, double errorTarget) {
        //Returns a fraction (first term numerator, second denominator) close in value to d
        //Intended for use when d is larger than 1
        //Third term in returned array is error in ten thousandths
        double error;
        long numer = Math.round(d);
        if (numer > d) {error = numer/d - 1;}
        else {error = d/numer - 1;}
        long denom = 1;
        double approx = (double)numer;
        while (error > errorTarget) {
            denom++;
            numer = Math.round(d*denom);
            approx = ((double)numer/denom);
            if (approx > d) {error = approx/d - 1;}
            else {error = d/approx - 1;}
        }
        long errorTenThousandths = Math.round(error*10000);
        return new long[] {numer, denom, errorTenThousandths};
    }


    public static long[] smallFracImproper(double d) {
        //Returns a fraction (first term numerator, second denominator) close in value to d
        //Intended for use when d is larger than 1
        //Uses 0.25% target accuracy by default
        return smallFracImproper(d, 0.0025);
    }

    public static long[] smallFracProper(double d, double errorTarget) {
        //Returns a fraction (first term numerator, second denominator) close in value to d
        //Intended for use when d is between 0 and 1
        //Third term in returned array is error in ten thousandths
        if (d == 0) {
            return new long[] {0, 1, 0};
        }
        double error;
        long numer = 1;
        long denom = Math.round(1/d);
        double approx = 1/((double) denom);
        if (approx > d) {error = approx/d - 1;}
        else {error = d/approx - 1;}
        while (error > errorTarget) {
            numer++;
            denom = Math.round(numer/d);
            approx = ((double)numer/denom);
            if (approx > d) {error = approx/d - 1;}
            else {error = d/approx - 1;}
        }
        long errorTenThousandths = Math.round(error*10000);
        return new long[] {numer, denom, errorTenThousandths};
    }

    public static long[] smallFracProper(double d) {
        //Returns a fraction (first term numerator, second denominator) close in value to d
        //Intended for use when d is between 0 and 1
        //Uses 0.25% target accuracy by default
        return smallFracProper(d, 0.0025);
    }


}
