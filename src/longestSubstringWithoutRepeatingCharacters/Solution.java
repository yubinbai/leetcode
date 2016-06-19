public class Solution {

  public static int lengthOfLongestSubstring(String str) {
    char[] s = str.toCharArray();
    int left = 0, right = 0;
    int maxLen = 0;
    boolean seen[] = new boolean[256];
    while (right < s.length) {
      if (seen[s[right]]) {
        maxLen = Math.max(maxLen, right - left);
        while (s[left] != s[right]) {
          seen[s[left]] = false;
          left++;
        }
        left++;
      } else {
        seen[s[right]] = true;
      }
      right++;
    }
    maxLen = Math.max(maxLen, s.length - left);
    return maxLen;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(s.lengthOfLongestSubstring("bbbbb"));
  }
}
