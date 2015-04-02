public class Solution {
	public String intToRoman(int num) {
		String[] romanNumbers = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] val = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < romanNumbers.length; i++) {
			while (num >= val[i]) {
				sb.append(romanNumbers[i]);
				num -= val[i];
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.intToRoman(400));
		System.out.println(s.intToRoman(1980));
		System.out.println(s.intToRoman(3999));
	}
}

