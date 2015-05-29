import java.util.*;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        for (int i : nums) {
            if (set.contains(i)) return true;
            if (q.size() == k && k != 0) {
                int old = q.pollFirst();
                set.remove(old);
            }
            if (k != 0) {
                set.add(i);
                q.add(i);
            }
        }        
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums;
        int k;

        nums = new int[] {1, 2, 3, 1};
        k = 2;
        System.out.println(s.containsNearbyDuplicate(nums, k));

        nums = new int[] {1, 2, 3, 1, 4, 5};
        k = 3;
        System.out.println(s.containsNearbyDuplicate(nums, k));

        nums = new int[] {1, 2, 3, 1, 4, 5};
        k = 0;
        System.out.println(s.containsNearbyDuplicate(nums, k));
    }
}