import java.util.*;
public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                int t = stack.pop();
                int curr = h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, curr);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // int[] ar = {1, 1};
        int[] ar = {2, 1, 5, 6, 2, 3};
        // int[] ar = new int[20000];
        // for (int i = 0; i < 10000; i++) {
        //     ar[i] = i;
        // }
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(ar));
    }
}