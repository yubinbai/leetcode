Problem
===

Given a string, find the longest substring that contains only two unique characters. For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".

Solution
===
Two pointers slider, maintain a valid solution containing only two chars, by:

1. inc counter if char is like the two

2. remove until string contains the current char and the previous char