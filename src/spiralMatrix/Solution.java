import java.util.*;
public class Solution {
    int[][] matrix;
    int n, m;
    List<Integer> result;
    public List<Integer> spiralOrder(int[][] matrix) {
        result = new ArrayList<Integer>();
        this.matrix = matrix;
        n = matrix.length;
        if (n == 0) return result;
        m = matrix[0].length;
        if (m == 0) return result;
        int size = Math.min(m, n);

        for (int i = 0; i <= size / 2; i++) {
            _getLayer(i);
        }

        return result;
    }
    private void _getLayer(int k) {
        int bottom = n - k;
        int right = m - k;
        if (bottom <= k || right <= k) return;

        if (bottom - 1 == k) {
            for (int j = k; j < right; j++) {
                result.add(matrix[k][j]);
            }
            return;
        }
        if (right - 1 == k) {
            for (int i = k; i < bottom; i++) {
                result.add(matrix[i][k]);
            }
            return;
        }
        for (int j = k; j < right; j++) {
            result.add(matrix[k][j]);
        }
        for (int i = k + 1; i < bottom; i++) {
            result.add(matrix[i][right - 1]);
        }
        for (int j = right - 2; j >= k; j--) {
            result.add(matrix[bottom - 1][j]);
        }
        for (int i = bottom - 2; i > k; i--) {
            result.add(matrix[i][k]);
        }
    }
    public static void main(String[] args) {
        int[][] matrix;
        Solution s = new Solution();

        matrix = new int[][] {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(s.spiralOrder(matrix));

        matrix = new int[][] {{ 2, 5 }, { 8, 4 }, { 0, -1 } };
        System.out.println(s.spiralOrder(matrix));

        matrix = new int[][] {{ -1 }};
        System.out.println(s.spiralOrder(matrix));
    }
}