public class Solution {
    public boolean isNumber(String s) {
        char[] str = s.trim().toCharArray();
        if (str.length == 0) return false;

        boolean dotUsed = false;
        boolean expUsed = false;
        boolean hasPrimary = false;
        boolean hasExponent = false;

        int pos = 0;
        if (str[0] == '+' || str[0] == '-') {
            pos = 1;
        }
        for (; pos < str.length; pos++) {
            char c = str[pos];
            if (c == '+' || c == '-') {
                return false;
            } else if (c == '.') {
                if (dotUsed || expUsed) {
                    return false;
                } else {
                    dotUsed = true;
                }
            } else if (c == 'e' || c == 'E') {
                if (expUsed) {
                    return false;
                } else {
                    expUsed = true;
                    if (pos + 1 < str.length) {
                        if (str[pos + 1] == '+' || str[pos + 1] == '-') {
                            pos++;
                        }
                    }
                }
            } else if (c >= '0' && c <= '9') {
                if (expUsed) {
                    hasExponent = true;
                } else {
                    hasPrimary = true;
                }
            } else {
                return false;
            }
        }

        return hasPrimary && (expUsed == hasExponent);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] tests = {
            "-1.",
            " ",
            "6+1",
            "0",
            " 0.1 ",
            "abc",
            "1 a",
            "2e10",
            "2e1.0",
            "e",
            "000123e-2",
        };
        for (String str : tests) {
            System.out.println(s.isNumber(str));
        }
    }
}