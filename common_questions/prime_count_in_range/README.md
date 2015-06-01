Problem
===

Given ints *a* and *b*, how many primes are there in the interval [*a*, *b*) ?

	a < b <= 1e12
	b - a <= 1e6

Solution
===

all numbers small than *b* will have factors smaller than sqrt(b)

use sieve between a and b, for all primes in [ 2, sqrt(b) )
