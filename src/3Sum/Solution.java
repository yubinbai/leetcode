import java.util.*;
public class Solution {
  public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    int n = num.length;

    for (int i = 0; i < n - 2; i++) {
      if (i > 0 && num[i] == num[i - 1]) continue;
      int low = i + 1;
      int high = n - 1;

      while (low < high) {
        int sum = num[i] + num[low] + num[high];

        if (sum > 0) {
          while (high > 0 && num[high] == num[high - 1]) high--;
          high--;
        } else if (sum < 0) {
          while (low < n - 1 && num[low] == num[low + 1]) low++;
          low++;
        } else {
          ret.add(Arrays.asList(num[i], num[low], num[high]));
          while (high > 0 && num[high] == num[high - 1]) high--;
          high--;
          while (low < n - 1 && num[low] == num[low + 1]) low++;
          low++;
        }
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr;
    arr = new int[] { -1, 0, 1, 2, -1, -4};
    for (List<Integer> a : s.threeSum(arr)) {
      System.out.println(a);
    }
    arr = new int[] { 0, 0, 0, 0};
    for (List<Integer> a : s.threeSum(arr)) {
      System.out.println(a);
    }
  }
}
