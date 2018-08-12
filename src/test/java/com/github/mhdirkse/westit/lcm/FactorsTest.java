package com.github.mhdirkse.westit.lcm;

import java.math.BigInteger;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class FactorsTest {
	@Test
	public void whenMax3ThenFactors2and3() {
		Factors instance = new Factors(3);
		int[] factors = instance.factors;
		Assert.assertEquals(2, factors.length);
		Assert.assertEquals(2, factors[0]);
		Assert.assertEquals(3, factors[1]);
	}

	@Test
	public void whenMax2ThenOneFactor2() {
		Factors instance = new Factors(2);
		int[] factors = instance.factors;
		Assert.assertEquals(1, factors.length);
		Assert.assertEquals(2, factors[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenMaxLt1ThenError() {
		new Factors(1);
	}

	@Test
	public void whenFactorsAre234thenProcessing2Gives232() {
		Factors instance = new Factors(4);
		instance.process(2);
		Assert.assertEquals(3, instance.factors.length);
		Assert.assertEquals(2, instance.factors[0]);
		Assert.assertEquals(3, instance.factors[1]);
		Assert.assertEquals(2, instance.factors[2]);
	}

	@Test
	public void whenFactorsHave2To8ThenProcessingGives2And2And4() {
		Factors instance = new Factors(8);
		instance.process(2);
		Assert.assertEquals(2, instance.factors[0]);
		Assert.assertEquals(2, instance.factors[2]);
		Assert.assertEquals(4, instance.factors[6]);
	}

	@Test
	public void whenFactorsHave2To8ThenProcessingTwiceGives2And2And2() {
		Factors instance = new Factors(8);
		instance.process(2);
		instance.process(4);
		Assert.assertEquals(2, instance.factors[0]);
		Assert.assertEquals(2, instance.factors[2]);
		Assert.assertEquals(2, instance.factors[6]);
	}

	@Test
	public void processingLastDivisorDoesNoHarm() {
		Factors instance = new Factors(2);
		instance.process(2);
		Assert.assertEquals(2, instance.factors[0]);
	}

	@Test
	public void processAllVisitsAllFactors() {
		Factors instance = new Factors(6);
		instance.processAll();
		Assert.assertEquals(5, instance.lastProcessed);
		Assert.assertEquals(5, instance.factors.length);
		Assert.assertEquals(2, instance.factors[0]);
		Assert.assertEquals(3, instance.factors[1]);
		Assert.assertEquals(2, instance.factors[2]);
		Assert.assertEquals(5, instance.factors[3]);
		Assert.assertEquals(1, instance.factors[4]);
	}

	@Test
	public void factorsAsBigIntegers() {
		Factors instance = new Factors(3);
		List<BigInteger> actual = instance.factorsAsBigInteger();
		Assert.assertEquals(2, actual.size());
		Assert.assertThat(actual.get(0), CoreMatchers.isA(BigInteger.class));
		Assert.assertEquals(2, actual.get(0).intValue());
		Assert.assertEquals(3, actual.get(1).intValue());
	}
}
