public class Solution {
    public boolean canJump(int[] A) {
        int curr = A[0];
        for (int i = 0; i < A.length; i++)
            if (i > curr) {
                return false;
            } else {
                curr = Math.max(curr, i + A[i]);
            }
        return curr >= A.length - 1;
    }
}