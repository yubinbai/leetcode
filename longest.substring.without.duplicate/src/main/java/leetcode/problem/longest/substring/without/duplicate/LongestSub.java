package leetcode.problem.longest.substring.without.duplicate;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * “abcabcbb” is “abc”, which the length is 3. For “bbbbb” the longest substring
 * is “b”, with the length of 1.
 * 
 */
public class LongestSub {

	public static int longest(String str) {
		// sliding window
		char[] s = str.toCharArray();
		int left = 0, right = 0;
		int maxLen = 0;
		boolean seen[] = new boolean[256];
		while (right < s.length) {
			if (seen[s[right]]) {
				maxLen = Math.max(maxLen, right - left);
				
				// slide to the first occurrence
				while (s[left] != s[right]) {
					seen[s[left]] = false;
					left++;
				}
				
				// start from new left value
				left++;
				right++;
			} else {
				seen[s[right]] = true;
				right++;
			}
		}
		maxLen = Math.max(maxLen, s.length - left);
		return maxLen;
	}
}
