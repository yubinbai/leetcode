Problem
===
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

    For example, given:
    S: "barfoothefoobarman"
    L: ["foo", "bar"]

    You should return the indices: [0,9].
    (order does not matter).

Solution
===

Backtrack, use hashMap and counter to reduce string comparison