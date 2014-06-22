import java.util.*;
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;
        int[] firsts = new int[n];
        for (int i = 0; i < n; i++) {
            firsts[i] = matrix[i][0];
        }
        int pos = Arrays.binarySearch(firsts, target);
        if (pos >= 0) {
            return true;
        } else {
            pos = (-1) * pos - 1;
            if (pos == 0) {
                return false;
            } else {
                return (Arrays.binarySearch(matrix[pos - 1], target) >= 0);
            }
        }
    }

    public static void main(String[] args) {
        int[][] data = {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        // int[][] data = new int[1][20000];
        // for (int i = 1; i <= 20000; i++) data[0][i - 1] = i;
        Solution s = new Solution();
        boolean b = s.searchMatrix(data, 5);
        System.out.println(b);
    }
}