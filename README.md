# Least common multiplier API

This project calculates the least common multiplier of numbers 1 ... maxDivisor.
For example, the least common multiplier of 1, 2, 3 and 4 is 12, because 2\*6 = 12 and 3\*4 = 12. There can be no smaller number because 3 and 4 have no prime factors in common. I built this software for my job application at West IT in Delft. Wouter Eekhout, thanks for giving me this assignment and reviewing it.

I found the following answers:
* 1 ... 25 has least common multiplier 26771144400.
* 1 ... 100 has 69720375229712477164533808935312303556800.
* 1 ... 150 has 4963595372164418730243844250278933730416682962970482173955824000.

You can access this project by visiting `https://credible-nation-130012.appspot.com/_ah/api/explorer`. You will see that an API named `comGithubMhdirkseWestitLcm`. When you click on it, you see a method `comGithubMhdirkseWestitLcm.getLeastCommonMultiplier`. When you click on that as well, you can access it. You can give the maximum common divisor to consider and issue the HTTP request. The answer is a JSON message containing the least common divisor.

I did not manage to get the project working locally.

You can build the project using Maven. Do the following:
* Install Java and Maven.
* Run `curl https://sdk.cloud.google.com | bash`
* Restart your shell.
* Run `gcloud init` to initialize the gcloud environment.
* Unzip the source code of this project.
* Go to the root directory of that code and do "mvn clean appengine:deploy".
* Browse to `console.cloud.google.com` and select `MyProject`.
* Press the button to the top-left with three horizontal bars.
This is named "Products and services.
* Select `Home`. Check that this project has id `credible-nation-130012`.
* Go to AppEngine | Versions. Check that your version was deployed and that it
receives all the traffic. You can see this from the timestamp in the version
number. I admit that these version numbers are not as should be.
