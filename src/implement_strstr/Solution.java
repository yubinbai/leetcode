public class Solution {
    public int strStr(String haystack, String needle) {

        int needleLen = needle.length();
        int haystackLen = haystack.length();

        if (needleLen == 0) return 0;
        if (haystackLen == 0) return -1;

        for (int i = 0; i <= haystackLen - needleLen; i++) {
            int k = i, j = 0;
            while (j < needleLen && k < haystackLen && needle.charAt(j) == haystack.charAt(k)) {
                j++;
                k++;
                if (j == needleLen) return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("helllo", "ll"));
    }

}