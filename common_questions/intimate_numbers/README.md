Problem
===

find intimate number under 5e6

factors of 220： 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110
factors of 284： 1, 2, 4, 71, 142


Sum of factors: f(n)

f(220) => 284
f(f(220)) => f(284) => 220

Solution
===

Like prime sieve, do the factors of each number in O(n logn) (result of harmonic sum)

