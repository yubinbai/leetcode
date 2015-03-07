public class Solution {
    public int removeElement(int[] A, int elem) {
        int i = -1, j = 0;
        while (j < A.length) {
            if (A[j] != elem) {
                i++;
                A[i] = A[j];
                j++;
            } else {
                j++;
            }
        }
        return i + 1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1, 2, 2, 3, 4, 5, 6, 1, 2, 2, 7};
        for (int i : A) {
            System.out.format("%d ", i);
        }
        System.out.format("\nlen = %d\n", s.removeElement(A, 2));
        for (int i : A) {
            System.out.format("%d ", i);
        }
    }
}