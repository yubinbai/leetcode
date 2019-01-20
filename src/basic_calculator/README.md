Problem
===

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

	Some examples:
	"1 + 1" = 2
	" 2-1 + 2 " = 3
	"(1+(4+5+2)-3)+(6+8)" = 23

Note: Do not use the eval built-in library function.


Solution
===

solution 1: use a stack of parens to track the current sign of number

solution 2: Convert to postfix and evaluate that

[Wikipedia] (http://en.wikipedia.org/wiki/Shunting-yard_algorithm)
