package com.github.mhdirkse.westit.lcm;

import org.junit.Assert;
import org.junit.Test;

public class LeastCommonMultiplierTest {
	@Test
	public void testLcmOf1to4Is12() {
		LeastCommonMultiplier instance = new LeastCommonMultiplier();
		Result result = instance.getLeastCommonMultiplier(null, 4);
		Assert.assertEquals(12, Integer.valueOf(result.getMessage()).intValue());
	}
}
