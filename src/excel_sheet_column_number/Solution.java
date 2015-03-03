public class Solution {
    public int titleToNumber(String s) {
        int ret = 0;
        for (char c : s.toCharArray()) {
            ret *= 26;
            ret += c - 'A' + 1;
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