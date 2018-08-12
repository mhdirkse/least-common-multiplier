package com.github.mhdirkse.westit.lcm;

import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Some tests to see that JUnit itself behaves as expected.
 * @author martijn
 *
 */
public class TestTest {
	@Test
	public void whenMatchersContainsSeesWrongSequenceThenNoError() {
		Assert.assertThat(Arrays.asList(1, 2),
				CoreMatchers.hasItems(2, 1));
	}
}
