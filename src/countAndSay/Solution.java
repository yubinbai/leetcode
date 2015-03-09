import java.util.*;
public class Solution {
    public String countAndSay(int n) {
        if (n < 0) return "";
        char[] original = new char[] { '1' };
        StringBuilder sb = null;

        for (int i = 1; i < n; i++) {
            sb = new StringBuilder();
            int len = original.length;
            int begin = 0;

            for (int j = 1; j <= len; j++)
                if (j == len || original[j] != original[begin]) {
                    sb.append(String.format("%d", (j - begin)));
                    sb.append(original[begin]);
                    begin = j;
                }
            original = sb.toString().toCharArray();
        }
        return new String(original);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 10; ++i) {
            System.out.format("%d\t%s\n", i, s.countAndSay(i));
        }
    }
}