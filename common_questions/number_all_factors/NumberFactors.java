import java.util.*;
public class NumberFactors {
	Stack<Integer> stack;
	public void printFactors(int number) {
		stack = new Stack<Integer>();
		System.out.println(Arrays.asList(1, number));
		printFactorsHelper(number);
	}

	private void printFactorsHelper(int n) {
		int start = stack.isEmpty() ? 2 : stack.peek();
		for (int f = start; f <= Math.sqrt(n); f++) {
			if (n % f == 0 && n / f >= f) {
				stack.push(f);
				printFactorsHelper(n / f);
				stack.pop();
			}
		}
		if (!stack.isEmpty()) {
			stack.push(n);
			System.out.println(stack);
			stack.pop();
		}
	}
	public static void main(String[] args) {
		NumberFactors n = new NumberFactors();
		// n.printFactors(-10);
		n.printFactors(18);
		// n.printFactors(32);
	}
}
