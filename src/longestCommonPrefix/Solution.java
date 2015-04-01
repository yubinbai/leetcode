public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = prefix(result, strs[i]);
        }
        return result;
    }
    public String prefix(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length());
        int i = 0;
        for (; i < n; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) break;
        }
        return s1.substring(0, i);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] list = new String[] {"aaa", "aab", "abb"};
        String result = s.longestCommonPrefix(list);
        System.out.println(result);
    }
}