Problem
===
A pile of nuts is in an oasis, across a desert from a town. The pile contains
‘N’ kg of nuts, and the town is ‘D’ kilometers away from the pile.
 
The goal of this problem is to write a program that will compute ‘X’, the
maximum amount of nuts that can be transported to the town.

The nuts are transported by a horse drawn cart that is initially next to the
pile of nuts. The cart can carry at most ‘C’ kilograms of nuts at any one
time. The horse uses the nuts that it is carrying as fuel. It consumes ‘F’
kilograms of nuts per kilometer traveled regardless of how much weight it is
carrying in the cart. The horse can load and unload the cart without using up
any nuts.

Your program should have a function that takes as input 4 real numbers
D,N,F,C and returns one real number: ‘X’

Since we are consuming the nuts at a constant rate, eventually we will reach
one such transit point where just enough nuts are consumed such that transporting
nuts to the next transit point requires one less round trip.
