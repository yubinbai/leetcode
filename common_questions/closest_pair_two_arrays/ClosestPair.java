class ClosestPair {

    void printClosest(int ar1[], int ar2[], int x) {
        int diff = Integer.MAX_VALUE;
        int res_l = -1, res_r = -1;
        int m = ar1.length;
        int n = ar2.length;

        int l = 0, r = n - 1;
        while (l < m && r >= 0) {
            if (Math.abs(ar1[l] + ar2[r] - x) < diff) {
                res_l = l;
                res_r = r;
                diff = Math.abs(ar1[l] + ar2[r] - x);
            }

            if (ar1[l] + ar2[r] > x) r--;
            else l++;
        }

        System.out.format("The closest pair is [%d, %d] \n", res_l, res_r);
    }

    public static void main(String[] args) {

        int[] ar1 = {1, 4, 5, 7};
        int[] ar2 = {10, 20, 30, 40};
        int x = 33;
        ClosestPair cp = new ClosestPair();
        cp.printClosest(ar1, ar2, x);
    }
}
