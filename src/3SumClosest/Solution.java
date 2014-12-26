import java.util.*;
public class Solution {
    public int threeSumClosest(int[] num, int target) {

        Arrays.sort(num);
        int result = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < num.length - 2; i++) {
            int k = i + 1;
            int l = num.length - 1;
            while (k < l) {
                int curr = num[i] +  num[k] + num[l];
                int dist = Math.abs(curr - target);
                if (dist < minDist) {
                    minDist = dist;
                    result = curr;
                }
                if (curr > target) {
                    l--;
                } else {
                    k++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { -1, 2, 1, -4};
        int target = 1;
        System.out.println(s.threeSumClosest(arr, 1));
    }
}
