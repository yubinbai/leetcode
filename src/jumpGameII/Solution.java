public class Solution {
    public int jump(int[] A) {
        int n = A.length;
        int ans = 0, curr = 0, next = 0;
        for (int i = 0; i < n; ++i) {
            if (i > next) return -1;
            if (i > curr) {
                ans++;
                curr = next;
            }
            next = Math.max(next, i + A[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(s.jump(new int[] {1, 0, 1, 1, 4}));
    }
}