import java.util.*;
public class Solution {
    public void nextPermutation(int[] num) {
        int n = num.length;
        if (n <= 1) return;
        int low = n - 2, high = n - 1;
        while (num[low] >= num[high]) {
            if (low == high - 1) {
                low--;
                high = n - 1;
                if (low == -1) break; // end of permutation 
            } else {
                high--;
            }
        }
        if (low != -1) {
            swap(num, low, high);
        }
        int left = low + 1, right = n - 1;
        while (left < right) {
            swap(num, left, right);
            left++;
            right--;
        }
    }
    private void swap(int[] num, int i, int j) {
        int swap = num[i];
        num[i] = num[j];
        num[j] = swap;
    }
    public static void main(String[] args) {
        int[] seq = new int[] {1, 2, 2, 3};
        Solution s = new Solution();
        s.nextPermutation(seq);
        for (int i : seq) {
            System.out.format("%d ", i);
        }
    }
}