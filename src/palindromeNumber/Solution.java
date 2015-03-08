public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int p10 = 1;
        while (x / p10 >= 10) {
            p10 *= 10;
        }
        // System.out.println(p10);
        while (x > 0) {
            int left = x / p10;
            int right = x % 10;
            if (left != right) return false;
            x %= p10;
            x /= 10;
            p10 /= 100;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(101));
        System.out.println(s.isPalindrome(1));
        System.out.println(s.isPalindrome(0));
        System.out.println(s.isPalindrome(1001));
        System.out.println(s.isPalindrome(1234));
        System.out.println(s.isPalindrome(1221));
        System.out.println(s.isPalindrome(-1221));
    }
}