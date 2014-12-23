public class Solution {
    public int maximumGap(int[] num) {
        if (num.length < 2) return 0;
        radixSort(num);
        int ret = Integer.MIN_VALUE;
        for (int i = 1; i < num.length; ++i) {
            ret = Math.max(ret, num[i] - num[i - 1]);
        }
        return ret;
    }

    /**
     * radix sort
     * @param a [description]
     */
    public void radixSort(int[] a) {

        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[n];

        for (i = 1; i < n; i++) {
            if (a[i] > m) m = a[i];
        }

        while (m / exp > 0) {

            int[] bucket = new int[10];
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;

            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];

            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];

            for (i = 0; i < n; i++)
                a[i] = b[i];

            exp *= 10;

        }

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.maximumGap(new int[] {15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740});
        System.out.format("%d\n", r);
    }
}
