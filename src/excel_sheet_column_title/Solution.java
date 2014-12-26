public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n >= 1) {
            n--; // convert to zero start
            sb.append((char) ('A' + n % 26));
            n /= 26;
            if (n == 0) break;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%s\n", s.convertToTitle(1));
        System.out.format("%s\n", s.convertToTitle(2));
        System.out.format("%s\n", s.convertToTitle(3));
        System.out.format("%s\n", s.convertToTitle(27));
        System.out.format("%s\n", s.convertToTitle(28));
        System.out.format("%s\n", s.convertToTitle(27 + 26));
        System.out.format("%s\n", s.convertToTitle(26 * 26 + 1));
        System.out.format("%s\n", s.convertToTitle(26 * 27 + 1));
    }
}