import java.util.*;
public class Solution {
    String[] keypad = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ret;
    char[] curr, digits;
    public List<String> letterCombinations(String digits) {
        this.digits = digits.toCharArray();
        curr = new char[digits.length()];
        ret = new ArrayList<String>();
        solve(0);
        return ret;
    }
    private void solve(int step) {
        if (step == curr.length) {
            ret.add(new String(curr));
            return;
        }
        String currStep = keypad[digits[step] - '0'];
        for (int i = 0; i < currStep.length(); ++i) {
            curr[step] = currStep.charAt(i);
            solve(step + 1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        for (String str : s.letterCombinations("23")) {
            System.out.println(str);
        }
    }
}