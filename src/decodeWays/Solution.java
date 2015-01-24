public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return check(s.charAt(0));
        if (s.charAt(0) == '0') return 0;
        int fn = 0, fn_1 = 0, fn_2 = 1;
        // n == 2 at start
        fn_1 = (check(s.charAt(0)) * check(s.charAt(1))) + check(s.charAt(0), s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (check(s.charAt(i)) == 1) fn += fn_1;
            if (check(s.charAt(i - 1), s.charAt(i)) == 1) fn += fn_2;
            if (fn == 0) return 0;
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
    }

}
