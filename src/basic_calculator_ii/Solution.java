import java.util.*;

public class Solution {

	public int calculate(String s) {
		StringTokenizer tokens = new StringTokenizer('+' + s.replace(" ", "") + "+0", "+-*/", true);
		long total = 0, term = 0;
		while (tokens.hasMoreTokens()) {
			String op = tokens.nextToken();
			if ("+-".contains(op)) {
				total += term;
				term = (op.equals("+") ? 1 : -1) * Long.parseLong(tokens.nextToken());
			} else {
				long n = Long.parseLong(tokens.nextToken());
				if (op.equals("*")) {
					term *= n;
				} else {
					term /= n;
				}
			}
		}
		return (int)total;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.calculate("3+2*2"));
		System.out.println(s.calculate(" 2-1 + 2 "));
		System.out.println(s.calculate(" 3+5 / 2 "));
		System.out.println(s.calculate(" 0-2147483648"));
		System.out.println(s.calculate("1/2/3"));
		System.out.println(s.calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
	}
}