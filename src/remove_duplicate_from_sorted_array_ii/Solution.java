public class Solution {
    public int removeDuplicates(int[] A) {
        int i = 0, j = 1;
        if (A.length <= 1) return A.length;
        while (j < A.length) {
            if (A[i] == A[j] && (i != 0 && A[i] == A[i - 1])) {
                j++;
            } else {
                i++;
                A[i] = A[j];
                j++;
            }
        }
        return i + 1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr;
        arr = new int[] {1, 1, 1, 1, 2, 2, 2, 3};
        System.out.println(s.removeDuplicates(arr));
        for (int i : arr) {
            System.out.format("_%d", i);
        }
        arr = new int[] {};
        System.out.println(s.removeDuplicates(arr));
        arr = new int[] {1, 2};
        System.out.println(s.removeDuplicates(arr));
        for (int i : arr) {
            System.out.format("_%d", i);
        }
    }
}