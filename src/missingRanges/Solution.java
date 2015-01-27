import java.util.*;
public class Solution {
    public List<String> findMissingRanges(int[] vals, int start, int end) {
        ArrayList<String> ret = new ArrayList<String>();
        String first = validRange(start - 1, vals[0]);
        if (first != null) ret.add(first);
        for (int i = 1; i < vals.length; ++i) {
            String curr = validRange(vals[i - 1], vals[i]);
            if (curr != null) ret.add(curr);
        }
        String last = validRange(vals[vals.length - 1], end + 1);
        if (last != null) ret.add(last);
        return ret;
    }
    public String validRange(int a, int b) {
        if (b - a > 1) {
            int left = a + 1;
            int right = b - 1;
            if (left == right) {
                return String.format("%d", left);
            } else {
                return String.format("%d->%d", left, right);
            }
        } else {
            return null;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> sa = s.findMissingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99);
        for (String str : sa) {
            System.out.println(str);
        }
    }
}