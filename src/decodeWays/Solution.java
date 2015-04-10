public class Solution {
    public int numDecodings(String s) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0) return 0;
        char[] a = s.toCharArray();
        if (n == 1) return check(a[0]);

        int fn = 0;
        int fn_1 = check(a[0]) * check(a[1]) + check(a[0], a[1]);
        int fn_2 = check(a[0]);
        for (int i = 2; i < s.length(); i++) {
            if (check(a[i]) == 1) fn += fn_1;
            if (check(a[i - 1], a[i]) == 1) fn += fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
            fn = 0;
        }
        return fn_1;
    }
    private int check(char one) {
        return (one != '0') ? 1 : 0;
    }
    private int check(char one, char two) {
        return (one == '1' || (one == '2' && two <= '6')) ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("12"));
        System.out.println(sol.numDecodings("121"));
        System.out.println(sol.numDecodings("10"));
        System.out.println(sol.numDecodings("0"));
    }
}
