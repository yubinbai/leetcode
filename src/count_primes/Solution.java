public class Solution {
    static int[] counts = {0, 0, 0, 1, 2, 2};
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        if (n <= 5) return counts[n];
        boolean[] primes = calcPrimes(n - 1);
        int counter = 0;
        for (boolean p : primes) {
            if (p) counter++;
        }
        return counter;
    }
    /**
     * Function to calculate all primes <= n
     */
    private boolean[] calcPrimes(int limit) {
        /** initialize the sieve **/
        boolean[] prime = new boolean[limit + 1];
        prime[2] = true;
        prime[3] = true;
        int root = (int) Math.ceil(Math.sqrt(limit));

        /** put in candidate primes:
         integers which have an odd number of
         representations by certain quadratic forms **/
        for (int x = 1; x < root; x++) {
            for (int y = 1; y < root; y++) {
                int n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    prime[n] = !prime[n];
                n = 3 * x * x + y * y;
                if (n <= limit && n % 12 == 7)
                    prime[n] = !prime[n];
                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11))
                    prime[n] = !prime[n];
            }
        }
        /** eliminate composites by sieving, omit multiples of its square **/
        for (int i = 5; i <= root; i++)
            if (prime[i])
                for (int j = i * i; j < limit; j += i * i)
                    prime[j] = false;

        return prime;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPrimes(2));
        System.out.println(s.countPrimes(10));
        System.out.println(s.countPrimes(11));
        System.out.println(s.countPrimes(1000));
        System.out.println(s.countPrimes(10000));
        System.out.println(s.countPrimes(100000));
        System.out.println(s.countPrimes(1000000));
        System.out.println(s.countPrimes(10000000));
        // System.out.println(s.countPrimes(100000000));
    }
}