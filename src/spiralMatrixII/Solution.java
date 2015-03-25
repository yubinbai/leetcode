import java.util.*;
public class Solution {
    int[][] result;
    int curr = 1;
    int n = 0;
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        this.n = n;
        result = new int[n][n];
        for (int i = 0; i <= n /2; i++) {
            setLayer(i);
        }
        return result;
    }
    private void setLayer(int k) {
        int limit = n - k;
        for (int j = k; j < limit; ++j) {
            result[k][j] = curr;
            curr++;
        }
        for (int i = k + 1; i < limit; i++) {
            result[i][limit - 1] = curr;
            curr++;
        }
        for (int j = limit - 2; j >= k; j--) {
            result[limit - 1][j] = curr;
            curr++;
        }
        for (int i = limit - 2; i > k; i--) {
            result[i][k] = curr;
            curr++;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        for (int[] iter : s.generateMatrix(3) ) {
            for (int a : iter) {
                System.out.format("%d ", a);
            }
            System.out.println("");
        }
        System.out.println(s.generateMatrix(0));
    }
}