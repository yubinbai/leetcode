import java.util.*;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums.length == 0) return list;
        int prev = nums[0];       
        int curr = prev;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curr + 1) {
                curr++;
            } else {
                if (prev == curr) {
                    list.add(String.format("%d", prev));
                } else {
                    list.add(String.format("%d->%d", prev, curr));
                }
                prev = nums[i];
                curr = nums[i];
            }
        }
        if (prev == curr) {
            list.add(String.format("%d", prev));
        } else {
            list.add(String.format("%d->%d", prev, curr));
        }
        return list;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,2,4,5,7};
        Solution s = new Solution();
        s.summaryRanges(nums).forEach(System.out::println);
    }
}