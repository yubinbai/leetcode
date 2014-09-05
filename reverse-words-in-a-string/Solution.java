public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        if (words.length == 0) return "";
        if (words.length == 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            String w = words[i].trim();
            if (w.length() > 0) {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        sb.append(words[0]);
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("\"%s\"\n", s.reverseWords("the sky is blue"));
        System.out.format("\"%s\"\n", s.reverseWords(" 1"));
        System.out.format("\"%s\"\n", s.reverseWords("   a   b "));
    }
}