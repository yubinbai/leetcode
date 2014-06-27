import java.util.*;
public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
    public int largestRectangleAreaWrongAnswer(int[] height) {
        int size = height.length;
        if (size == 0) return 0;
        if (size == 1) return height[0];
        int ret = 0;
        for (int left = 0; left < size; left++) {
            if (left + 1 < size && height[left] >= height[left + 1]) continue;
            int min = height[left];
            for (int len = 1; (len + left - 1) < size; len++) {
                min = Math.min(min, height[len + left - 1]);
                ret = Math.max(ret, min * len);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] ar = {1, 1};
        // int[] ar = {2,1,5,6,2,3};
        // int[] ar = new int[20000];
        // for (int i = 0; i < 20000; i++) {
        //     ar[i] = i;
        // }
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(ar));
    }
}