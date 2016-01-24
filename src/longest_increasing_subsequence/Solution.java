import java.util.*;
class Solution {
  /**
   * O (n log k)
   * @param  array [description]
   * @return       [description]
   */
  public int longestIncreasingSubseq(int[] array) {
    int n = array.length;
    // m[j] — stores the position k of the smallest value X[k]
    // such that there is an increasing subsequence of length j
    // ending at X[k] on the range k ≤ i
    List<Integer> m = new ArrayList<Integer>();
    m.add(0);
    // P[k]  — stores the position of the predecessor of X[k] in the longest increasing
    // subsequence ending at X[k].
    int[] p = new int[n];
    p[0] = -1;
    for (int i = 1; i < n; i++) {
      if (array[m.get(m.size() - 1)] < array[i]) {
        p[i] = m.get(m.size() - 1);
        m.add(i);
      } else {
        int low = 0, high = m.size() - 1;
        while (low < high) {
          int mid = low + (high - low) / 2;
          if (array[m.get(mid)] < array[i]) {
            low = mid + 1;
          } else {
            high = mid;
          }
        }
        if (array[i] < array[m.get(low)]) {
          if (low > 0) {
            p[i] = m.get(low - 1);
          }
          m.set(low, i);
        }
      }
    }
    List<Integer> result = new ArrayList<Integer>();
    int curr = m.get(m.size() - 1);
    while (curr >= 0) {
      result.add(array[curr]);
      curr = p[curr];
    }
    Collections.reverse(result);
    System.out.println(result);
    return m.size();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] array;

    array = new int[] {1, 3, 2, 5, 10};
    System.out.println(s.longestIncreasingSubseq(array));

    array = new int[] {1, 2, 3, 4, 5};
    System.out.println(s.longestIncreasingSubseq(array));
  }
}
