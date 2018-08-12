package com.github.mhdirkse.westit.lcm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Factors {
	final int[] factors;
	int lastProcessed = 0;

	Factors(final int maxDivisor) {
		if(maxDivisor <= 1) {
			throw new IllegalArgumentException("The algorithm is not applicable for max divisor <= 1: "
					+ Integer.valueOf(maxDivisor).toString());
		}
		factors = setInitialFactors(maxDivisor);
	}

	private int[] setInitialFactors(final int maxDivisor) {
		int[] result = new int[maxDivisor - 1];
		for(int d = 2; d <= maxDivisor; ++d) {
			result[d-2] = d;
		}
		return result;
	}

	void process(int divisor) {
		int index = divisor - 2;
		int newlyCovered = factors[index];
		for (int nextIndex = index+1; nextIndex < factors.length; ++nextIndex) {
			if((factors[nextIndex] % newlyCovered) == 0) {
				factors[nextIndex] = factors[nextIndex] / newlyCovered;
			}
		}
		lastProcessed = divisor;
	}

	void processAll() {
		for(int index = 0; index < (factors.length - 1); ++index) {
			process(index + 2);
		}
	}

	List<BigInteger> factorsAsBigInteger() {
		List<BigInteger> result = new ArrayList<BigInteger>(factors.length);
		for (int f : factors) {
			result.add(BigInteger.valueOf(f));
		}
		return result;
	}
}
