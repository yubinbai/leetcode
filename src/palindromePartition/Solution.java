import java.util.*;
public class Solution {
    ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
    Stack<String> curr = new Stack<String>();

    public ArrayList<ArrayList<String>> partition(String s) {
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int step) {
        if (step == s.length()) {
            ArrayList<String> arr = new ArrayList<String>();
            for (String str : curr) arr.add(str);
            ret.add(arr);
            return;
        }
        for (int i = step + 1; i <= s.length(); i++) {
            String sub = s.substring(step, i);
            if (isPalindrome(sub)) {
                curr.push(sub);
                dfs(s, i);
                curr.pop();
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partition("aab"));
    }
}