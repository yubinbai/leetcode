Problem
===
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:

	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

Solution
===

Maintain a stack of numbers

when getting an operator from list, pop two numbers and evaluate

push result to stack

Last remaining number is the answer

[wiki]: http://en.wikipedia.org/wiki/Reverse_Polish_notation#Postfix_algorithm