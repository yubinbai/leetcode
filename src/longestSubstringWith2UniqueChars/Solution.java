public class Solution {
    public static String subString(String s) {
        if (s.length() <= 2) {
            return s;
        }
        char[] sa = s.toCharArray();
        char c1 = sa[0], c2 = sa[1];
        int cnt1 = 1, cnt2 = 0;
        int left = 0, right = 1;
        for (; right < sa.length; right++) {
            if (sa[right] == c1) {
                cnt1++;
            } else {
                cnt2 = 1;
                c2 = sa[right];
                break;
            }
        }
        if (right == sa.length) {
            right = sa.length - 1;
        }
        int ret = right - left + 1, retLeft = 0, retRight = right + 1;
        for (; right < sa.length; ++right) {
            if (sa[right] == c1) {
                // expand the window
                cnt1++;
                if (cnt1 + cnt2 > ret) {
                    ret = cnt1 + cnt2;
                    retLeft = left;
                    retRight = right + 1;
                }
            } else if (sa[right] == c2) {
                // expand the window
                cnt2++;
                if (cnt1 + cnt2 > ret) {
                    ret = cnt1 + cnt2;
                    retLeft = left;
                    retRight = right + 1;
                }
            } else {
                // move the left of the window
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
        return s.substring(retLeft, retRight);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subString("accbbbbcccbdddadacb"));
        System.out.println(s.subString("bccbbbbcccbdddadacb"));
        System.out.println(s.subString("bbbbbbbbbbbbbb"));
    }
}