Problem
===
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

Solution
===

Group strings by their char counts, an easy way to implement is to sort the char array of the string and use this as key of hash map.