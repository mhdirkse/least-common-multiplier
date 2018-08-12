package com.github.mhdirkse.westit.lcm;

import javax.inject.Named;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

@Api(
    name = "comGithubMhdirkseWestitLcm",
    version = "v1",
    description = "Get least common multiplier for divisors 1 ... maxDivisor",
    scopes = "675305326748-87vcq89jpncl2cuv1siook8j395m0jrc.apps.googleusercontent.com"
)
public class LeastCommonMultiplier {
  @ApiMethod(name = "getLeastCommonMultiplier", path = "getLeastCommonMultiplier")
  public Result getLeastCommonMultiplier(final User user, @Named("maxDivisor") int maxDivisor) {
	  return new Result("Ran doSomething" + new Integer(maxDivisor).toString());
  }
}
