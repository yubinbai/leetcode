import java.util.*;
public class Solution {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }
        int ret = 0;
        while (!set.isEmpty()) {
            Iterator<Integer> it = set.iterator();
            int center = it.next();
            int left = center - 1, right = center;
            while (set.contains(right)) {
                set.remove(right);
                right++;
            }
            while (set.contains(left)) {
                set.remove(left);
                left--;
            }
            ret = Math.max(ret, right - left - 1);
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }
}