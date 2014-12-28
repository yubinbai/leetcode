public class Solution {
    public int titleToNumber(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret *= 26;
            ret += s.charAt(i) - 'A' + 1;
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%d\n", s.titleToNumber("A"));
        System.out.format("%d\n", s.titleToNumber("AA"));
        System.out.format("%d\n", s.titleToNumber("AB"));
        System.out.format("%d\n", s.titleToNumber("AAA"));
    }
}