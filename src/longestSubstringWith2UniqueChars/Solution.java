public class Solution {
    public static String subString(String s) {
        if (s.length() <= 2) {
            return s;
        }
        char[] sa = s.toCharArray();
        char c1 = sa[0], c2 = 0;
        int cnt1 = 1, cnt2 = 0;
        int left = 0, right = 1;
        int maxLen = right - left + 1, maxLeft = 0, maxRight = right;
        for (; right < sa.length; ++right) {
            if (sa[right] == c1) {
                cnt1++;
                if (cnt1 + cnt2 > maxLen) {
                    maxLen = cnt1 + cnt2;
                    maxLeft = left;
                    maxRight = right;
                }
            } else if (sa[right] == c2) {
                cnt2++;
                if (cnt1 + cnt2 > maxLen) {
                    maxLen = cnt1 + cnt2;
                    maxLeft = left;
                    maxRight = right;
                }
            } else if (c2 == 0) {
                c2 = sa[right];
                cnt2 = 1;
            } else {
                while (c1 != sa[right] && c2 != sa[right]) {
                    if (sa[left] == c1) {
                        cnt1 --;
                        if (cnt1 == 0) {
                            cnt1 = 1;
                            c1 = sa[right];
                        }
                        left++;
                    } else if (sa[left] == c2) {
                        cnt2 --;
                        if (cnt2 == 0) {
                            cnt2 = 1;
                            c2 = sa[right];
                        }
                        left++;
                    } else {
                        break; // shouldn't be here
                    }
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subString("aaabbcccbdddadaacb"));
        System.out.println(s.subString("bccbbbbcccbdddadacb"));
        System.out.println(s.subString("bbbbbbbbbbbbbb"));
    }
}