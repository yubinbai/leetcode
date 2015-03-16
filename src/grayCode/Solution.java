import java.util.*;
public class Solution {
	public List<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		if (n == 0) return result;
		for (int i = 0; i < n; i++) {
			int len = result.size();
			for (int j = len - 1; j >= 0; j--) {
				result.add( (1 << i) | result.get(j));
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.grayCode(0));
		System.out.println(s.grayCode(1));
		System.out.println(s.grayCode(2));
		System.out.println(s.grayCode(3));
	}
}