public class Solution2 {

    public double findMedianSortedArrays(int[] a, int[] b) {
        int size = a.length + b.length;
        if (size == 0) return 0.0;
        if (a.length == 0) return simpleMedian(b);
        if (b.length == 0) return simpleMedian(a);
        if (size % 2 == 0) {
            int m1 = findK(a, b, 0, a.length - 1, size / 2);
            int m2 = findK(a, b, 0, a.length - 1, size / 2 + 1);
            return (.0 + m1 + m2) / 2.0;
        } else {
            return findK(a, b, 0, a.length - 1, size / 2 + 1);
        }
    }

    private double simpleMedian(int[] a) {
        int n = a.length;
        if (n % 2 == 0) {
            return (0.0 + a[n / 2 - 1] + a[n / 2]) / 2;
        } else {
            return a[n / 2];
        }
    }

    private int findK(int[] a, int[] b, int left, int right, int k) {
        int m = a.length, n = b.length;
        if (left > right) return findK(b, a, 0, n - 1, k);

        int i = left + (right - left) / 2;
        int j = k - 2 - i;
        boolean validLeft = (j < 0) || (j < n && a[i] >= b[j]);
        boolean validRight = (j >= n - 1) || (j + 1 >= 0 && a[i] <= b[j + 1]);

        if (validLeft && !validRight) return findK(a, b, left, i - 1, k);
        if (!validLeft && validRight) return findK(a, b, i + 1, right, k);

        return a[i];
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] A, B;

        A = new int[] {1, 2, 3, 5, 6 , 7};
        B = new int[] {4};
        System.out.println(s.findMedianSortedArrays(A, B));

        A = new int[] {1};
        B = new int[] {2, 3, 4, 5, 6};
        System.out.println(s.findMedianSortedArrays(A, B));

        A = new int[] {1, 2, 3};
        B = new int[] {4, 5, 6};
        System.out.println(s.findMedianSortedArrays(A, B));

        A = new int[] {1, 3, 4};
        B = new int[] {2, 5, 5, 5};
        System.out.println(s.findMedianSortedArrays(A, B));

        A = new int[] {1};
        B = new int[] {1};
        System.out.println(s.findMedianSortedArrays(A, B));

        A = new int[] {1, 2};
        B = new int[] {1, 2};
        System.out.println(s.findMedianSortedArrays(A, B));

        A = new int[] {};
        B = new int[] {1, 2};
        System.out.println(s.findMedianSortedArrays(A, B));
    }

}