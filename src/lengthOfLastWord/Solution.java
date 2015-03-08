public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.toLowerCase();
        int end = s.length() - 1;
        while (end >= 0 && (s.charAt(end) < 'a' || s.charAt(end) > 'z'))
            end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) >= 'a' && s.charAt(start) <= 'z')
            start--;
        return end - start;
    }
    public int lengthOfLastWord2(String s) {
        String[] split = s.split(" +");
        if (split.length == 0) {
            return 0;
        } else {
            return split[split.length - 1].length();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int i;
        i = s.lengthOfLastWord("Hello world");
        System.out.println(i);
        i = s.lengthOfLastWord("Hello world  ");
        System.out.println(i);
        i = s.lengthOfLastWord("Hello worldac  ");
        System.out.println(i);
    }
}