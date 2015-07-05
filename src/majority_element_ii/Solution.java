import java.util.*;

public class Solution {
  public List<Integer> majorityElement(int[] nums) {

    List<Integer> ret = new ArrayList<>();
    int n= nums.length;
    if (n <= 1) {
      for (int v : nums) ret.add(v);
      return ret;
    }

    int v1 = 0, c1 = 0;
    int v2 = 0, c2 = 0;
    for (int v : nums) {
      if (v == v1) {
        c1++;
      } else if (v == v2) {
        c2++;
      } else if (c1 == 0) {
        v1 = v;
        c1 = 1;
      } else if (c2 == 0) {
        v2 = v;
        c2 = 1;
      } else {
        c1--;
        c2--;
      }
    }
    c1 = c2 = 0;
    for (int v : nums) {
      if (v == v1) c1++;
      else if (v == v2) c2++;
    }
    if (c1 > n / 3) ret.add(v1);
    if (c2 > n / 3) ret.add(v2);
    return ret;
  }
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1, 2, 3, 1, 1};
    System.out.println(s.majorityElement(nums));
  }
}
