package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
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

	double pi = Math.PI;
	long[] piApprox = SmallestDenom.smallFracImproper(pi);
	System.out.println(Arrays.toString(piApprox));

	double invPi = 1/Math.PI;
	long[] piInvApprox = SmallestDenom.smallFracProper(invPi);
	System.out.println(Arrays.toString(piInvApprox));

	double rootTwo = Math.sqrt(2);
	long[] rootTwoApprox = SmallestDenom.smallFracImproper(rootTwo, .0005);
	long[] rootTwoApproxAccur = SmallestDenom.smallFracImproper(rootTwo, .0002);
	System.out.println(Arrays.toString(rootTwoApprox));
	System.out.println(Arrays.toString(rootTwoApproxAccur));
	System.out.println(SmallestDenom.bestDenomsInRange(rootTwo, 89, 107, .0005));
	System.out.println(SmallestDenom.bestDenomsInRange(rootTwo, 89, 155, .0002));

	System.out.println();

	System.out.println((((double) 1) / 5) * ((double) 1) / 11); // Should be .018 with 18 repeating
	System.out.println((((double) 1) / 11) * ((double) 1) / 101); // Should be .0009 repeating
    }
}
