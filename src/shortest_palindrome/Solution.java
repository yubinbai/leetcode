import java.util.*;

public class Solution {
    public String shortestPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return constructPalin(sb.toString());
    }

    private String constructPalin(String s) {
        int n = s.length();
        if (n == 1) return s;
        char[] sa = Arrays.copyOf(s.toCharArray(), n * 2);
        int currLen = 2 * n;
        String result = "";

        // odd
        OUT1: for (int i = n / 2; i < n; i++) {
            int low = i - 1, high = i + 1;
            while (low >= 0 && high < 2 * n && high - low + 1 < currLen) {
                if (high < n && sa[low] != sa[high]) {
                    break;
                } else {
                    sa[high] = sa[low];
                    if (low == 0) {
                        currLen = high - low + 1;
                        result = new String(sa, 0, currLen);
                        break OUT1;
                    }
                    low--;
                    high++;
                }
            }
        }

        // even
        OUT2: for (int i = n / 2; i < n; i++) {
            int low = i - 1, high = i;
            while (low >= 0 && high < 2 * n && high - low + 1 < currLen) {
                if (high < n && sa[low] != sa[high]) {
                    break;
                } else {
                    sa[high] = sa[low];
                    if (low == 0) {
                        currLen = high - low + 1;
                        result = new String(sa, 0, currLen);
                        break OUT2;
                    }
                    low--;
                    high++;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.shortestPalindrome("a"));

        System.out.println(s.shortestPalindrome("abcd"));

        System.out.println(s.shortestPalindrome("aacecaaa"));

        // char[] sa = new char[40000];
        // Arrays.fill(sa, 'a');
        // sa[20000] = 'c';
        // sa[20001] = 'd';
        // System.out.println(s.shortestPalindrome(new String(sa)));
    }
}