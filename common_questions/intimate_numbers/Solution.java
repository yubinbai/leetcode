import java.util.*;
class Solution {

    public static void main(String[] args) {

        int i, j;
        int[] sum = new int[5000010];
        Arrays.fill(sum, 1);

        for (i = 2; i + i <= 5000000; i++) {
            j = i + i;
            // step width == 2 * i, harmonic sum
            while (j <= 5000000) {
                sum[j] += i;
                j += i;
            }
        }

        for (i = 220; i <= 5000000; i++) {
            if (sum[i] > i && sum[i] <= 5000000 && sum[sum[i]] == i) {
                System.out.format("%d %d\n", i, sum[i]);
            }
        }
    }
}
