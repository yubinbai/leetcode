import java.util.*;

public class Solution {
	class Token {
		char c;
		int n;
		boolean isNumber;
		public Token() {}
	}
	public int calculate(String s) {
		Stack<Token> operator = new Stack<Token>();
		List<Token> postfix = new ArrayList<Token>();
		for (Token e : getTokens(s)) {
			if (e.isNumber) {
				postfix.add(e);
			} else {
				if (e.c == ')') {
					while (!operator.isEmpty() && operator.peek().c != '(') {
						postfix.add(operator.pop());
					}
					operator.pop();
				} else if (e.c == '(') {
					operator.push(e);
				} else {
					while (!operator.isEmpty() && operator.peek().c != '(') {
						postfix.add(operator.pop());
					}
					operator.push(e);
				}
			}
		}
		while (!operator.isEmpty() && operator.peek().c != '(') {
			postfix.add(operator.pop());
		}
		return evalPostfix(postfix);
	}
	public int evalPostfix(List<Token> tokens) {
		Stack<Integer> s = new Stack<Integer>();
		for (Token t : tokens) {
			if (t.isNumber) {
				s.push(t.n);
			} else {
				int a = s.pop();
				int b = s.pop();
				if (t.c == '+') {
					s.push(a + b);
				} else {
					s.push(b - a);
				}
			}
		}
		return s.peek();
	}
	public List<Token> getTokens(String s) {
		s = s.replaceAll(" ", "");
		List<Token> tokens = new ArrayList<Token>();
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				sb.append(c);
			} else {
				if (sb.length() > 0) {
					Token en = new Token();
					en.isNumber = true;
					en.n = Integer.parseInt(sb.toString());
					tokens.add(en);
					sb = new StringBuilder();
				}
				Token e = new Token();
				e.isNumber = false;
				e.c = c;
				tokens.add(e);
			}
		}
		if (sb.length() > 0) {
			Token en = new Token();
			en.isNumber = true;
			en.n = Integer.parseInt(sb.toString());
			tokens.add(en);
			sb = new StringBuilder();
		}
		return tokens;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.calculate("1 + 1"));
		System.out.println(s.calculate(" 2-1 + 2 "));
		System.out.println(s.calculate(" 2-(1 + 2) "));
		System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
	}
}