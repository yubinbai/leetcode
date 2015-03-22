public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        if (m == 0) return simpleMedian(B);
        if (n == 0) return simpleMedian(A);
        return medianSearch(A, B, Math.max(0, (m + n) / 2 - n), Math.min(m - 1, (m + n) / 2));
    }

    public double medianSearch(int A[], int B[], int left, int right) {
        int m = A.length, n = B.length;
        if (left > right) return medianSearch(B, A, Math.max(0, (m + n) / 2 - m), Math.min(n - 1, (m + n) / 2));
        int i = (left + right) / 2;
        int j = (m + n) / 2 - i - 1;
        boolean validLeft = (j < 0) || (A[i] >= B[j]);
        boolean validRight = (j >= n - 1) || (A[i] <= B[j + 1]);

        if (validLeft && !validRight) {
            return medianSearch(A, B, left, i - 1);
        } else if (!validLeft && validRight) {
            return medianSearch(A, B, i + 1, right);
        }

        // median is found
        if ((m + n) % 2 == 1) return A[i];
        if (i > 0) {
            int pre = (j < 0) ? A[i - 1] : Math.max(A[i - 1], B[j]);
            return (A[i] + pre) / 2.0;
        } else {
            return (A[i] + B[j]) / 2.0;
        }
    }

    public double simpleMedian(int A[]) {
        int n = A.length;
        if (n % 2 == 1) return A[n / 2];
        return (A[n / 2 - 1] + A[n / 2]) / 2.0;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A, B;

        A = new int[] {1, 2, 3};
        B = new int[] {4, 5, 6};
        System.out.println(s.findMedianSortedArrays(A, B));

        A = new int[] {1, 3, 4};
        B = new int[] {2, 5, 5, 5};
        System.out.println(s.findMedianSortedArrays(A, B));

        A = new int[] {1};
        B = new int[] {1};
        System.out.println(s.findMedianSortedArrays(A, B));
    }

}
