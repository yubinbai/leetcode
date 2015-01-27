public class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^0-9a-zA-Z]", "").toUpperCase();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(s.isPalindrome("1a2"));
        System.out.println(s.isPalindrome("race a car"));
    }
}