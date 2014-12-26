public class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" +");
        if (split.length == 0) {
            return 0;
        } else {
            return split[split.length - 1].length();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.lengthOfLastWord("Hello world");
        System.out.println(i);
    }
}