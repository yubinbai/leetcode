import java.util.*;
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;
        int left = 0, right = n * m - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midV = matrix[mid / m][mid % m];
            if (midV >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return matrix[left / m][left % m] == target;
    }

    public static void main(String[] args) {
        // int[][] data = {
        //     {1,   3,  5,  7},
        //     {10, 11, 16, 20},
        //     {23, 30, 34, 50}
        // };
        int[][] data = new int[1][20000];
        for (int i = 1; i <= 20000; i++) data[0][i - 1] = i;
        Solution s = new Solution();
        System.out.println(s.searchMatrix(data, 10));
        System.out.println(s.searchMatrix(data, -1));
        System.out.println(s.searchMatrix(data, 20000));
    }
}