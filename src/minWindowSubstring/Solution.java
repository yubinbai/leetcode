import java.util.*;
public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        HashMap<Character, Integer> curr = new HashMap<Character, Integer>();
        for (char c : T.toCharArray()) {
            _increase(target, c);
        }
        int left = 0, right = 0;
        String ans = "";
        while (right < S.length()) {
            char c = S.charAt(right);
            _increase(curr, c);
            if (valid(target, curr)) {
                while (left < right) {
                    char remove = S.charAt(left);
                    if (!target.containsKey(remove) ||
                            curr.get(remove) > target.get(remove)) {
                        _decrease(curr, remove);
                        left++;
                    } else {
                        break;
                    }
                }
                if (ans.length() == 0 || right - left + 1 < ans.length()) {
                    ans = S.substring(left, right + 1);
                }
            }
            right++;
        }
        return ans;
    }
    private void _increase(HashMap<Character, Integer> curr, char c) {
        if (curr.containsKey(c)) {
            curr.put(c, curr.get(c) + 1);
        } else {
            curr.put(c, 1);
        }
    }
    private void _decrease(HashMap<Character, Integer> curr, char c) {
        Integer count = curr.get(c);
        if (count == 1) {
            curr.remove(c);
        } else if (count != null ) {
            curr.put(c, count - 1);
        }
    }
    private boolean valid (HashMap<Character, Integer> target, HashMap<Character, Integer> curr) {
        for (char c : target.keySet()) {
            if (!curr.containsKey(c) || curr.get(c) < target.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s, t;
        s = "ADOBECODEBANC";
        t = "ABC";
        System.out.println(sol.minWindow(s, t));
        s = "ab";
        t = "a";
        System.out.println(sol.minWindow(s, t));
    }
}