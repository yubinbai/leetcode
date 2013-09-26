package leetcode.partition.painter;

/**
 * You have to paint N boards of length {A0, A1, A2 … AN-1}. There are K
 * painters available and you are also given how much time a painter takes to
 * paint 1 unit of board. You have to get this job done as soon as possible
 * under the constraints that any painter will only paint continuous sections of
 * board, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4,
 * 5}.
 */
public class PartitionPainter {
    static int sum(int A[], int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += A[i];
        return total;
    }

    /**
     * brute force solution
     *
     * M[n, k] = min { max { M[j, k-1], sum(A j to n-1) } }
     *
     * @param A
     * @param n
     * @param k
     * @return
     */
    static int partition(int A[], int n, int k) {
        if (k == 1)
            return sum(A, 0, n - 1);
        if (n == 1)
            return A[0];

        int best = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++)
            best = Math.min(best,
                            Math.max(partition(A, j, k - 1), sum(A, j, n - 1)));

        return best;
    }

    public static int shortestTime(int[] data, int k) {

        return partition(data, data.length, k);
    }

    /**
     * DP solution
     *
     * @param data
     * @param i
     * @return
     */
    static int MAX_N = 100;

    public static int shortestTime2(int[] A, int k) {
        int[][] Memo = new int[MAX_N + 1][MAX_N + 1];
        int sumTill[] = new int[MAX_N + 1];
        int n = A.length;

        for (int i = 1; i <= n; i++)
            sumTill[i] = sumTill[i - 1] + A[i - 1];

        for (int i = 1; i <= n; i++)
            Memo[i][1] = sumTill[i];
        for (int i = 1; i <= k; i++)
            Memo[1][i] = A[0];

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int best = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++) {
                    best = Math.min(best,
                                    Math.max(Memo[p][i - 1], sumTill[j] - sumTill[p]));
                }
                Memo[j][i] = best;
            }
        }
        return Memo[n][k];
    }
}
