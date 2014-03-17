import java.util.Arrays;
public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i - 1] < ratings[i])
                left[i] = left[i - 1] + 1;
        }
        for (int i = len - 2; i > -1; i--) {
            if (ratings[i + 1] < ratings[i])
                right[i] = right[i + 1] + 1;
        }
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += Math.max(left[i], right[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] rat = {1, 2, 2};
        Solution s = new Solution();
        System.out.println(s.candy(rat));
    }
}