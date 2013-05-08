package algorithms.string.longest.palindrome.substring;

/**
 * Given a string S, find the longest palindromic substring
 * 
 * 
 * 
 */
public class PalindromeSubstring {

	public static String longest(String s) {
		int n = s.length();
		if (n == 0)
			return "";
		String longest = s.substring(0, 1); 

		for (int i = 0; i < n - 1; i++) {
			String p1 = expandAroundCenter(s, i, i);
			if (p1.length() > longest.length())
				longest = p1;

			String p2 = expandAroundCenter(s, i, i + 1);
			if (p2.length() > longest.length())
				longest = p2;
		}
		return longest;
	}

	private static String expandAroundCenter(String str, int c1, int c2) {
		int l = c1, r = c2;
		int n = str.length();
		char[] s = str.toCharArray();
		while (l >= 0 && r <= n - 1 && s[l] == s[r]) {
			l--;
			r++;
		}
		return String.copyValueOf(s, l + 1, r - l - 1);
	}
}
