package com.github.mhdirkse.westit.lcm;

import java.math.BigInteger;
import java.util.Arrays;

import javax.inject.Named;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

/**
 * This class calculates the least common multiplier for some numbers 1 ... maxCommonDivisor.
 * For example, the least common multiplier of 1, 2, 3 and 4 is 12, not 24.
 * <p>
 * The implementation is based on the following. Let n1 and n2 be two numbers that
 * can be factored into primes as n1 = p1^x1 * ... * pk^xk and
 * n2 = p1^y1 * ... * pk^yk. Then the least common multiplier of n1 and n2 is
 * p1^(max(x1, y1)) * ... * pk^(max(xk, yk)). To summarize, for each
 * prime we do not need all occurrences we find in m and n, only the maximum
 * over n1 and n2 is needed. This principle also applies for z
 * numbers n1, n2, ... nz where z >= 3.
 * <p>
 * This is implemented as follows. Initially, an array is created with divisors
 * 2 ... maxCommonDivisor. For maxCommonDivisor == 4 this would be [2, 3, 4].
 * <p>
 * Then each element is processed in turn. After processing divisors 2 ... k, the
 * least common multiplier of 2 ... k is the product of the array elements of corresponding
 * to these divisors. The remaining elements are the original divisors divided by
 * the prime factors already covered.
 * <p>
 * As an example, we calculate the least common multiplier of 1, 2, 3, 4, starting with
 * array [2, 3, 4].
 * <p>
 * After processing 2, we have [2, 3, 2]. The first element corresponds to divisor 2.
 * The value 2 tells us that the least common multiplyer of 1 and 2 is 2. The value 3 is
 * not divisible by 2, so we must keep number 3. The number 4 is divisible by 2. When
 * we want the least common multiplier of 4, we already have one of the prime factors 2.
 * We only have to keep one of the two factors 2, which is 2.
 * <p>
 * Processing 3 gives no change, we still have [2, 3, 2], but the meaning has changed.
 * Now we know that 2 is the least common multiplier of 1 and 2, and also that 2 * 3 is
 * the least common multiplier of 1, 2 and 3.
 * <p>
 * Processing 4 is an empty operation because 4 is the last element. We now also know
 * that 2 * 3 * 2 is the least common multiplier of 1, 2, 3 and 4.
 * @author martijn
 *
 */
@Api(
    name = "comGithubMhdirkseWestitLcm",
    version = "v1",
    description = "Get least common multiplier for divisors 1 ... maxDivisor"
)
public class LeastCommonMultiplier {
  @ApiMethod(name = "getLeastCommonMultiplier", path = "getLeastCommonMultiplier")
  public Result getLeastCommonMultiplier(final User user, @Named("maxDivisor") int maxDivisor) {
	  Factors factors = new Factors(maxDivisor);
	  factors.processAll();
	  BigInteger result = factors.factorsAsBigInteger()
			  .stream().reduce(BigInteger.ONE, (a, b) -> a.multiply(b));
	  return new Result(result.toString());
  }
}
